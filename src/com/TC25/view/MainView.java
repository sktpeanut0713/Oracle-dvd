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
				System.out.println("\n\t��ӭ����������ҫDVD������");
				System.out.println("\n");
			}
		}
	}

	private void showSplashView() {

		System.out.println();
		System.out.println("1.��¼");
		System.out.println("2.ע��");
		System.out.println("4.�˳�");

		int a = 0;
		while (true) {
			System.out.println("��ѡ��ִ����");
			a = input.getInt();
			if (a >= 1 || a <= 4) {
				break;
			} else {
				System.out.println("�������û�д�ѡ������������!");
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
