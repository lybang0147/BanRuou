package vn.liquor.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.liquor.model.AccountDetailModel;
import vn.liquor.model.AccountModel;
import vn.liquor.model.CityModel;
import vn.liquor.service.CityService;
import vn.liquor.service.UserService;
import vn.liquor.service.impl.CityServiceImpl;
import vn.liquor.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/checkout" })
public class CheckoutController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3615243394670480662L;
	UserService userService = new UserServiceImpl();
	CityService cityservice = new CityServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession httpSession = req.getSession();
		Object cart = httpSession.getAttribute("cart");
		AccountModel users = (AccountModel) httpSession.getAttribute("acc");
		List<CityModel> list = cityservice.getallcity();
		if (users == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			AccountDetailModel account = userService.layaccountdetail(users.getUid());
			req.setAttribute("listcity", list);
			req.setAttribute("account", account);
			req.getRequestDispatcher("/views/web/Checkout.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String cityid = req.getParameter("selectcity");
		CityModel city = cityservice.getcitybyid(Integer.parseInt(cityid));
		HttpSession httpSession = req.getSession();
		Object cart = httpSession.getAttribute("cart");
		AccountModel users = (AccountModel) httpSession.getAttribute("acc");
		List<CityModel> list = cityservice.getallcity();
		if (users == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			AccountDetailModel account = userService.layaccountdetail(users.getUid());
			req.setAttribute("listcity", list);
			req.setAttribute("city", city);
			req.setAttribute("account", account);
			req.getRequestDispatcher("/views/web/Checkout.jsp").forward(req, resp);
		}
	}
}
