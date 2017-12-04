package com.TC25.tools;

import java.util.Scanner;
/**
 * @Title: InputTools.java
 * @package: com.tc25.tools
 * @Description: 检查输入是否符合要求的工具类
 * @author Administrator
 * @date 2017年11月21日下午8:14:40
 * @version 1.0
 */
public class InputTools {

private static InputTools instance;
	
	private InputTools() {
		
	}	
	
	public static InputTools getInstance() {
		if (instance == null) {
			instance = new InputTools();
		}
		return instance;
	}

	
	public int getInt() {
		int a =0;
		Scanner scan = new Scanner(System.in);
		while (true) {
			try {
				a = scan.nextInt();
				break;
			} catch (Exception b) {
				String c = scan.next();
				System.out.println("进输入的不是数字，请重新输入!");
			}
		}
		return a;
	}
	
	public Byte getByte() {
		Byte a = 0;
		Scanner scan = new Scanner(System.in);
		while (true) {
			try {
				a = scan.nextByte();
				break;
			} catch (Exception b) {
				String c = scan.next();
				System.out.println("您输入的类型不对，请重新输入!");
			}
		}
		return a;	
	}
	
	public short getShort() {
		
		Scanner scan = new Scanner(System.in);
		short a =0;
		while (true) {
			try {
				 a = scan.nextShort();
				break;
			} catch (Exception b) {
				String c = scan.next();
				System.out.println("您输入的类型不对，请重新输入!");
			}
		}
		return a;
	}
	
	public char getChar() {
		Scanner scan = new Scanner(System.in);
		char a = 'a';
		while (true) {
			try {
				 a = scan.next().charAt(0);
				break;
			} catch (Exception b) {
				String c = scan.next();
				System.out.println("您输入的类型不对，请重新输入!");
			}
		}
		return a;
	}
	
	public float getFloat() {
		Scanner scan = new Scanner(System.in);
		float a =0.0f;
		while (true) {
			try {
				 a = scan.nextFloat();
				break;
			} catch (Exception b) {
				String c = scan.next();
				System.out.println("您输入的类型不对，请重新输入!");
			}
		}
		return a;	
	}
	
	public double getDouble() {
		Scanner scan = new Scanner(System.in);
		double a = 0.0;
		while (true) {
			try {
				a = scan.nextDouble();
				break;
			} catch (Exception b) {
				String c = scan.next();
				System.out.println("您输入的类型不对，请重新输入!");
			}
		}
		return a;
	}
	
	public boolean getBoolean() {
		Scanner scan = new Scanner(System.in);
		boolean a = false;
		while (true) {
			try {
				 a = scan.nextBoolean();
				break;
			} catch (Exception b) {
				String c = scan.next();
				System.out.println("您输入的类型不对，请重新输入!");
			}
		}
		return a;
	}

	public String getString() {
		Scanner scan = new Scanner(System.in);
		String a = "";
		while (true) {
			a = scan.next();
			if (a.length() == 0) {
				System.out.println("不能输入为空,请重新输入");
			} else {
				break;
			}
		}
		return a;
	}
	
	
}
