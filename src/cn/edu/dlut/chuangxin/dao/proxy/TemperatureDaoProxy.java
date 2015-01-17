package cn.edu.dlut.chuangxin.dao.proxy;

import java.util.ArrayList;
import java.util.Date;

import cn.edu.dlut.chuangxin.dao.TemperatureDao;
import cn.edu.dlut.chuangxin.dao.impl.TemperatureDaoImpl;
import cn.edu.dlut.chuangxin.model.Temperature;

public class TemperatureDaoProxy extends BaseDaoProxy implements TemperatureDao{
	
	public TemperatureDaoProxy() {
		super(TemperatureDaoImpl.class);
	}

	@Override
	public boolean doCreate(Temperature obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Temperature findDao(Temperature obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Temperature> getTemperature() {
		// TODO Auto-generated method stub
		ArrayList<Temperature> result = null;
		result = ((TemperatureDao) super.dao).getTemperature();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Temperature> getTemperature(int page, int pageCount) {
		// TODO Auto-generated method stub
		ArrayList<Temperature> result = null;
		result = ((TemperatureDao) super.dao).getTemperature(page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Temperature> getTemperature(Date start, Date end,
			int page, int pageCount) {
		// TODO Auto-generated method stub
		ArrayList<Temperature> result = null;
		result = ((TemperatureDao) super.dao).getTemperature(start, end, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Temperature> getTemperatureFromNodeID(int nodeID,
			int page, int pageCount) {
		// TODO Auto-generated method stub
		ArrayList<Temperature> result = null;
		result = ((TemperatureDao) super.dao).getTemperatureFromNodeID(nodeID, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getTemperatureSize() {
		// TODO Auto-generated method stub
		int result = 0;
		result = ((TemperatureDao) super.dao).getTemperatureSize();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getTemperatureSize(Date start, Date end) {
		// TODO Auto-generated method stub
		int result = 0;
		result = ((TemperatureDao) super.dao).getTemperatureSize(start, end);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getTemperatureSize(Temperature temperature) {
		// TODO Auto-generated method stub
		int result = 0;
		result = ((TemperatureDao) super.dao).getTemperatureSize(temperature);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getTemperatureSizeFromNodeID(int nodeID) {
		// TODO Auto-generated method stub
		int result = 0;
		result = ((TemperatureDao) super.dao).getTemperatureSizeFromNodeID(nodeID);
		connPool.returnConnection(conn);
		return result;
	}

}
