package cn.edu.dlut.chuangxin.dao;

import java.util.ArrayList;

import cn.edu.dlut.chuangxin.model.Major;

public interface MajorDao extends BaseDao<Major>{
	ArrayList<Major> getMajors();
	String getNameFromID(int id);
	int getIDFromName(String name);
	int getMajorsSize();
}
