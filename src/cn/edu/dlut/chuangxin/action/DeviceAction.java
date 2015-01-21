package cn.edu.dlut.chuangxin.action;

import java.util.ArrayList;
import java.util.HashMap;

import com.zml.dao.factory.DaoFactory;
import com.zml.dao.proxy.DeviceDaoProxy;
import com.zml.model.Device;

public class DeviceAction extends BaseAction {

	private static final long serialVersionUID = 6891398674378080252L;

	private int page = 1;
	private int pageCount = 10;
	private Device device;
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public String info(){
		return "devices_info";
	}
	
	public String register(){
		return "devices_register";
	}
	
	public String success(){
		return "register_success";
	}
	
	public String update(){
		return "devices_update";
	}

	@Override
	protected void setDaoProxy() {
		try {
			daoProxy = DaoFactory.getDaoInstance(DeviceDaoProxy.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDevices(){
		ArrayList<Device> dataList = null;
		resultMsg = new HashMap<String, Object>();
		try {
			dataList = (((DeviceDaoProxy) daoProxy).getDevices(device.getType(), device.getStatus(), page, pageCount));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int sz = ((DeviceDaoProxy) daoProxy).getDevicesSize(device.getType(), device.getStatus());
		resultMsg.put("maxPage", (sz + pageCount - 1) / pageCount);
		resultMsg.put("result", dataList);
		return SUCCESS;
	}
	
	public String getDeviceFromId() {
		Device result = null;
		resultMsg = new HashMap<String, Object>();
		try {
			result = ((DeviceDaoProxy) daoProxy).getDevice(device.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultMsg.put("result", result);
		return SUCCESS;
	}
	
	
	public String addDevice(){
		boolean result = false;
		resultMsg = new HashMap<String, Object>();
		try {
			result = (((DeviceDaoProxy) daoProxy).doCreate(device));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMsg.put("result", result);
		return SUCCESS;
	}
	
	public String delDevice(){
		boolean result = false;
		resultMsg = new HashMap<String, Object>();
		try {
			result = (((DeviceDaoProxy) daoProxy).delDevice(device.getId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMsg.put("result", result);
		return SUCCESS;
	}
	
	public String updateDevice(){
		boolean result = false;
		resultMsg = new HashMap<String, Object>();
		try {
			result = (((DeviceDaoProxy) daoProxy).updateDevice(device));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMsg.put("result", result);
		return SUCCESS;
	}
}
