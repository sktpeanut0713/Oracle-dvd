package com.TC25.bizImpl;

import java.sql.SQLException;

import com.TC25.bean.User;
import com.TC25.biz.UserBiz;
import com.TC25.dao.UserDao;
import com.TC25.daoImpl.UserDaoImpl;
/**
 * @Title: UserBizImpl.java
 * @package: com.TC25.bizImpl
 * @Description: 业务实现类 view调用业务
 * @author Administrator
 * @date 2017年12月4日下午8:03:10
 * @version 1.0
 */
public class UserBizImpl implements UserBiz {

	/**
	 * 用户登录方法
	 */
	@Override
	public boolean userLogin(String userAccount, String userPwd) {
	
		if (userAccount == null || userPwd == null || userAccount.length() == 0 || userPwd.length() == 0) {
			return false;
		}		
		UserDao ud = new UserDaoImpl();
		User u = null;
		try {
			u = ud.getUserByUserAccount(userAccount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (u == null) {
			return false;
		}		
		//--开始验证密码
		System.out.println(u);		
		return false;
	}

	/**
	 * 用户注册
	 */
	@Override
	public void userRegister() {
		
		
	}
	
	/**
	 * 检查用户输入用户名是否在数据库中已经存在
	 * @return 
	 * @throws SQLException 
	 */
	@Override
	public boolean checkUserAccount(String account) throws SQLException {
		UserDao ud = new UserDaoImpl();
		boolean a =false;
		a = ud.isAccountExist(account);
		return a;		
	}

	@Override
	public boolean transFormUser(String account, String pwd, String userPwdTip, String userName) throws SQLException {
		Boolean a = false;
		UserDao ud = new UserDaoImpl();
		a = ud.enterUser(account,pwd,userPwdTip,userName);
		return a ;
	}

	
	
	
}
