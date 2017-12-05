
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
		UserBiz ub = new UserBizImpl();
		RegisterView rsv = new RegisterView();
		
		
		System.out.println(">>><<<��ӭ�����û�ע�����>>><<<");
		// �õ��û��˺�
		String account = rsv.checkUserInputAccount();
		// �õ��û�����
		String pwd = rsv.gainPassWord();
		// �õ��û�������ʾ
		String userPwdTip = "";
		System.out.println("�����Ƿ���Ҫ����������ʾ(1.��Ҫ.  ����Ϊ����Ҫ)");
		String isNeedPwdTip = input.getString();
		if ("1".equals(isNeedPwdTip)) {
			userPwdTip = rsv.gainUserPwdTips();
		}
		// �õ��û��ǳ�
		System.out.println("�����Ƿ���Ҫ�����ǳ�(1.��Ҫ.  ����Ϊ����Ҫ)");
		String userName = "";
		String isNeedName = input.getString();
		if ("1".equals(isNeedName)) {
			userName = gainUserName();
		}
		
		boolean a = false;
		try {
			a =ub.transFormUser(account,pwd,userPwdTip,userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(a==true) {
		System.out.println("�˺�ע��ɹ�!");
		}else {
			System.out.println("�˺�ע��ʧ��");
		}

		return new MainView();
	}

	/**
	 * @Title: checkUserInputAccount
	 * @Description: �ж��û���������˺��Ƿ������ݿ����Ѿ�����
	 * @return Boolean ��������
	 */
	public String checkUserInputAccount() {
		String account = "";
		Pattern p = Pattern.compile("[A-Z]{1}[a-zA-Z0-9_.]{1,16}");
		Matcher m = null;
		RegisterView rsv = new RegisterView();
		while (true) {
			System.out.println("��������Ҫ�������˺�");
			account = input.getString();
			m = p.matcher(account);
			if (!m.matches()) {
				System.out.println("�����û���������Ҫ�����������룬лл��");
				continue;
			} else {
				break;
			}
		}
		UserBiz ub = new UserBizImpl();
		try {
			while (true == ub.checkUserAccount(account)) {
				System.out.println("���˻����Ѵ���,����������һ�����˺���ע��");
				rsv.checkUserInputAccount();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	/**
	 * @Title: gainPassWord
	 * @Description: ¼���û����������
	 * @return String ��������
	 */
	public String gainPassWord() {
		String pwd1 = "";
		String pwd2 = "";
		Pattern p = Pattern.compile("[a-zA-Z0-9_.]{1,16}");
		Matcher m1 = null;
		Matcher m2 = null;

		while (true) {
			System.out.println("����������");
			pwd1 = input.getString();
			m1 = p.matcher(pwd1);
			if (m1.matches()) {
				break;
			} else {
				System.out.println("�����������Ͳ����Ϲ淶�����������룬лл��");
				break;
			}
		}
		while (true) {
			System.out.println("���ٴ���������");
			pwd2 = input.getString();
			m2 = p.matcher(pwd2);
			if (m2.matches()) {
				if (pwd1.equals(pwd2)) {
					System.out.println("����¼��ɹ�!");
					break;
				} else {
					System.out.println("�ڶ����������һ�β�ƥ��");
				}
			} else {
				System.out.println("�ڶ����������벻���Ϲ淶");
			}
		}
		return pwd2;
	}

	/**
	 * @Title: gainUserName
	 * @Description: ¼���û�������ǳ�
	 * @return String ��������
	 */
	public String gainUserName() {
		String a = "";
		while (true) {
		System.out.println("�������ǳ�");		
		a = input.getString();				
			if (a.length() < 3) {
				System.out.println("�ǳƳ��Ȳ��㣬����������");
			} else if (a.length() >= 3 && a.length() <= 16) {
				System.out.println("�ǳ����óɹ���");
				break;
			} else {
				System.out.println("�ǳƳ���̫��������������");			
			}
		}
		return a;
	}

	/**
	 * @Title: gainUserPwdTips
	 * @Description: ¼���û���������ʾ
	 * @return String ��������
	 */
	public String gainUserPwdTips() {
		String a = "";
		while (true) {
		System.out.println("�����뵱ǰ�˻�������ʾ");		
		a = input.getString();		
			if (a.length() > 16) {
				System.out.println("������ʾ���ȹ��������������룡");			
			} else {
				System.out.println("���óɹ�");
				break;
			}
		}
		return a;
	}

}
