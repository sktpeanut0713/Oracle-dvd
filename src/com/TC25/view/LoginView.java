package com.TC25.view;

import java.util.Scanner;

import com.TC25.bean.User;
import com.TC25.biz.UserBiz;
import com.TC25.bizImpl.UserBizImpl;

public class LoginView extends View{

	private View mView;
	
	@Override
	public View showView() {
		
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("�������û��˻�");
			String userAccount = scan.next();
			System.out.println("�������û�����");
			String userPwd = scan.next();			
			UserBiz ub = new UserBizImpl();
			if (ub.userLogin(userAccount, userPwd)) {
				//--��¼�ɹ�
				System.out.println("<<<<<<<<<��½�ɹ�>>>>>>>>>");								
				
				mView =new SearchView();
				return mView;
			} else {
				System.out.println("��¼ʧ��,�����������˺�����");				
				mView =new LoginView();
				return mView;
			} 
		}
	}

	
	
	
	
	
	
	
	
	
}
