package com.TC25.biz;

public interface UserBiz {
	
	/**
	 * �����˻���������е�¼
	 * @param userAccount  �û��˻�
	 * @param userPwd      �û�����
	 * @return      ��¼�ɹ�����true,���򷵻�false.
	 */
	public boolean userLogin(String userAccount,String userPwd) ;
	
	public void userRegister();

	public void checkUserAccount(String account);
}
