package com.TC25.bean;

import java.util.Date;

/** 
 * @Title: DVD.java
 * @package: com.tc25.bean
 * @Description: DVDʵ���࣬���ò��ҷ�װDVD����Ҫ���ֶΣ��ṩ����DVD���췽��
 * @author Administrator
 * @date 2017��11��20������7:01:35
 * @version 1.0
 */
public class DVD {

		//DVD���ƣ�String��
		private String dvdName;
		//DVD id��int��
		private int dvdID;
		//DVD��ⷽ��  date��
		private Date dvdDate;
		//DVD״̬��1.�ڿ�   2.���   3.DVD��ɾ�� ��String��
		private int dvdStatus;    
		//DVD������� int��
		private int dvdLendCount;
		
		
		/**
		 * @Title: getDvdName 
		 * @Description: DVD�ֶε�getter/setter����    
		 * @return String    �������� 
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
		 * <p>Description:�ṩȫ�ι��췽��
		 */
		public DVD(String dvdName, int dvdID, Date dvdDate, int dvdStatus, int dvdLendCount) {
			this( dvdName, dvdDate, dvdStatus, dvdLendCount);
			this.dvdID = dvdID;
		}
		
		/**
		 * <p>Title: </p> 
		 * <p>Description: �������ֶ�id�Ĺ��췽�� 
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
		 * <p>Description: �޲ι��췽��
		 */
		public DVD() {
			super();
		}
		
		/**
		 * ��д����toString����
		 */
		@Override
		public String toString() {
			return "DVD [dvdName=" + dvdName + ", dvdID=" + dvdID + ", dvdDate=" + dvdDate + ", dvdStatus=" + dvdStatus
					+ ", dvdLendCount=" + dvdLendCount + "]";
		}

	
	

	
}
