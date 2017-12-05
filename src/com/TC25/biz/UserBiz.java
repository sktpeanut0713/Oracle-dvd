package com.TC25.biz;

import java.sql.SQLException;

public interface UserBiz {
	
	/**
	 * 根据账户和密码进行登录
	 * @param userAccount  用户账户
	 * @param userPwd      用户密码
	 * @return      登录成功返回true,否则返回false.
	 */
	public boolean userLogin(String userAccount,String userPwd) ;
	
	public void userRegister();
	
	/**
	 * @Title: checkUserAccount 
	 * @Description: 提供业务方法,去调用数据库方法判断用户所输入账户是否存在
	 * @param @param account  对应用户所输入的账号
	 * @param @throws SQLException    设定文件 
	 * @return boolean    true代表数据库中已经存在 
	 */
	public boolean checkUserAccount(String account) throws SQLException;

	public boolean transFormUser(String account, String pwd, String userPwdTip, String userName) throws SQLException;
	



}

