package vn.liquor.service.impl;

import java.util.List;

import vn.liquor.dao.OrderDao;
import vn.liquor.dao.impl.OrderDaoImpl;
import vn.liquor.model.OrderModel;
import vn.liquor.service.OrderService;

public class OrderServiceImpl implements OrderService{
OrderDao orderdao = new OrderDaoImpl();
	@Override
	public List<OrderModel> getorderbysid(int sid) {
		// TODO Auto-generated method stub
		return orderdao.getorderbysid(sid);
	}
	@Override
	public List<OrderModel> getorderbyuid(int uid) {
		// TODO Auto-generated method stub
		return orderdao.getorderbyuid(uid);
	}
}
