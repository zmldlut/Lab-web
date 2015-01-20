package cn.edu.dlut.chuangxin.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import com.zml.dao.factory.DaoFactory;
import com.zml.dao.proxy.HumidityDaoProxy;
import com.zml.model.Humidity;

public class HumidityAction extends BaseAction {

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
	
	public String getHumidityInfoAction(){
		ArrayList<Humidity> dataList = null;
		resultMsg = new HashMap<String, Object>();
		try {
			if(start == null || end == null){
				dataList = ( (HumidityDaoProxy) daoProxy).getHumidity(page, pageCount);
			}
			else{
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				dataList = ( (HumidityDaoProxy) daoProxy).getHumidity(date.parse(start), date.parse(end), page, pageCount);
			}
			
			int sz = 0;
			if(start == null || end == null){
				sz = ( (HumidityDaoProxy) daoProxy).getHumiditySize() + pageCount - 1;
			}
			else{
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				sz = ( (HumidityDaoProxy) daoProxy).getHumiditySize(date.parse(start), date.parse(end)) + pageCount - 1;
			}
			resultMsg.put("maxPage", sz / pageCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMsg.put("result", dataList);
        // page= page.getDatas();  
		return SUCCESS;
	}
	public String humidityInfo(){
		return "humidity_info";
	}
	
	@Override
	protected void setDaoProxy() {
		try {
			daoProxy = DaoFactory.getDaoInstance(HumidityDaoProxy.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
