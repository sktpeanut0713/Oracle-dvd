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
 * @Description: 数据实现类,view调用业务,业务调用数据
 * @author Administrator
 * @date 2017年12月4日下午8:03:52
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
	
		//--问号叫做占位符.
		String sql = "select * from DVD_User where userAccount = ?";
		
		//--通过连接获取PreparedStatement对象
		mStatement = mConnection.prepareStatement(sql);
		
		//--通过PreparedStatement对象给占位符做赋值操作
		mStatement.setString(1, userAccount);
		
		//--通过PreparedStatement调用方法来执行查询语句并获取结果集对象
		//executeQuery  是查询专用
		/*
		 * 如果查的到则结果集中有数据.否则结果集为null
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













