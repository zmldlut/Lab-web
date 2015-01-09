package cn.edu.dlut.chuangxin.dao.proxy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.dlut.chuangxin.dao.MajorDao;
import cn.edu.dlut.chuangxin.dao.impl.MajorDaoImpl;
import cn.edu.dlut.chuangxin.db.ConnectionPool;
import cn.edu.dlut.chuangxin.model.Major;

public class MajorDaoProxy extends BaseDaoProxy implements MajorDao{

	private ConnectionPool connPool = null;
	private MajorDaoImpl dao = null;
	private Connection conn = null;
	
	public MajorDaoProxy() {
		try {
			this.connPool = ConnectionPool.getInstance();
			this.conn = connPool.getConnection();
			this.dao = new MajorDaoImpl(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<Major> getMajors() {
		// TODO Auto-generated method stub
		ArrayList<Major> result = null;
		result = this.dao.getMajors();
		connPool.returnConnection(conn);
		return result;
	}


	@Override
	public String getNameFromID(int id) {
		// TODO Auto-generated method stub
		String result = null;
		result = this.dao.getNameFromID(id);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getIDFromName(String name) {
		// TODO Auto-generated method stub
		int result = -1;
		result = this.dao.getIDFromName(name);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getMajorsSize() {
		// TODO Auto-generated method stub
		int result = 0;
		result = this.dao.getMajorsSize();
		connPool.returnConnection(conn);
		return result;
	}
	@Override
	public boolean doCreate(Major obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Major findDao(Major obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
