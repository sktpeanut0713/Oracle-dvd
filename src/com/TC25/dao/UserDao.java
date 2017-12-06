package com.TC25.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.TC25.bean.DVD;
import com.TC25.bean.User;

//--数据库操作. 增删改查代码是写在这里的.

public interface UserDao {

	/**
	 * 根据用户账户获取User对象.(从数据库中查询出来的.)
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















