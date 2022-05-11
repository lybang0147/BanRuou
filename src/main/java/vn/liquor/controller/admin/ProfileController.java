package vn.liquor.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.liquor.model.AccountDetailModel;
import vn.liquor.model.AccountModel;
import vn.liquor.service.UserService;
import vn.liquor.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/profile" })
public class ProfileController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4612012659745576816L;

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
		
	}
}
