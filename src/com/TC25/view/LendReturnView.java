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
		System.out.println("<<<<<<<<�軹DVD>>>>>>>");		
		System.out.println("\n\t 1.���DVD");
		System.out.println("\t 2.�黹DVD");
		System.out.println("\t 3.�����ϼ��˵�");
		
		nextStep();
		return mView;
	}

	private void nextStep() {
		int a =input.getInt(); 
		switch (a) {
		case 1:
			System.out.println("��������Ҫ�����DVD ID");
			int b =input.getInt();
			while(ub.checkDvdStatus(b)) {
				System.out.println("��DVD�����ѽ��״̬,����������һ���ڿ�״̬��DVD ID");
				b = input.getInt();
			}
			int c = ub.lendDvd(b);
			if(c==1) {
				System.out.println(">>>>>����ɹ�!<<<<<<");
			}else {
				System.out.println(">>>>>���ʧ��!<<<<<<");
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
