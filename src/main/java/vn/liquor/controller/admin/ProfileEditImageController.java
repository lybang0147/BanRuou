package vn.liquor.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.liquor.model.AccountDetailModel;
import vn.liquor.model.AccountModel;
import vn.liquor.service.UserService;
import vn.liquor.service.impl.UserServiceImpl;
import vn.liquor.util.Constant;

@WebServlet(urlPatterns = { "/admin/profile-editimage" })
public class ProfileEditImageController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6779412071794227186L;
	UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		AccountModel a = (AccountModel) session.getAttribute("acc");
		AccountDetailModel accountDetailModel = userService.layaccountdetail(a.getUid());
		req.setAttribute("accountdetail", accountDetailModel);
		req.getRequestDispatcher("/views/admin/admin-profile.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		AccountModel a = (AccountModel) session.getAttribute("acc");
		AccountDetailModel accountDetailModel = new AccountDetailModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				accountDetailModel.setUid(a.getUid());
				if (item.getFieldName().equals("imageLink")) {
					if (item.getSize() > 0) {// neu co file d
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/user/" + fileName);
						item.write(file);
						accountDetailModel.setImageLink("user/" + fileName);
					} else {
						accountDetailModel.setImageLink(null);
					}
				}
				userService.editdetailimage(accountDetailModel);
				resp.sendRedirect(req.getContextPath() + "/admin/profile-check");
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
