package vn.liquor.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.liquor.connection.DBConnect;
import vn.liquor.dao.BillDao;
import vn.liquor.model.BillModel;
import vn.liquor.service.CartService;
import vn.liquor.service.CityService;
import vn.liquor.service.UserService;
import vn.liquor.service.impl.CartServiceImpl;
import vn.liquor.service.impl.CityServiceImpl;
import vn.liquor.service.impl.UserServiceImpl;

public class BillDaoImpl implements BillDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	CartService cartservice = new CartServiceImpl();
	UserService userservice = new UserServiceImpl();
	CityService cityservie = new CityServiceImpl();

	@Override
	public void insert(BillModel bill) {
		String sql = "insert into bill(CartId,shipid,fullName,phoneNumber,fullAddress,email,payment) values (?,?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bill.getCart().getId());
			ps.setInt(2, bill.getCity().getShipid());
			ps.setString(3, bill.getFullname());
			ps.setString(4, bill.getPhonenumber());
			ps.setString(5, bill.getFulladdress());
			ps.setString(6, bill.getEmail());
			ps.setString(7, bill.getPayment());
			ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public BillModel getbillbycaid(String caid) {
		String sql = "Select * from bill where cartid=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, caid);
			rs = ps.executeQuery();
			while (rs.next())
				return new BillModel(cartservice.get(rs.getString(1)), cityservie.getcitybyid(rs.getInt(2)),
						rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
