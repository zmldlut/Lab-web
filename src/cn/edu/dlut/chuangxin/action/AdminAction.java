package cn.edu.dlut.chuangxin.action;

import java.util.HashMap;

import cn.edu.dlut.chuangxin.dao.factory.DaoFactory;
import cn.edu.dlut.chuangxin.dao.proxy.AdminDaoProxy;
import cn.edu.dlut.chuangxin.model.Admin;

import com.opensymphony.xwork2.ActionContext;

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
		System.out.println("���Ե�½�����û�����" + getAdmin().getName() + ", ���룺" + getAdmin().getPassword());
		resultMsg = new HashMap<String, Object>();
		String result = null;
		try {
			result = ((AdminDaoProxy)daoProxy).getPasswordFromName(getAdmin().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(result == null){
			resultMsg.put("result", "�û�������");
			System.out.println("�û�������");
		}
		else if(this.getAdmin().getPassword().equals(result)){
			resultMsg.put("result", "������ȷ");
			System.out.println("������ȷ");
			ActionContext.getContext().getSession().put("identity", "admin");
		}
		else {
			System.out.println("�������");
			resultMsg.put("result", "�������");
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