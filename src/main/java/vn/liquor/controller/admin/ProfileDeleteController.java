package vn.liquor.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.liquor.service.UserService;
import vn.liquor.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/profile-delete" })
public class ProfileDeleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2259565262295779552L;
	UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		userService.deletedetail(Integer.parseInt(uid));
		resp.sendRedirect(req.getContextPath() + "/admin/profile-check");
	}
}
