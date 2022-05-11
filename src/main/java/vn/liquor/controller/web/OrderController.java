package vn.liquor.controller.web;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.liquor.model.AccountDetailModel;
import vn.liquor.model.AccountModel;
import vn.liquor.model.BillModel;
import vn.liquor.model.CartItemModel;
import vn.liquor.model.CartModel;
import vn.liquor.model.CityModel;
import vn.liquor.service.BillService;
import vn.liquor.service.CartItemService;
import vn.liquor.service.CartService;
import vn.liquor.service.ProductService;
import vn.liquor.service.impl.BillServiceImpl;
import vn.liquor.service.impl.CartItemServiceImpl;
import vn.liquor.service.impl.CartServiceImpl;
import vn.liquor.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/order" })
public class OrderController extends HttpServlet {

	/**
	 * 
	 */
	CartService cartservice = new CartServiceImpl();
	BillService billservice = new BillServiceImpl();
	CartItemService cartitemservice = new CartItemServiceImpl();
	ProductService productservice = new ProductServiceImpl();
	private static final long serialVersionUID = -6962844042815948817L;

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession sess = req.getSession();
		Object cart = sess.getAttribute("cart");
		AccountDetailModel accdetail = (AccountDetailModel) sess.getAttribute("accdetail");
		String subtotal = req.getParameter("subtotal");
		String total = req.getParameter("total");
		String payment = req.getParameter("optradio");

		AccountModel users = (AccountModel) sess.getAttribute("acc");

		CityModel city = (CityModel) sess.getAttribute("city");
		if (users == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			try {
				Date date = new Date();
				long ID = new Date().getTime();
				System.out.print("//////" + users + "/////\n");
				System.out.print("//////" + date + "/////");
				CartModel cartModel = new CartModel();
				cartModel.setId(String.valueOf(ID));
				cartModel.setBuyer(users);
				cartModel.setBuyDate(date);
				cartModel.setTotal(Integer.parseInt(total));
				cartservice.insert(cartModel);
				System.out.print(cartModel);
				Map<Integer, CartItemModel> map = (Map<Integer, CartItemModel>) cart;
				for (Entry<Integer, CartItemModel> item : map.entrySet()) {
					cartitemservice.insert(new CartItemModel(cartModel, item.getValue().getProduct(),
							item.getValue().getUnitPrice(), item.getValue().getQuantity(),
							item.getValue().getQuantity() * item.getValue().getUnitPrice(), 0));
					productservice.updateamount(item.getValue().getProduct().getProductId(), cartModel.getId());
				}
				BillModel bill = new BillModel();
				bill.setCart(cartModel);
				bill.setCity(city);
				bill.setEmail(accdetail.getImageLink());
				bill.setFulladdress(accdetail.getDiachi());
				bill.setFullname(accdetail.getFullname());
				bill.setPayment(payment);
				bill.setPhonenumber(accdetail.getSdt());
				System.out.print("//////" + bill + "/////");
				billservice.insert(bill);
				// Cap nhat lai Session
				sess.removeAttribute("cart");
				sess.removeAttribute("accdetail");
				sess.removeAttribute("city");
				resp.sendRedirect("/BanRuou/home");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}
}
