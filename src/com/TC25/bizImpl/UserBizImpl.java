package com.TC25.bizImpl;

import java.sql.SQLException;

import com.TC25.bean.User;
import com.TC25.biz.UserBiz;
import com.TC25.dao.UserDao;
import com.TC25.daoImpl.UserDaoImpl;
/**
 * @Title: UserBizImpl.java
 * @package: com.TC25.bizImpl
 * @Description: ҵ��ʵ���� view����ҵ��
 * @author Administrator
 * @date 2017��12��4������8:03:10
 * @version 1.0
 */
public class UserBizImpl implements UserBiz {

	/**
	 * �û���¼����
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
		//--��ʼ��֤����
		System.out.println(u);		
		return false;
	}

	/**
	 * �û�ע��
	 */
	@Override
	public void userRegister() {
		
		
	}
	
	/**
	 * ����û������û����Ƿ������ݿ����Ѿ�����
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
