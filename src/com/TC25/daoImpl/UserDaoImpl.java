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
 * @Description: ����ʵ����,view����ҵ��,ҵ���������
 * @author Administrator
 * @date 2017��12��4������8:03:52
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

		// --�ʺŽ���ռλ��.
		String sql = "select * from DVD_User where userAccount = ?";

		// --ͨ�����ӻ�ȡPreparedStatement����
		mStatement = mConnection.prepareStatement(sql);

		// --ͨ��PreparedStatement�����ռλ������ֵ����
		mStatement.setString(1, userAccount);

		// --ͨ��PreparedStatement���÷�����ִ�в�ѯ��䲢��ȡ���������
		// executeQuery �ǲ�ѯר��
		/*
		 * �����ĵ���������������.��������Ϊnull
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
		peanut = u; // �ѵ�¼��User�˻������ھ�̬��uTest��
		return u;
	}

	/**
	 * �ж��˺��Ƿ��Ѿ������ݿ��д���
	 */
	public boolean isAccountExist(String account) throws SQLException {
		DBHelper db = new DBHelper();
		Connection conn = db.getConnection();
		PreparedStatement pStment = conn.prepareStatement("select * from DVD_USER");
		ResultSet rSet = pStment.executeQuery();

		boolean b = false;
		// pStment.executeUpdate();//--��ɾ��.
		while (rSet.next()) {
			if (account.equals(rSet.getString("USERACCOUNT"))) {
				b = true;
				break;
			}
		}
		return b;
	}

	/**
	 * ��ע����û�¼�����ݿ�
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
		// pStment.executeUpdate();//--��ɾ��.

		return true;
	}

	@Override
	public ArrayList<DVD> showAllDvd() throws SQLException {

		String sql = "select * from DVD";
		mStatement = mConnection.prepareStatement(sql);
		rSet = mStatement.executeQuery(); // �鿴

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
