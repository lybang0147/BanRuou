package vn.liquor.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.liquor.service.UserService;
import vn.liquor.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/account/unban" })
public class AccountUnbanController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -823459361257416051L;
	UserService accountService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		accountService.unban(Integer.parseInt(uid));
		resp.sendRedirect(req.getContextPath() + "/admin/account");
	}
}
