package cn.edu.dlut.chuangxin.dao;

import java.util.ArrayList;

import cn.edu.dlut.chuangxin.dao.BaseDao;
import cn.edu.dlut.chuangxin.model.Admin;


public interface AdminDao extends BaseDao<Admin>{
	ArrayList<String> getNames();
	String getPasswordFromName(String name);
}
