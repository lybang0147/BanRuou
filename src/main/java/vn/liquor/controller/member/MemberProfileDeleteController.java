package vn.liquor.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.liquor.service.UserService;
import vn.liquor.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/member/profile-delete" })
public class MemberProfileDeleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8821989814930570739L;
	UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		userService.deletedetail(Integer.parseInt(uid));
		resp.sendRedirect(req.getContextPath() + "/member/profile");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
