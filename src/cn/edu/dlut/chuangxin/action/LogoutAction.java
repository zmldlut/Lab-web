package cn.edu.dlut.chuangxin.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String execute(){
		ActionContext.getContext().getSession().put("identity", "user");
		return "login";
	}
}