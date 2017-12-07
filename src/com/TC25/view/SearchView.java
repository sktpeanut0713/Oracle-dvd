package com.TC25.view;

import java.sql.SQLException;
import java.util.ArrayList;

import com.TC25.bean.DVD;
import com.TC25.biz.UserBiz;
import com.TC25.bizImpl.UserBizImpl;
import com.TC25.tools.InputTools;

public class SearchView extends View {
	private View mView;
	InputTools input = InputTools.getInstance();
	UserBiz ub = new UserBizImpl();

	@Override
	public View showView() {

		System.out.println(">>>>>>>请选择下一步<<<<<<");		
		System.out.println("***********************");		
				System.out.println("\n\t 1.查看DVD");
				System.out.println("\t 2.借还DVD");
			
		nextStep();
		return mView;
	}

	private void nextStep() {

		int a = input.getInt();
		switch (a) {
		case 1:
			mView = new ShowDvdView();
			break;
		case 2:
			mView = new LendReturnView();
			break;
		default:
			break;
		}
		
		

	}

}
