package vn.liquor.service.impl;

import java.util.List;

import vn.liquor.dao.SellerDao;
import vn.liquor.dao.impl.SellerDaoImpl;
import vn.liquor.model.SellerInfoModel;
import vn.liquor.model.SellerModel;
import vn.liquor.service.SellerService;

public class SellerServiceImpl implements SellerService {
	SellerDao sellerDao = new SellerDaoImpl();

	@Override
	public void registerseller(SellerModel seller) {
		sellerDao.registerseller(seller);

	}

	@Override
	public void registerinfo(SellerInfoModel sellerinfo) {
		sellerDao.registerinfo(sellerinfo);

	}

	@Override
	public SellerModel checkshopname(String shopname) {
		// TODO Auto-generated method stub
		return sellerDao.checkshopname(shopname);
	}

	@Override
	public SellerModel getsellerbyuid(int uid) {
		// TODO Auto-generated method stub
		return sellerDao.getsellerbyuid(uid);
	}

	@Override
	public void updateisseller(int uid) {
		// TODO Auto-generated method stub
		sellerDao.updateisseller(uid);
	}

	@Override
	public List<SellerModel> getallseller() {
		// TODO Auto-generated method stub
		return sellerDao.getallseller();
	}
	@Override
	public int daban(int sid) {
		// TODO Auto-generated method stub
		return sellerDao.daban(sid);
	}

	@Override
	public int tongdoanhthu(int sid) {
		// TODO Auto-generated method stub
		return sellerDao.tongdoanhthu(sid);
	}

	@Override
	public int tongsanpham(int sid) {
		// TODO Auto-generated method stub
		return sellerDao.tongsanpham(sid);
	}

	@Override
	public SellerModel getsellerbysid(int sid) {
		// TODO Auto-generated method stub
		return sellerDao.getsellerbysid(sid);
	}

}
