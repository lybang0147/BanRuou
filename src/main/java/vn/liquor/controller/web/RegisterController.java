package vn.liquor.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.liquor.model.AccountModel;
import vn.liquor.service.UserService;
import vn.liquor.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5038666259477800325L;
	UserService userservice = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String usn = req.getParameter("username");
		String pwn = req.getParameter("password");
		String rpwn = req.getParameter("rpassword");
		System.out.print("/" + usn + "/");
		AccountModel nacc = userservice.checkuser(usn);

		if (nacc == null) {
			AccountModel acc = new AccountModel();
			acc.setUsername(usn);
			acc.setIsAdmin(0);
			acc.setIsSeller(0);
			acc.setStatus(0);
			acc.setPassword(pwn);
			userservice.register(acc);
			req.setAttribute("alert", "1");
			req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
			// resp.sendRedirect(req.getContextPath() +"/login");
		} else {
			req.setAttribute("alert", "0");
			req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
			// resp.sendRedirect(req.getContextPath() +"/login");
		}
	}
}
