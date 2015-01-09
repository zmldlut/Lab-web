package cn.edu.dlut.chuangxin.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3455396576098019765L;
	
	public String execute(){
		if(ActionContext.getContext().getSession().get("identity").equals("admin")){
			return "login";
		}
		return "login";
	}
	
}