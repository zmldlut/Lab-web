package cn.edu.dlut.chuangxin.action;

import java.util.Map;

import cn.edu.dlut.chuangxin.dao.proxy.BaseDaoProxy;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String, Object> resultMsg;
	protected BaseDaoProxy daoProxy;
	
	public BaseAction() {
		setDaoProxy();
	}
	
	protected abstract void setDaoProxy();

	public Map<String, Object> getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(Map<String, Object> resultMsg) {
		this.resultMsg = resultMsg;
	}
}