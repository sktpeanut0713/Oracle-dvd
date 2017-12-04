package com.TC25.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.TC25.bean.User;
import com.TC25.dao.UserDao;
import com.TC25.tools.DBHelper;
/**
 * @Title: UserDaoImpl.java
 * @package: com.TC25.daoImpl
 * @Description: ����ʵ����,view����ҵ��,ҵ���������
 * @author Administrator
 * @date 2017��12��4������8:03:52
 * @version 1.0
 */
public class UserDaoImpl implements UserDao {
	
	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet rSet;
	
	private DBHelper mDB;
	public UserDaoImpl() {
		mDB = new DBHelper();
		mConnection = mDB.getConnection();
	}
	

	//Ctrl + 1
	@Override
	public User getUserByUserAccount(String userAccount) throws SQLException {
	
		//--�ʺŽ���ռλ��.
		String sql = "select * from DVD_User where userAccount = ?";
		
		//--ͨ�����ӻ�ȡPreparedStatement����
		mStatement = mConnection.prepareStatement(sql);
		
		//--ͨ��PreparedStatement�����ռλ������ֵ����
		mStatement.setString(1, userAccount);
		
		//--ͨ��PreparedStatement���÷�����ִ�в�ѯ��䲢��ȡ���������
		//executeQuery  �ǲ�ѯר��
		/*
		 * �����ĵ���������������.��������Ϊnull
		 */
		rSet = mStatement.executeQuery();
		if (rSet == null) {
			return null;
		}
		User u = new User();
		while (rSet.next()) {			
			u.setUserId(rSet.getInt("USERID"));	
			u.setUserAccount(rSet.getString("USERACCOUNT"));
			u.setUserName(rSet.getString("USERNAME"));	
			u.setUserPwd(rSet.getString("USERPWD"));
			u.setUserPwdTips(rSet.getString("USERPWDTIPS"));
			u.setUserStatus(rSet.getInt("USERSTATUS"));
		}		
		return u;
	}

}













