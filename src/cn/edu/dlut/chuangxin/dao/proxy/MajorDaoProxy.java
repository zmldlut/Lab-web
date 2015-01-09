package cn.edu.dlut.chuangxin.dao.proxy;

import java.util.ArrayList;

import cn.edu.dlut.chuangxin.dao.MajorDao;
import cn.edu.dlut.chuangxin.dao.impl.MajorDaoImpl;
import cn.edu.dlut.chuangxin.model.Major;

public class MajorDaoProxy extends BaseDaoProxy implements MajorDao{
	
	public MajorDaoProxy() {
		super(MajorDaoImpl.class);
	}
	@Override
	public ArrayList<Major> getMajors() {
		// TODO Auto-generated method stub
		ArrayList<Major> result = null;
		result = ((MajorDaoImpl) super.dao).getMajors();
		connPool.returnConnection(conn);
		return result;
	}


	@Override
	public String getNameFromID(int id) {
		// TODO Auto-generated method stub
		String result = null;
		result = ((MajorDaoImpl) super.dao).getNameFromID(id);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getIDFromName(String name) {
		// TODO Auto-generated method stub
		int result = -1;
		result = ((MajorDaoImpl) super.dao).getIDFromName(name);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getMajorsSize() {
		// TODO Auto-generated method stub
		int result = 0;
		result = ((MajorDaoImpl) super.dao).getMajorsSize();
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
