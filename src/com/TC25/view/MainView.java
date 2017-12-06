package com.TC25.view;

import com.TC25.tools.InputTools;

public class MainView extends View {

	private View mView;

	InputTools input = InputTools.getInstance();

	@Override
	public View showView() {
		showWelcome();
		showSplashView();
		return mView;
	}

	private void showWelcome() {
		for (int i = 0; i < 100; i++) {
			System.out.print("*");
			if (i == 49) {
				System.out.println("\n");
				System.out.println("\n\t欢迎来到王者荣耀DVD音响厅");
				System.out.println("\n");
			}
		}
	}

	private void showSplashView() {

		System.out.println();
		System.out.println("1.登录");
		System.out.println("2.注册");
		System.out.println("4.退出");

		int a = 0;
		while (true) {
			System.out.println("请选择执行项");
			a = input.getInt();
			if (a >= 1 || a <= 4) {
				break;
			} else {
				System.out.println("输入错误，没有此选项请重新输入!");
			}
		}
		switch (a) {	
		case 1:
			mView = new LoginView();
			break;
		case 2:
			mView = new RegisterView();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			break;
		}

	}

}
