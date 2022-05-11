package vn.liquor.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.liquor.service.UserService;
import vn.liquor.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/account/ban" })
public class AccountBanController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7927090617717495402L;
	UserService accountService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		accountService.ban(Integer.parseInt(uid));
		resp.sendRedirect(req.getContextPath() + "/admin/account");
	}
}
