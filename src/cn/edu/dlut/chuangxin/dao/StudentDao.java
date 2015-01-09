package cn.edu.dlut.chuangxin.dao;

import java.util.ArrayList;

import cn.edu.dlut.chuangxin.model.Student;


public interface StudentDao extends BaseDao<Student>{
	ArrayList<Student> getStudents();
	ArrayList<Student> getStudents(int page, int pageCount);
	String getPasswordFromStdnum(String stdnum);
	int getStudentsSize();
}
