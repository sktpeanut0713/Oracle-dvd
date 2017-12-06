package com.TC25.biz;

import java.sql.SQLException;
import java.util.ArrayList;

import com.TC25.bean.DVD;
import com.TC25.bean.User;

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
	 * @Description: ��ҵ��ʵ�������ṩ����,ȥ�������ݿⷽ���ж��û��������˻��Ƿ����
	 * @param @param account  �û���������˺�
	 * @param @throws SQLException    �趨�ļ� 
	 * @return boolean    true�������ݿ����Ѿ����� 
	 */
	public boolean checkUserAccount(String account) throws SQLException;
	
	/**
	 * @Title: transFormUser 
	 * @Description: ��ҵ��ʵ�������ṩ����,���������ݿⷽ�����û�ע��ʱ���������Ϣ�������ݿ���
	 * @param @param account  ����Ϊ�û�ע��ʱ��������˺�,����,��ʾ������
	 * @param @throws SQLException    �趨�ļ� 
	 * @return boolean    �������� 
	 */
	public boolean transFormUser(String account, String pwd, String userPwdTip, String userName) throws SQLException;
	
	/**
	 * @throws SQLException 
	 * @Title: lookAllDvd 
	 * @Description: ��ҵ��ʵ�������ṩ����,���������ݿⷽ��ȥ�鿴����DVD.����鿴�ɽ�DVD��������
	 * @return     ����DVD����
	 * @throws
	 */
	public ArrayList<DVD> lookAllDvd() throws SQLException;

	public ArrayList<DVD> showCanLendDvd();

	public void LendDvd(int b);
	
	
	

	
	


}

