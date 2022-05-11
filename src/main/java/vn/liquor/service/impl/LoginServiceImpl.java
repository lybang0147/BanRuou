package vn.liquor.service.impl;

import vn.liquor.dao.LoginDao;
import vn.liquor.dao.impl.LoginDaoImpl;
import vn.liquor.model.AccountModel;
import vn.liquor.service.LoginService;

public class LoginServiceImpl implements LoginService {
	LoginDao loginDao = new LoginDaoImpl();

	@Override
	public AccountModel login(String user, String pass) {
		return loginDao.login(user, pass);
	}
}
