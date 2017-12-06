package com.TC25.bean;

import java.util.Date;

/** 
 * @Title: DVD.java
 * @package: com.tc25.bean
 * @Description: DVD实体类，设置并且封装DVD所需要的字段，提供三种DVD构造方法
 * @author Administrator
 * @date 2017年11月20日下午7:01:35
 * @version 1.0
 */
public class DVD {

		//DVD名称，String型
		private String dvdName;
		//DVD id，int型
		private int dvdID;
		//DVD入库方法  date型
		private Date dvdDate;
		//DVD状态，1.在库   2.借出   3.DVD已删除 ，String型
		private int dvdStatus;    
		//DVD借出次数 int型
		private int dvdLendCount;
		
		
		/**
		 * @Title: getDvdName 
		 * @Description: DVD字段的getter/setter方法    
		 * @return String    返回类型 
		 */
		public String getDvdName() {
			return dvdName;
		}
		public void setDvdName(String dvdName) {
			this.dvdName = dvdName;
		}
		public int getDvdID() {
			return dvdID;
		}
		public void setDvdID(int dvdID) {
			this.dvdID = dvdID;
		}
		public Date getDvdDate() {
			return dvdDate;
		}
		public void setDvdDate(Date dvdDate) {
			this.dvdDate = dvdDate;
		}
		public int getDvdStatus() {
			return dvdStatus;
		}
		public void setDvdStatus(int dvdStatus) {
			this.dvdStatus = dvdStatus;
		}
		public int getDvdLendCount() {
			return dvdLendCount;
		}
		public void setDvdLendCount(int dvdLendCount) {
			this.dvdLendCount = dvdLendCount;
		}
		
		/**
		 * <p>Title: </p> 
		 * <p>Description:提供全参构造方法
		 */
		public DVD(String dvdName, int dvdID, Date dvdDate, int dvdStatus, int dvdLendCount) {
			this( dvdName, dvdDate, dvdStatus, dvdLendCount);
			this.dvdID = dvdID;
		}
		
		/**
		 * <p>Title: </p> 
		 * <p>Description: 不包含字段id的构造方法 
		 */
		public DVD(String dvdName, Date dvdDate, int dvdStatus, int dvdLendCount) {
			super();
			this.dvdName = dvdName;
			this.dvdDate = dvdDate;
			this.dvdStatus = dvdStatus;
			this.dvdLendCount = dvdLendCount;
		}
		
		/**
		 * <p>Title: </p> 
		 * <p>Description: 无参构造方法
		 */
		public DVD() {
			super();
		}
		
		/**
		 * 重写父类toString方法
		 */
		@Override
		public String toString() {
			return "DVD [dvdName=" + dvdName + ", dvdID=" + dvdID + ", dvdDate=" + dvdDate + ", dvdStatus=" + dvdStatus
					+ ", dvdLendCount=" + dvdLendCount + "]";
		}

	
	

	
}
