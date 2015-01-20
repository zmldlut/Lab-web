package cn.edu.dlut.chuangxin.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String stdnum = null;
	
	public String getStdnum() {
		return stdnum;
	}

	public void setStdnum(String stdnum) {
		this.stdnum = stdnum;
	}

	public String info(){
		return "students_info";
	}
	
	public String register(){
		return "students_register";
	}
	
	public String success(){
		return "register_success";
	}
	
	public String update(){
		return "students_update";
	}
}
