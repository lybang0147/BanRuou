package vn.liquor.service.impl;

import java.util.List;

import vn.liquor.dao.CityDao;
import vn.liquor.dao.impl.CityDaoImpl;
import vn.liquor.model.CityModel;
import vn.liquor.service.CityService;

public class CityServiceImpl implements CityService {
	CityDao citydao = new CityDaoImpl();

	@Override
	public void insertcity(CityModel city) {
		citydao.insertcity(city);

	}

	@Override
	public void updatecity(CityModel city) {
		citydao.updatecity(city);

	}

	@Override
	public void delcity(int id) {
		citydao.delcity(id);

	}

	@Override
	public List<CityModel> getallcity() {
		// TODO Auto-generated method stub
		return citydao.getallcity();
	}

	@Override
	public CityModel getcitybyid(int id) {
		// TODO Auto-generated method stub
		return citydao.getcitybyid(id);
	}

}
