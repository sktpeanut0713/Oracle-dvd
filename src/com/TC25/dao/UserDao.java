package com.TC25.dao;

import java.sql.SQLException;

import com.TC25.bean.User;

//--���ݿ����. ��ɾ�Ĳ������д�������.

public interface UserDao {

	/**
	 * �����û��˻���ȡUser����.(�����ݿ��в�ѯ������.)
	 * @param userAccount
	 * @return
	 * @throws SQLException 
	 */
	public User getUserByUserAccount(String userAccount) throws SQLException;
}














