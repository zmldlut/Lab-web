package cn.edu.dlut.chuangxin.dao;

import java.util.ArrayList;

import cn.edu.dlut.chuangxin.model.Grade;

public interface GradeDao extends BaseDao<Grade>{
	ArrayList<Grade> getGrades();
	String getNameFromID(int id);
	int getIDFromName(String name);
	int getGradesSize();
}
