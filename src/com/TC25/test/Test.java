package com.TC25.test;

import com.TC25.tools.DBHelper;
import com.TC25.view.LoginView;
import com.TC25.view.MainView;
import com.TC25.view.View;

public class Test {

	private View mView;
	/* 页面(View) 调用 业务(Biz)
	 * 
	 * 业务(Biz)  调用 数据操作类(Dao)
	 * 
	 * 数据操作类(Dao) 调用实体类 Bean
	 *
	 */
	public static void main(String[] args) {
		
		View view = new MainView();

		while(view!=null) {
			view = view.showView();		
		}
		//System.out.println("欢迎下次光临");
		
		/*View view  = new LoginView();
		view.showView();*/
	}
	
	
}










