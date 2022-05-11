package vn.liquor.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.liquor.model.AccountModel;
import vn.liquor.model.CartModel;
import vn.liquor.model.CategoryModel;
import vn.liquor.model.OrderModel;
import vn.liquor.model.SellerModel;
import vn.liquor.service.CartItemService;
import vn.liquor.service.CartService;
import vn.liquor.service.CategoryService;
import vn.liquor.service.OrderService;
import vn.liquor.service.SellerService;
import vn.liquor.service.impl.CartItemServiceImpl;
import vn.liquor.service.impl.CartServiceImpl;
import vn.liquor.service.impl.CategoryServiceImpl;
import vn.liquor.service.impl.OrderServiceImpl;
import vn.liquor.service.impl.SellerServiceImpl;

@WebServlet(urlPatterns = { "/member/order" })
public class MemberOrderController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 977703950028003958L;
	CartItemService cartitemservice = new CartItemServiceImpl();
	OrderService orderservice = new OrderServiceImpl();
	CategoryService cateservice = new CategoryServiceImpl();
	CartService cartservice = new CartServiceImpl();
	SellerService sellerservice = new SellerServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession sess = req.getSession();
		AccountModel acc = (AccountModel) sess.getAttribute("acc");
		System.out.print(acc);
		List<CategoryModel> listcate = cateservice.getallCate();
		req.setAttribute("listcate", listcate);
		List<OrderModel> listorder = orderservice.getorderbyuid(acc.getUid());
		System.out.print("/////" + listorder.size() + "//////");
		List<CartModel> listcart = cartservice.getcartbyuid(acc.getUid());
		if (listorder.size() > 0) {
			req.setAttribute("listorder", listorder);
			req.setAttribute("listcart", listcart);
			CartModel cart = listcart.get(0);
			req.setAttribute("fcart", cart);
			req.setAttribute("alert", 1);
			req.getRequestDispatcher("/views/member/ordermember.jsp").forward(req, resp);
		} else {
			req.setAttribute("alert", 0);
			req.getRequestDispatcher("/views/member/ordermember.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession sess = req.getSession();
		AccountModel acc = (AccountModel) sess.getAttribute("acc");
		System.out.print(acc);
		List<CategoryModel> listcate = cateservice.getallCate();
		req.setAttribute("listcate", listcate);
		List<OrderModel> listorder = orderservice.getorderbyuid(acc.getUid());
		List<CartModel> listcart = cartservice.getcartbyuid(acc.getUid());
		req.setAttribute("listorder", listorder);
		List<SellerModel> listseller = sellerservice.getallseller();
		req.setAttribute("listseller", listseller);
		for (CartModel cartModel : listcart) {
			System.out.print(cartModel);
		}
		req.setAttribute("listcart", listcart);
		String cid = req.getParameter("cid");
		System.out.print(cid);
		req.setAttribute("idcart", cid);
		req.setAttribute("alert", 2);
		req.getRequestDispatcher("/views/member/ordermember.jsp").forward(req, resp);
	}
}
