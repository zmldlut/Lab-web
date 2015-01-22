package cn.edu.dlut.chuangxin.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import com.zml.dao.factory.DaoFactory;
import com.zml.dao.proxy.LightDaoProxy;
import com.zml.model.Light;

public class LightAction extends BaseAction {

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
	
	public String getLightInfoAction(){
		ArrayList<Light> dataList = null;
		resultMsg = new HashMap<String, Object>();
		try {
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			dataList = ( (LightDaoProxy) daoProxy).getLights(date.parse(start), date.parse(end), node_id, page, pageCount);
			int sz = 0;
			sz = ( (LightDaoProxy) daoProxy).getLightSize(date.parse(start), date.parse(end), node_id) + pageCount - 1;
			resultMsg.put("maxPage", (sz + pageCount - 1) / pageCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultMsg.put("result", dataList);
		return SUCCESS;
	}
	public String lightInfo(){
		return "light_info";
	}
	
	@Override
	protected void setDaoProxy() {
		try {
			daoProxy = DaoFactory.getDaoInstance(LightDaoProxy.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
