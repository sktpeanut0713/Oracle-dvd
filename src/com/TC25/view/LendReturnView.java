package com.TC25.view;

import com.TC25.biz.UserBiz;
import com.TC25.bizImpl.UserBizImpl;
import com.TC25.tools.InputTools;

public class LendReturnView extends View {
	
	private View mView;
	InputTools input = InputTools.getInstance();
	UserBiz ub = new UserBizImpl();
	
	@Override
	public View showView() {
		System.out.println("<<<<<<<<借还DVD>>>>>>>");		
		System.out.println("\n\t 1.借出DVD");
		System.out.println("\t 2.归还DVD");
		System.out.println("\t 3.返回上级菜单");
		
		nextStep();
		return mView;
	}

	private void nextStep() {
		int a =input.getInt(); 
		switch (a) {
		case 1:
			System.out.println("请输入想要借出的DVD ID");
			int b =input.getInt();
			while(ub.checkDvdStatus(b)) {
				System.out.println("此DVD处于已借出状态,请重新输入一个在库状态的DVD ID");
				b = input.getInt();
			}
			int c = ub.lendDvd(b);
			if(c==1) {
				System.out.println(">>>>>借出成功!<<<<<<");
			}else {
				System.out.println(">>>>>借出失败!<<<<<<");
			}
			mView = new LendReturnView();
			break;
		case 2:
			
			break;
		case 3:
			mView = new SearchView();
			break;
		default:
			break;
		}
		
	}

}
