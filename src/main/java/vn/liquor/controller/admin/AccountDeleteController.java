package vn.liquor.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.liquor.service.UserService;
import vn.liquor.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/account/delete" })
public class AccountDeleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2980998341429980674L;
	UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		userService.delete(Integer.parseInt(uid));
		resp.sendRedirect(req.getContextPath() + "/admin/account");
	}

}
