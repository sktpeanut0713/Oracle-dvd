
package com.TC25.view;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.TC25.biz.UserBiz;
import com.TC25.bizImpl.UserBizImpl;
import com.TC25.tools.InputTools;

public class RegisterView extends View {

	InputTools input = InputTools.getInstance();
	private View mView;

	@Override
	public View showView() {

		System.out.println("�û�ע�����");
		
		RegisterView rsv = new RegisterView();
		String account = rsv.checkUserAccount();
		
		UserBiz ub = new UserBizImpl();
		boolean a = false;
		try {
			a = ub.checkUserAccount(account);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true){
			if(a==true){
				System.out.println("�˺��ѱ�ע��,����������!");
			}
		}
		
		return null;
	}

	public String checkUserAccount() {		
		String account = "";
		Pattern p = Pattern.compile("[A-Z]{1}[a-zA-Z0-9_.]{1,16}");
		Matcher m = null;

		while (true) {
			System.out.println("��������Ҫ�������˺�");
			account = input.getString();
			m = p.matcher(account);
			if (!m.matches()) {
				System.out.println("�����û���������Ҫ�����������룬лл��");
				continue;
			}else {
				break;
			}
		}
		return account;
	}









}
