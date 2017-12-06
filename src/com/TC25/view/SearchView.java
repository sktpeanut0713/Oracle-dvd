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

		System.out.println(">>>>>>>请选择下一步>>>>>>>");
		for (int i = 0; i < 50; i++) {
			System.out.print("*");
			if (i == 26) {
				System.out.println("\n\t 1.查看所有DVD");
				System.out.println("\t 2.查看可借DVD");
				System.out.println("\t 3.借出DVD");
				System.out.println("\t 4.归还DVD");
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
			System.out.println("请输入想要借出的Dvd ID");
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
