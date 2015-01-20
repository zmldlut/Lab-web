package cn.edu.dlut.chuangxin.action;

import java.util.HashMap;

import com.opensymphony.xwork2.ActionContext;
import com.zml.dao.factory.DaoFactory;
import com.zml.dao.proxy.AdminDaoProxy;
import com.zml.model.Admin;

public class AdminAction extends BaseAction{

	private static final long serialVersionUID = 3455396576098019765L;
	private Admin admin = null;
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String login(){
		if(ActionContext.getContext().getSession().get("identity").equals("admin")){
			return "login";
		}
		return "login";
	}
	
	public String logout(){
		ActionContext.getContext().getSession().put("identity", "user");
		return "login";
	}
	
	public String admin(){
		if(((String)ActionContext.getContext().getSession().get("identity")).equals("user")){
			return "login";
		}
		return "main";
	}
	
	public String checkPassword(){
		System.out.println("尝试登陆：：用户名：" + getAdmin().getName() + ", 密码：" + getAdmin().getPassword());
		resultMsg = new HashMap<String, Object>();
		String result = null;
		try {
			result = ((AdminDaoProxy)daoProxy).getPasswordFromName(getAdmin().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(result == null){
			resultMsg.put("result", "用户不存在");
			System.out.println("用户不存在");
		}
		else if(this.getAdmin().getPassword().equals(result)){
			ActionContext.getContext().getSession().put("identity", "admin");
			resultMsg.put("result", "密码正确");
			System.out.println("密码正确 " + ActionContext.getContext().getSession().get("identity"));
		}
		else {
			System.out.println("密码错误");
			resultMsg.put("result", "密码错误");
		}
		return SUCCESS;
	}
	
	@Override
	protected void setDaoProxy() {
		try {
			daoProxy = DaoFactory.getDaoInstance(AdminDaoProxy.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}