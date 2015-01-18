package cn.edu.dlut.chuangxin.dao.proxy;

import java.util.ArrayList;
import java.util.Date;

import cn.edu.dlut.chuangxin.dao.HumidityDao;
import cn.edu.dlut.chuangxin.dao.impl.HumidityDaoImpl;
import cn.edu.dlut.chuangxin.model.Humidity;

public class HumidityDaoProxy extends BaseDaoProxy implements HumidityDao{
	
	public HumidityDaoProxy() {
		super(HumidityDaoImpl.class);
	}

	@Override
	public boolean doCreate(Humidity obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Humidity findDao(Humidity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Humidity> getHumidity() {
		// TODO Auto-generated method stub
		ArrayList<Humidity> result = null;
		result = ((HumidityDao) super.dao).getHumidity();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Humidity> getHumidity(int page, int pageCount) {
		// TODO Auto-generated method stub
		ArrayList<Humidity> result = null;
		result = ((HumidityDao) super.dao).getHumidity(page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Humidity> getHumidity(Date start, Date end,
			int page, int pageCount) {
		// TODO Auto-generated method stub
		ArrayList<Humidity> result = null;
		result = ((HumidityDao) super.dao).getHumidity(start, end, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Humidity> getHumidityFromNodeID(int nodeID,
			int page, int pageCount) {
		// TODO Auto-generated method stub
		ArrayList<Humidity> result = null;
		result = ((HumidityDao) super.dao).getHumidityFromNodeID(nodeID, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getHumiditySize() {
		// TODO Auto-generated method stub
		int result = 0;
		result = ((HumidityDao) super.dao).getHumiditySize();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getHumiditySize(Date start, Date end) {
		// TODO Auto-generated method stub
		int result = 0;
		result = ((HumidityDao) super.dao).getHumiditySize(start, end);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getHumiditySize(Humidity Humidity) {
		// TODO Auto-generated method stub
		int result = 0;
		result = ((HumidityDao) super.dao).getHumiditySize(Humidity);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getHumiditySizeFromNodeID(int nodeID) {
		// TODO Auto-generated method stub
		int result = 0;
		result = ((HumidityDao) super.dao).getHumiditySizeFromNodeID(nodeID);
		connPool.returnConnection(conn);
		return result;
	}

}
