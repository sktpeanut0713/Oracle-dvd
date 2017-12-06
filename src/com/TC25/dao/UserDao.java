package com.TC25.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.TC25.bean.DVD;
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
	
	public boolean isAccountExist(String account) throws SQLException;

	public boolean enterUser(String account, String pwd, String userPwdTip, String userName) throws SQLException;

	public ArrayList<DVD> showAllDvd() throws SQLException;

	public ArrayList<DVD> showCanLendDvd();

	public void LendDvdById(int b);
	

	
	
	
}















