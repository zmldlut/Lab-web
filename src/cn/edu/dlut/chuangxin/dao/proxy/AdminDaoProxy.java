package cn.edu.dlut.chuangxin.dao.proxy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.dlut.chuangxin.dao.AdminDao;
import cn.edu.dlut.chuangxin.dao.impl.AdminDaoImpl;
import cn.edu.dlut.chuangxin.db.ConnectionPool;
import cn.edu.dlut.chuangxin.model.Admin;

public class AdminDaoProxy extends BaseDaoProxy implements AdminDao{

	private ConnectionPool connPool = null;
	private AdminDaoImpl dao = null;
	private Connection conn = null;
	
	public AdminDaoProxy() {
		try {
			this.connPool = ConnectionPool.getInstance();
			this.conn = connPool.getConnection();
			this.dao = new AdminDaoImpl(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<String> getNames() {
		// TODO Auto-generated method stub
		ArrayList<String> result = null;
		result = this.dao.getNames();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public String getPasswordFromName(String name) {
		// TODO Auto-generated method stub
		String result = null;
		result = this.dao.getPasswordFromName(name);
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
