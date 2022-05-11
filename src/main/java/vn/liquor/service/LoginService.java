package vn.liquor.service;

import vn.liquor.model.AccountModel;

public interface LoginService {
	 AccountModel login(String user, String pass);
}
