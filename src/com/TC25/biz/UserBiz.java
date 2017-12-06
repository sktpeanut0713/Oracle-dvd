package com.TC25.biz;

import java.sql.SQLException;
import java.util.ArrayList;

import com.TC25.bean.DVD;
import com.TC25.bean.User;

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
	 * @Description: 在业务实现类中提供方法,去调用数据库方法判断用户所输入账户是否存在
	 * @param @param account  用户所输入的账号
	 * @param @throws SQLException    设定文件 
	 * @return boolean    true代表数据库中已经存在 
	 */
	public boolean checkUserAccount(String account) throws SQLException;
	
	/**
	 * @Title: transFormUser 
	 * @Description: 在业务实现类中提供方法,来调用数据库方法把用户注册时所输入的信息传入数据库中
	 * @param @param account  参数为用户注册时所输入的账号,密码,提示等数据
	 * @param @throws SQLException    设定文件 
	 * @return boolean    返回类型 
	 */
	public boolean transFormUser(String account, String pwd, String userPwdTip, String userName) throws SQLException;
	
	/**
	 * @throws SQLException 
	 * @Title: lookAllDvd 
	 * @Description: 在业务实现类中提供方法,来调用数据库方法去查看所有DVD.下面查看可借DVD方法类似
	 * @return     所有DVD集合
	 * @throws
	 */
	public ArrayList<DVD> lookAllDvd() throws SQLException;

	public ArrayList<DVD> showCanLendDvd();

	public void LendDvd(int b);
	
	
	

	
	


}

