package vn.liquor.service.impl;

import vn.liquor.dao.BillDao;
import vn.liquor.dao.impl.BillDaoImpl;
import vn.liquor.model.BillModel;
import vn.liquor.service.BillService;

public class BillServiceImpl implements BillService {
	BillDao billdao = new BillDaoImpl();

	@Override
	public void insert(BillModel bill) {
		// TODO Auto-generated method stub
		billdao.insert(bill);
	}

	@Override
	public BillModel getbillbycaid(String caid) {
		// TODO Auto-generated method stub
		return billdao.getbillbycaid(caid);
	}

}
