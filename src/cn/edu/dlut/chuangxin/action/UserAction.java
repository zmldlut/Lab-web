package cn.edu.dlut.chuangxin.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String studentsUpdate(){
		return "students_update";
	}
	
	public String studentsInfo(){
		return "students_info";
	}
	
	public String studentsRegister(){
		return "students_register";
	}
	
	public String registerSuccess(){
		return "register_success";
	}
}
