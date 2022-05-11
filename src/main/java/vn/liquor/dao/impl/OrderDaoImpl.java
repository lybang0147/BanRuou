package vn.liquor.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.liquor.connection.DBConnect;
import vn.liquor.dao.OrderDao;
import vn.liquor.model.OrderModel;
import vn.liquor.service.BillService;
import vn.liquor.service.CartItemService;
import vn.liquor.service.ProductService;
import vn.liquor.service.impl.BillServiceImpl;
import vn.liquor.service.impl.CartItemServiceImpl;
import vn.liquor.service.impl.ProductServiceImpl;

public class OrderDaoImpl implements OrderDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	BillService billservice = new BillServiceImpl();
	CartItemService cartitemservice = new CartItemServiceImpl();
	ProductService productservice = new ProductServiceImpl();

	@Override
	public List<OrderModel> getorderbysid(int sid) {
		String sql = "Select Cartdetail.id,Product.productId,bill.CartId from Cartdetail inner join Product on Cartdetail.productId = Product.productId inner join bill on Cartdetail.cartId=bill.CartId\r\n"
				+ "where Product.sellerId=?";
		List<OrderModel> list = new ArrayList<OrderModel>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new OrderModel(cartitemservice.getbycitemid(rs.getInt(1)),
						productservice.getproductbypid(rs.getInt(2)), billservice.getbillbycaid(rs.getString(3))));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<OrderModel> getorderbyuid(int uid) {
		String sql = "Select Cartdetail.id,Product.productId,bill.CartId from Cartdetail inner join Product on Cartdetail.productId = Product.productId inner join bill on Cartdetail.cartId=bill.CartId inner join Cart on cart.cartId=Cartdetail.cartId\r\n"
				+ "where Cart.userId=?";
		List<OrderModel> list = new ArrayList<OrderModel>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new OrderModel(cartitemservice.getbycitemid(rs.getInt(1)),
						productservice.getproductbypid(rs.getInt(2)), billservice.getbillbycaid(rs.getString(3))));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
