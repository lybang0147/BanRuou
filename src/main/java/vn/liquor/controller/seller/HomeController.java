package vn.liquor.controller.seller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.liquor.model.SellerModel;
import vn.liquor.service.SellerService;
import vn.liquor.service.impl.SellerServiceImpl;

@WebServlet(urlPatterns = { "/seller/home" })
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8753776321176994309L;
	SellerService sellerservice =new SellerServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession sess = req.getSession();
		SellerModel seller = (SellerModel) sess.getAttribute("sell");
		int sam = sellerservice.daban(seller.getId());
		int tp = sellerservice.tongsanpham(seller.getId());
		int tdt = sellerservice.tongdoanhthu(seller.getId());
		req.setAttribute("daban", sam);
		req.setAttribute("tongsp", tp);
		req.setAttribute("tongdt", tdt);
		System.out.print(sam+"///"+tp+"///"+tdt);
		req.getRequestDispatcher("/views/seller/sellerhome.jsp").forward(req, resp);
	}
}
