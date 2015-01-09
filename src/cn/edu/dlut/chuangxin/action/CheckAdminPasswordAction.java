package cn.edu.dlut.chuangxin.action;

import cn.edu.dlut.chuangxin.dao.factory.DaoFactory;
import cn.edu.dlut.chuangxin.dao.proxy.AdminDaoProxy;
import cn.edu.dlut.chuangxin.model.Admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CheckAdminPasswordAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Admin admin = null;
	private String result = null;
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String execute(){
		System.out.println("尝试登陆：：用户名：" + getAdmin().getName() + ", 密码：" + getAdmin().getPassword());
		String result = null;
		try {
			result = ((AdminDaoProxy)DaoFactory.getDaoInstance(AdminDaoProxy.class)).getPasswordFromName(getAdmin().getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(result == null){
			setResult("用户名不存在");
		}
		else if(this.getAdmin().getPassword().equals(result)){
			setResult("密码正确");
			ActionContext.getContext().getSession().put("identity", "admin");
		}
		else {
			setResult("密码错误");
		}
		return SUCCESS;
	}
	
}