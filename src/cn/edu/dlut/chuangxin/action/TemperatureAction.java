package cn.edu.dlut.chuangxin.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import com.zml.dao.factory.DaoFactory;
import com.zml.dao.proxy.TemperatureDaoProxy;
import com.zml.model.Temperature;

public class TemperatureAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private int page = 1;
	private int pageCount = 10;
	private String start = "";
	private String end = "";
	private int node_id = 0;

	public String getStart() {
		return start;
	}

	public int getNode_id() {
		return node_id;
	}

	public void setNode_id(int node_id) {
		this.node_id = node_id;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public String getTemperatureInfoAction(){
		ArrayList<Temperature> dataList = null;
		resultMsg = new HashMap<String, Object>();
		try {
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			dataList = ( (TemperatureDaoProxy) daoProxy).getTemperature(date.parse(start), date.parse(end), node_id, page, pageCount);
			int sz = 0;
			sz = ( (TemperatureDaoProxy) daoProxy).getTemperatureSize(date.parse(start), date.parse(end), node_id) + pageCount - 1;
			resultMsg.put("maxPage", (sz + pageCount - 1) / pageCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMsg.put("result", dataList);
        // page= page.getDatas();  
		return SUCCESS;
	}
	public String temperatureInfo(){
		return "temperature_info";
	}
	
	@Override
	protected void setDaoProxy() {
		try {
			daoProxy = DaoFactory.getDaoInstance(TemperatureDaoProxy.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
