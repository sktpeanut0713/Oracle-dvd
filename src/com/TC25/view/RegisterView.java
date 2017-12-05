
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
		
		
		System.out.println(">>><<<欢迎来到用户注册界面>>><<<");
		// 得到用户账号
		String account = rsv.checkUserInputAccount();
		// 得到用户密码
		String pwd = rsv.gainPassWord();
		// 得到用户密码提示
		String userPwdTip = "";
		System.out.println("请问是否需要输入密码提示(1.需要.  其他为不需要)");
		String isNeedPwdTip = input.getString();
		if ("1".equals(isNeedPwdTip)) {
			userPwdTip = rsv.gainUserPwdTips();
		}
		// 得到用户昵称
		System.out.println("请问是否需要输入昵称(1.需要.  其他为不需要)");
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
		System.out.println("账号注册成功!");
		}else {
			System.out.println("账号注册失败");
		}

		return new MainView();
	}

	/**
	 * @Title: checkUserInputAccount
	 * @Description: 判断用户所输入的账号是否在数据库中已经存在
	 * @return Boolean 返回类型
	 */
	public String checkUserInputAccount() {
		String account = "";
		Pattern p = Pattern.compile("[A-Z]{1}[a-zA-Z0-9_.]{1,16}");
		Matcher m = null;
		RegisterView rsv = new RegisterView();
		while (true) {
			System.out.println("请输入想要创建的账号");
			account = input.getString();
			m = p.matcher(account);
			if (!m.matches()) {
				System.out.println("输入用户名不符合要求，请重新输入，谢谢！");
				continue;
			} else {
				break;
			}
		}
		UserBiz ub = new UserBizImpl();
		try {
			while (true == ub.checkUserAccount(account)) {
				System.out.println("此账户名已存在,请重新输入一个新账号名注册");
				rsv.checkUserInputAccount();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	/**
	 * @Title: gainPassWord
	 * @Description: 录入用户输入的密码
	 * @return String 返回类型
	 */
	public String gainPassWord() {
		String pwd1 = "";
		String pwd2 = "";
		Pattern p = Pattern.compile("[a-zA-Z0-9_.]{1,16}");
		Matcher m1 = null;
		Matcher m2 = null;

		while (true) {
			System.out.println("请输入密码");
			pwd1 = input.getString();
			m1 = p.matcher(pwd1);
			if (m1.matches()) {
				break;
			} else {
				System.out.println("输入密码类型不符合规范，请重新输入，谢谢！");
				break;
			}
		}
		while (true) {
			System.out.println("请再次输入密码");
			pwd2 = input.getString();
			m2 = p.matcher(pwd2);
			if (m2.matches()) {
				if (pwd1.equals(pwd2)) {
					System.out.println("密码录入成功!");
					break;
				} else {
					System.out.println("第二次密码与第一次不匹配");
				}
			} else {
				System.out.println("第二次输入密码不符合规范");
			}
		}
		return pwd2;
	}

	/**
	 * @Title: gainUserName
	 * @Description: 录入用户输入的昵称
	 * @return String 返回类型
	 */
	public String gainUserName() {
		String a = "";
		while (true) {
		System.out.println("请输入昵称");		
		a = input.getString();				
			if (a.length() < 3) {
				System.out.println("昵称长度不足，请重新输入");
			} else if (a.length() >= 3 && a.length() <= 16) {
				System.out.println("昵称设置成功！");
				break;
			} else {
				System.out.println("昵称长度太长，请重新输入");			
			}
		}
		return a;
	}

	/**
	 * @Title: gainUserPwdTips
	 * @Description: 录入用户的密码提示
	 * @return String 返回类型
	 */
	public String gainUserPwdTips() {
		String a = "";
		while (true) {
		System.out.println("请输入当前账户密码提示");		
		a = input.getString();		
			if (a.length() > 16) {
				System.out.println("密码提示长度过长，请重新输入！");			
			} else {
				System.out.println("设置成功");
				break;
			}
		}
		return a;
	}

}
