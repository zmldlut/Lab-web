package cn.edu.dlut.chuangxin.dao.factory;

import cn.edu.dlut.chuangxin.dao.proxy.AdminDaoProxy;
import cn.edu.dlut.chuangxin.dao.proxy.GradeDaoProxy;
import cn.edu.dlut.chuangxin.dao.proxy.MajorDaoProxy;
import cn.edu.dlut.chuangxin.dao.proxy.StudentDaoProxy;

public class DaoFactory {

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
}
