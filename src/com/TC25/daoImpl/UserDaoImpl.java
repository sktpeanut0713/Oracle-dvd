package com.TC25.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.TC25.bean.DVD;
import com.TC25.bean.User;
import com.TC25.dao.UserDao;
import com.TC25.tools.DBHelper;

/**
 * @Title: UserDaoImpl.java
 * @package: com.TC25.daoImpl
 * @Description: 数据实现类,view调用业务,业务调用数据
 * @author Administrator
 * @date 2017年12月4日下午8:03:52
 * @version 1.0
 */
public class UserDaoImpl implements UserDao {

	private DBHelper mDB;
	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet rSet;

	public static User peanut = new User();

	public UserDaoImpl() {
		mDB = new DBHelper();
		mConnection = mDB.getConnection();
	}

	// Ctrl + 1
	@Override
	public User getUserByUserAccount(String userAccount) throws SQLException {

		// --问号叫做占位符.
		String sql = "select * from DVD_User where userAccount = ?";

		// --通过连接获取PreparedStatement对象
		mStatement = mConnection.prepareStatement(sql);

		// --通过PreparedStatement对象给占位符做赋值操作
		mStatement.setString(1, userAccount);

		// --通过PreparedStatement调用方法来执行查询语句并获取结果集对象
		// executeQuery 是查询专用
		/*
		 * 如果查的到则结果集中有数据.否则结果集为null
		 */
		rSet = mStatement.executeQuery();
		User u = new User();
		if (rSet.next()) {
			u.setUserId(rSet.getInt("USERID"));
			u.setUserAccount(rSet.getString("USERACCOUNT"));
			u.setUserName(rSet.getString("USERNAME"));
			u.setUserPwd(rSet.getString("USERPWD"));
			u.setUserPwdTips(rSet.getString("USERPWDTIPS"));
			u.setUserStatus(rSet.getInt("USERSTATUS"));
		} else {
			return null;
		}
		peanut = u; // 把登录的User账户保存在静态的uTest中
		return u;
	}

	/**
	 * 判断账号是否已经在数据库中存在
	 */
	public boolean isAccountExist(String account) throws SQLException {
		DBHelper db = new DBHelper();
		Connection conn = db.getConnection();
		PreparedStatement pStment = conn.prepareStatement("select * from DVD_USER");
		ResultSet rSet = pStment.executeQuery();

		boolean b = false;
		// pStment.executeUpdate();//--增删改.
		while (rSet.next()) {
			if (account.equals(rSet.getString("USERACCOUNT"))) {
				b = true;
				break;
			}
		}
		return b;
	}

	/**
	 * 把注册的用户录入数据库
	 * 
	 * @throws SQLException
	 */
	@Override
	public boolean enterUser(String account, String pwd, String userPwdTip, String userName) throws SQLException {
		DBHelper db = new DBHelper();

		String sql = "insert into DVD_USER(USERID,USERACCOUNT,USERPWD,USERPWDTIPS,USERNAME) values(dvduserid_seq.nextval,?,?,?,?)";

		Connection conn = db.getConnection();

		PreparedStatement pStment = conn.prepareStatement(sql);

		pStment.setString(1, account);
		pStment.setString(2, pwd);
		pStment.setString(3, userPwdTip);
		pStment.setString(4, userName);

		pStment.executeUpdate();
		// pStment.executeUpdate();//--增删改.

		return true;
	}

	@Override
	public ArrayList<DVD> showAllDvd() throws SQLException {

		String sql = "select * from DVD";
		mStatement = mConnection.prepareStatement(sql);
		rSet = mStatement.executeQuery(); // 查看

		ArrayList<DVD> array = new ArrayList<>();
		while (rSet.next()) {
			DVD d = new DVD();
			d.setDvdID(rSet.getInt("DVDID"));
			d.setDvdName(rSet.getString("DVDNAME"));
			d.setDvdDate(rSet.getDate("DVDDATE"));
			d.setDvdLendCount(rSet.getInt("DVDLENDCOUNT"));
			d.setDvdStatus(rSet.getInt("DVDSTATUS"));
			array.add(d);
		}
		return array;
	}

	@Override
	public ArrayList<DVD> showCanLendDvd() {

		ArrayList<DVD> array = new ArrayList<>();
		try {
			String sql = "select * from DVD where DVDSTATUS = 1";
			mStatement = mConnection.prepareStatement(sql);
			rSet = mStatement.executeQuery();

			while (rSet.next()) {
				DVD d = new DVD();
				d.setDvdID(rSet.getInt("DVDID"));
				d.setDvdName(rSet.getString("DVDNAME"));
				d.setDvdDate(rSet.getDate("DVDDATE"));
				d.setDvdLendCount(rSet.getInt("DVDLENDCOUNT"));
				d.setDvdStatus(rSet.getInt("DVDSTATUS"));
				array.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;
	}

	@Override
	public boolean checkDvdById(int b) {		
		boolean a = false;
		try {
			String sql = "select * FROM DVD WHERE DVDID = ?";
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setInt(1, b);			
			rSet = mStatement.executeQuery();
			rSet.next();
			if (rSet.getInt("DVDSTATUS") == 2) {
				a = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int lendDvdById(int b) {
		int a =0;
		String sql = "update DVD set DVDSTATUS = 2 where DVDID = ?";
		try {			
			mStatement = mConnection.prepareStatement(sql);			
			mStatement.setInt(1, b);
			a =mStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

}
