package com.TC25.view;

import java.sql.SQLException;
import java.util.ArrayList;

import com.TC25.bean.DVD;
import com.TC25.biz.UserBiz;
import com.TC25.bizImpl.UserBizImpl;
import com.TC25.tools.InputTools;

public class SearchView extends View {

	InputTools input = InputTools.getInstance();
	UserBiz ub = new UserBizImpl();

	@Override
	public View showView() {

		System.out.println(">>>>>>>��ѡ����һ��>>>>>>>");
		for (int i = 0; i < 50; i++) {
			System.out.print("*");
			if (i == 26) {
				System.out.println("\n\t 1.�鿴����DVD");
				System.out.println("\t 2.�鿴�ɽ�DVD");
				System.out.println("\t 3.���DVD");
				System.out.println("\t 4.�黹DVD");
			}
		}
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
			
			break;
		case 2:
			ArrayList<DVD> array = ub.showCanLendDvd();
			for (DVD dvd : array) {
				System.out.println(dvd);
			}
			
			break;
		case 3:
			System.out.println("��������Ҫ�����Dvd ID");
			int b = input.getInt();
			
			ub.LendDvd(b);
			
			break;
		case 4:

			break;

		default:
			break;
		}

		return null;
	}

}
