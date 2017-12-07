package com.TC25.bean;

import java.util.Date;

/**
 * @Title: LendRecord.java
 * @package: com.tc25.bean
 * @Description: 借出记录的实体类，提供并封装借出记录的字段，提供构造方法。
 * @author Administrator
 * @date 2017年11月20日下午7:01:23
 * @version 1.0
 */
public class DvdLendRecord {

		//借出记录的id, int类型,自动增加
		private int lrId;
		//借出记录单号,9位数   AA+4位随机数+DVDid(3位数,不足三位数的id采用左补零的方式凑足三位数) int型
		private String lrNumber;
		//记录借出DVDid   int型
		private int dvdId;
		//记录借出DVD名字   String型
		private String dvdName;
		//记录DVD借出日期    date型
		private Date lendDate;
		//DVD预计归还日期  date型
		private Date returnDate;
		//借出用户id   int型
		private int userId;
		//借出记录的状态，当前这张单据的状态
		private boolean lrStatus;
		
		/** 
		 * @Title: getLrId 
		 * @Description: 借出记录实体类的getter/setter方法
		 * @return int    返回类型 
		 */
		public int getLrId() {
			return lrId;
		}
		public void setLrId(int lrId) {
			this.lrId = lrId;
		}
		public String getLrNumber() {
			return lrNumber;
		}
		public void setLrNumber(String lrNumber) {
			this.lrNumber = lrNumber;
		}
		public int getDvdId() {
			return dvdId;
		}
		public void setDvdId(int dvdId) {
			this.dvdId = dvdId;
		}
		public String getDvdName() {
			return dvdName;
		}
		public void setDvdName(String dvdName) {
			this.dvdName = dvdName;
		}
		public Date getLendDate() {
			return lendDate;
		}
		public void setLendDate(Date lendDate) {
			this.lendDate = lendDate;
		}
		public Date getRetuDate() {
			return returnDate;
		}
		public void setRetuDate(Date retuDate) {
			this.returnDate = retuDate;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public boolean isLrStatus() {
			return lrStatus;
		}
		public void setLrStatus(boolean lrStatus) {
			this.lrStatus = lrStatus;
		}
		
		/**
		 * <p>Title: </p> 
		 * <p>Description: 全部参数的构造方法
		 */
		public DvdLendRecord(int lrId, String lrNumber, int dvdId, String dvdName, Date lendDate, Date retuDate, int userId,
				boolean lrStatus) {		
			this( lrNumber,  dvdId,  dvdName,  lendDate, retuDate, userId,lrStatus);
			this.lrId = lrId;
		}
		
		/**
		 * <p>Title: </p> 
		 * <p>Description: 不包含借出记录id的构造函数 
		 */
		public DvdLendRecord(String lrNumber, int dvdId, String dvdName, Date lendDate, Date retuDate, int userId,
				boolean lrStatus) {
			super();
			this.lrNumber = lrNumber;
			this.dvdId = dvdId;
			this.dvdName = dvdName;
			this.lendDate = lendDate;
			this.returnDate = retuDate;
			this.userId = userId;
			this.lrStatus = lrStatus;
		}
		
		/**
		 * <p>Title: </p> 
		 * <p>Description: 无参构造函数
		 */
		public DvdLendRecord() {
			super();
		}
		
		/* 
		 * <p>Title: toString</p> 
		 * <p>Description:重写父类的toString方法
		 */
		@Override
		public String toString() {
			return "LendRecord [lrId=" + lrId + ", lrNumber=" + lrNumber + ", dvdId=" + dvdId + ", dvdName=" + dvdName
					+ ", lendDate=" + lendDate + ", retuDate=" + returnDate + ", userId=" + userId + ", lrStatus=" + lrStatus
					+ "]";
		}
		
		/*
		 * <p>Title: compareTo</p> 
		 * <p>Description: 比较借出日期的大小
		 * @return 0代表相等,正数代表--,负数代表--
		 */
		public int compareTo(DvdLendRecord o) {
			// 要比较的日期跟被比较的日期
			return this.lendDate.compareTo(o.lendDate);
		}
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	

