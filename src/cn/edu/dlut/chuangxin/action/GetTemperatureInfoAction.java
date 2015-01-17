package cn.edu.dlut.chuangxin.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.edu.dlut.chuangxin.dao.factory.DaoFactory;
import cn.edu.dlut.chuangxin.dao.proxy.TemperatureDaoProxy;
import cn.edu.dlut.chuangxin.model.Temperature;

import com.opensymphony.xwork2.ActionSupport;

public class GetTemperatureInfoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private JSONArray result = null;
	private int page = 1;
	private int pageCount = 10;
	private int maxPage = -1;
	private String start = "";
	private String end = "";
	private int node_id = 0;
//http://star-pc:8080/StrutsTags/getTemperatureInfoAction?page=1&pageCount=20&start=2015-01-12&end=2015-01-12
	
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

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
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
	
	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	}

	private JSONArray getJSONArray(ArrayList<Temperature> dataList){
		JSONArray result = new JSONArray();
		if(dataList == null) return result;
		for(Temperature temperature : dataList){
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			JSONObject obj = new JSONObject();
			obj.put("id", temperature.getId());
			obj.put("node_id", temperature.getNode_id());
			obj.put("acq_time", date.format(temperature.getAcq_time()));
			obj.put("temperature_value", temperature.getTemperature_value());
			result.add(obj);
			System.out.println(obj.toString());
		}
		return result;
	}
	
	public String execute(){
		System.out.println(start + " " + end);
		ArrayList<Temperature> dataList = null;
		try {
			if(start == null || end == null){
				dataList = ( (TemperatureDaoProxy) DaoFactory.getDaoInstance(TemperatureDaoProxy.class)).getTemperature(page, pageCount);
			}
			else{
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				dataList = ( (TemperatureDaoProxy) DaoFactory.getDaoInstance(TemperatureDaoProxy.class)).getTemperature(date.parse(start), date.parse(end), page, pageCount);
			}
			
			int sz = 0;
			if(start == null || end == null){
				sz = ( (TemperatureDaoProxy) DaoFactory.getDaoInstance(TemperatureDaoProxy.class)).getTemperatureSize() + pageCount - 1;
			}
			else{
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				sz = ( (TemperatureDaoProxy) DaoFactory.getDaoInstance(TemperatureDaoProxy.class)).getTemperatureSize(date.parse(start), date.parse(end)) + pageCount - 1;
			}
			setMaxPage(sz / pageCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jsonData = getJSONArray(dataList);
		setResult(jsonData);
        // page= page.getDatas();  
		return SUCCESS;
	}
}
