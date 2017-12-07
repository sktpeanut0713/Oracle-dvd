package com.TC25.view;

import java.sql.SQLException;
import java.util.ArrayList;

import com.TC25.bean.DVD;
import com.TC25.biz.UserBiz;
import com.TC25.bizImpl.UserBizImpl;
import com.TC25.tools.InputTools;

/**
 * @Title: ShowDvdView.java
 * @package: com.TC25.view
 * @Description: �鿴DVD����
 * @author Administrator
 * @date 2017��12��7������9:23:39
 * @version 1.0
 */
public class ShowDvdView extends View {

	private View mView;
	InputTools input = InputTools.getInstance();
	UserBiz ub = new UserBizImpl();

	@Override
	public View showView() {
		System.out.println("<<<<<<<<�鿴DVD>>>>>>>");
		for (int i = 0; i < 50; i++) {
			System.out.print("*");
			if (i == 26) {
				System.out.println("\n\t 1.�鿴����DVD");
				System.out.println("\t 2.�鿴�ɽ��DVD");
				System.out.println("\t 3.�����ϼ��˵�");
			}
		}
		nextStep();
		return mView;
	}

	private void nextStep() {
		int a = input.getInt();
		switch (a) {
		case 1:
			try {
				ArrayList<DVD> array = ub.lookAllDvd();
				for (DVD d : array) {
					System.out.println(d);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			mView = new ShowDvdView();
			break;
		case 2:
			ArrayList<DVD> array = ub.showCanLendDvd();
			for (DVD dvd : array) {
				System.out.println(dvd);
			}
			mView = new ShowDvdView();
			break;
		case 3:
			mView = new SearchView();
			break;
		default:
			break;
		}

	}
}
