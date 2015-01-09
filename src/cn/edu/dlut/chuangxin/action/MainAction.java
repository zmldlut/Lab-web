package cn.edu.dlut.chuangxin.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String execute(){
		if(((String)ActionContext.getContext().getSession().get("identity")).equals("user")){
			return "login";
		}
		return "main";
	}
	
}