package com.TC25.bizImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.TC25.bean.DVD;
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
	
	UserDao ud = new UserDaoImpl();

	@Override
	public boolean userLogin(String userAccount, String userPwd) {
	
		if (userAccount == null || userPwd == null || userAccount.length() == 0 || userPwd.length() == 0) {
			return false;
		}		
		User u = null;
		try {
			u = ud.getUserByUserAccount(userAccount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (u == null) {
			return false;
		}		
		//--��ʼ��֤����
		System.out.println("���ĸ�����ϢΪ:"+u);		
		return true;
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
		boolean a =false;
		a = ud.isAccountExist(account);
		return a;		
	}

	@Override
	public boolean transFormUser(String account, String pwd, String userPwdTip, String userName) throws SQLException {
		Boolean a = false;
		a = ud.enterUser(account,pwd,userPwdTip,userName);
		return a ;
	}
		
	@Override
	public ArrayList<DVD> lookAllDvd() throws SQLException {
		ArrayList<DVD> array = ud.showAllDvd();
		return array;
	}

	@Override
	public ArrayList<DVD> showCanLendDvd() {
		ArrayList<DVD> array = ud.showCanLendDvd();
		return array;
	}

	@Override
	public boolean checkDvdStatus(int b) {
		boolean a =ud.checkDvdById(b);
		return a;
	}

	@Override
	public int lendDvd(int b) {
		int a = ud.lendDvdById(b);
		return a;
	}

	
	
	
	
}
