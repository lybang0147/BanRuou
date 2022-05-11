package vn.liquor.service.impl;

import java.util.List;

import vn.liquor.dao.UserDao;
import vn.liquor.dao.impl.UserDaoImpl;
import vn.liquor.model.AccountDetailModel;
import vn.liquor.model.AccountModel;
import vn.liquor.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public void insert(AccountModel user) {
		// TODO Auto-generated method stub

	}

	@Override
	public AccountModel get(int id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}

	@Override
	public int countAllAccount() {
		// TODO Auto-generated method stub
		return userDao.countAllAccount();
	}

	@Override
	public AccountDetailModel layaccountdetail(int id) {
		// TODO Auto-generated method stub
		return userDao.layaccountdetail(id);
	}

	@Override
	public void editdetail(AccountDetailModel user) {
		userDao.editdetail(user);
	}

	@Override
	public void editdetailimage(AccountDetailModel user) {
		userDao.editdetailimage(user);

	}

	@Override
	public List<AccountModel> getalluser() {
		return userDao.getalluser();
	}

	@Override
	public void ban(int id) {
		userDao.ban(id);

	}

	@Override
	public void unban(int id) {
		// TODO Auto-generated method stub
		userDao.unban(id);

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	@Override
	public void register(AccountModel acc) {
		userDao.register(acc);

	}

	@Override
	public AccountModel checkuser(String username) {
		// TODO Auto-generated method stub
		return userDao.checkuser(username);
	}

	@Override
	public void adddetail(AccountDetailModel user) {
		userDao.adddetail(user);
	}

	@Override
	public void deletedetail(int id) {
		userDao.deletedetail(id);

	}

	@Override
	public List<AccountDetailModel> getalluserdetail() {
		// TODO Auto-generated method stub
		return userDao.getalluserdetail();
	}

}
