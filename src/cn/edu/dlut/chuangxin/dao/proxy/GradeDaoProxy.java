package cn.edu.dlut.chuangxin.dao.proxy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.dlut.chuangxin.dao.GradeDao;
import cn.edu.dlut.chuangxin.dao.impl.GradeDaoImpl;
import cn.edu.dlut.chuangxin.db.ConnectionPool;
import cn.edu.dlut.chuangxin.model.Grade;

public class GradeDaoProxy extends BaseDaoProxy implements GradeDao{

	private ConnectionPool connPool = null;
	private GradeDaoImpl dao = null;
	private Connection conn = null;
	
	public GradeDaoProxy() {
		try {
			this.connPool = ConnectionPool.getInstance();
			this.conn = connPool.getConnection();
			this.dao = new GradeDaoImpl(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	public ArrayList<Grade> getGrades() {
		// TODO Auto-generated method stub
		ArrayList<Grade> result = null;
		result = this.dao.getGrades();
		connPool.returnConnection(conn);
		return result;
	}
	
	@Override
	public int getGradesSize() {
		// TODO Auto-generated method stub
		int result = 0;
		result = this.dao.getGradesSize();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public boolean doCreate(Grade obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Grade findDao(Grade obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
