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
			System.out.println("请输入用户账户");
			String userAccount = scan.next();
			System.out.println("请输入用户密码");
			String userPwd = scan.next();			
			UserBiz ub = new UserBizImpl();
			if (ub.userLogin(userAccount, userPwd)) {
				//--登录成功
				System.out.println("<<<<<<<<<登陆成功>>>>>>>>>");								
				
				mView =new SearchView();
				return mView;
			} else {
				System.out.println("登录失败,请重新输入账号密码");				
				mView =new LoginView();
				return mView;
			} 
		}
	}

	
	
	
	
	
	
	
	
	
}
