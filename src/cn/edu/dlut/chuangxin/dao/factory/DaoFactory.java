package cn.edu.dlut.chuangxin.dao.factory;

import cn.edu.dlut.chuangxin.dao.proxy.BaseDaoProxy;

public class DaoFactory {
	
	public static BaseDaoProxy getDaoInstance(Class<? extends BaseDaoProxy> daoClass) throws Exception {
		return daoClass.newInstance();
	}
/*
	public static AdminDaoProxy getAdminDaoInstance() throws Exception{
		return new AdminDaoProxy();
	}
	
	public static StudentDaoProxy getStudentDaoInstance() throws Exception{
		return new StudentDaoProxy();
	}
	
	public static MajorDaoProxy getMajorDaoInstance() throws Exception{
		return new MajorDaoProxy();
	}
	
	public static GradeDaoProxy getGradeDaoInstance() throws Exception{
		return new GradeDaoProxy();
	}
*/
}
