package cn.edu.dlut.chuangxin.dao.proxy;

import java.util.ArrayList;

import cn.edu.dlut.chuangxin.dao.AdminDao;
import cn.edu.dlut.chuangxin.dao.impl.AdminDaoImpl;
import cn.edu.dlut.chuangxin.model.Admin;

public class AdminDaoProxy extends BaseDaoProxy implements AdminDao{
	
	public AdminDaoProxy(){
		super(AdminDaoImpl.class);
	}
	
	@Override
	public ArrayList<String> getNames() {
		// TODO Auto-generated method stub
		ArrayList<String> result = null;
		result = ((AdminDaoImpl) super.dao).getNames();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public String getPasswordFromName(String name) {
		// TODO Auto-generated method stub
		String result = null;
		result = ((AdminDaoImpl) super.dao).getPasswordFromName(name);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public boolean doCreate(Admin obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin findDao(Admin obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
