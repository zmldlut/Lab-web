package cn.edu.dlut.chuangxin.dao;

public interface BaseDao<T> {	
	//�������ݿ��������
	public boolean doCreate(T obj);//��������
	public T findDao(T obj);//�޸�����
}
