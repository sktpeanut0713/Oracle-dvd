package com.TC25.biz;

import java.sql.SQLException;

public interface UserBiz {
	
	/**
	 * �����˻���������е�¼
	 * @param userAccount  �û��˻�
	 * @param userPwd      �û�����
	 * @return      ��¼�ɹ�����true,���򷵻�false.
	 */
	public boolean userLogin(String userAccount,String userPwd) ;
	
	public void userRegister();
	
	/**
	 * @Title: checkUserAccount 
	 * @Description: �ṩҵ�񷽷�,ȥ�������ݿⷽ���ж��û��������˻��Ƿ����
	 * @param @param account  ��Ӧ�û���������˺�
	 * @param @throws SQLException    �趨�ļ� 
	 * @return boolean    true�������ݿ����Ѿ����� 
	 */
	public boolean checkUserAccount(String account) throws SQLException;

	public boolean transFormUser(String account, String pwd, String userPwdTip, String userName) throws SQLException;
	



}

