package lms.service;

import lms.dao.LmsDao;
import lms.service.Service;
import lms.vo.Account;

public class Service {
	private static Service service= new Service();
	private Service() {}
	private LmsDao dao = LmsDao.getInstance();
	public static Service getInstance()
	{
		return service;
	}
	public void join(Account account) {
		// TODO Auto-generated method stub
		dao.join(account);
	}
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		return dao.login(id, pwd);
	}
	public void deposit(String id, int money) {
		// TODO Auto-generated method stub
		
	}

}
