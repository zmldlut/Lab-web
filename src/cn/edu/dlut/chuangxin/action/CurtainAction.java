package cn.edu.dlut.chuangxin.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import com.zml.dao.factory.DaoFactory;
import com.zml.dao.proxy.CurtainDaoProxy;
import com.zml.dto.CurtainLamp;

public class CurtainAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private int page = 1;
	private int pageCount = 10;
	private String start = "";
	private String end = "";
	private int node_id = 0;
	private String name;

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
	public String getStart() {
		return start;
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
	public int getNode_id() {
		return node_id;
	}
	public void setNode_id(int node_id) {
		this.node_id = node_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCurtainsInfoAction(){
		ArrayList<CurtainLamp> dataList = null;
		resultMsg = new HashMap<String, Object>();
		try {
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			dataList = ((CurtainDaoProxy) daoProxy).getCurtains(date.parse(start), date.parse(end), name, node_id, page, pageCount);
			int sz = 0;
			sz = ((CurtainDaoProxy) daoProxy).getCurtainSize(date.parse(start), date.parse(end), name, node_id) + pageCount - 1;
			resultMsg.put("maxPage", (sz + pageCount - 1) / pageCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultMsg.put("result", dataList);
        // page= page.getDatas();  
		return SUCCESS;
	}
	public String curtainInfo(){
		return "curtain_info";
	}
	
	@Override
	protected void setDaoProxy() {
		try {
			daoProxy = DaoFactory.getDaoInstance(CurtainDaoProxy.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
