package com.TC25.bean;

import java.io.Serializable;

/** 
 * @Title: User.java
 * @package: com.TC25.bean
 * @Description: 实体类页面(View) 调用 业务(Biz)	  
	                                       业务(Biz)  调用 数据操作类(Dao)	  
	                                       数据操作类(Dao) 调用实体类 Bean
 * @author Administrator
 * @date 2017年12月4日下午8:04:56
 * @version 1.0
 */
public class User implements Serializable{
	

	private static final long serialVersionUID = -7339627732512884272L;
	
	private int userId;
	private String userAccount;
	private String userName;
	private String userPwd;
	private String userPwdTips;
	private int userStatus;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserPwdTips() {
		return userPwdTips;
	}
	public void setUserPwdTips(String userPwdTips) {
		this.userPwdTips = userPwdTips;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	
	public User(String userAccount, String userName, String userPwd, String userPwdTips) {
		//--用户ID 等待实际放入时不读取这个ID
		this(0, userAccount, userName, userPwd, userPwdTips, 1);
	}
	
	public User(int userId, String userAccount, String userName, String userPwd, String userPwdTips, int userStatus) {
		super();
		this.userId = userId;
		this.userAccount = userAccount;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userPwdTips = userPwdTips;
		this.userStatus = userStatus;
	}
	
	public User() {
		super();
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userAccount=" + userAccount + ", userName=" + userName + ", userPwd="
				+ userPwd + ", userPwdTips=" + userPwdTips + ", userStatus=" + userStatus + "]";
	}
	
	

}
