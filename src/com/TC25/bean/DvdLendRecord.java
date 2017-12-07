package com.TC25.bean;

import java.util.Date;

/**
 * @Title: LendRecord.java
 * @package: com.tc25.bean
 * @Description: �����¼��ʵ���࣬�ṩ����װ�����¼���ֶΣ��ṩ���췽����
 * @author Administrator
 * @date 2017��11��20������7:01:23
 * @version 1.0
 */
public class DvdLendRecord {

		//�����¼��id, int����,�Զ�����
		private int lrId;
		//�����¼����,9λ��   AA+4λ�����+DVDid(3λ��,������λ����id��������ķ�ʽ������λ��) int��
		private String lrNumber;
		//��¼���DVDid   int��
		private int dvdId;
		//��¼���DVD����   String��
		private String dvdName;
		//��¼DVD�������    date��
		private Date lendDate;
		//DVDԤ�ƹ黹����  date��
		private Date returnDate;
		//����û�id   int��
		private int userId;
		//�����¼��״̬����ǰ���ŵ��ݵ�״̬
		private boolean lrStatus;
		
		/** 
		 * @Title: getLrId 
		 * @Description: �����¼ʵ�����getter/setter����
		 * @return int    �������� 
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
		 * <p>Description: ȫ�������Ĺ��췽��
		 */
		public DvdLendRecord(int lrId, String lrNumber, int dvdId, String dvdName, Date lendDate, Date retuDate, int userId,
				boolean lrStatus) {		
			this( lrNumber,  dvdId,  dvdName,  lendDate, retuDate, userId,lrStatus);
			this.lrId = lrId;
		}
		
		/**
		 * <p>Title: </p> 
		 * <p>Description: �����������¼id�Ĺ��캯�� 
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
		 * <p>Description: �޲ι��캯��
		 */
		public DvdLendRecord() {
			super();
		}
		
		/* 
		 * <p>Title: toString</p> 
		 * <p>Description:��д�����toString����
		 */
		@Override
		public String toString() {
			return "LendRecord [lrId=" + lrId + ", lrNumber=" + lrNumber + ", dvdId=" + dvdId + ", dvdName=" + dvdName
					+ ", lendDate=" + lendDate + ", retuDate=" + returnDate + ", userId=" + userId + ", lrStatus=" + lrStatus
					+ "]";
		}
		
		/*
		 * <p>Title: compareTo</p> 
		 * <p>Description: �ȽϽ�����ڵĴ�С
		 * @return 0�������,��������--,��������--
		 */
		public int compareTo(DvdLendRecord o) {
			// Ҫ�Ƚϵ����ڸ����Ƚϵ�����
			return this.lendDate.compareTo(o.lendDate);
		}
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	

