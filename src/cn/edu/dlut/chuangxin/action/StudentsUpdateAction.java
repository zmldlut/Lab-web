package cn.edu.dlut.chuangxin.action;

import com.opensymphony.xwork2.ActionSupport;

public class StudentsUpdateAction extends ActionSupport {

	/**
	 * 
	 */
	
	
	
	private static final long serialVersionUID = 1L;
	
	private String stdnum = "1";
	
	public String getStdnum() {
		return stdnum;
	}

	public void setStdnum(String stdnum) {
		this.stdnum = stdnum;
	}

	public String execute(){
		return "students_update";
	}
}
