package com.manager.domain;

import java.sql.Timestamp;

public class Transaction {
	private int OId;
	private Timestamp OTime;
	private int OState;
	private int UId;
	private int PQuanlity;
	private int PId;
	public int getOId() {
		return OId;
	}
	public void setOId(int oId) {
		OId = oId;
	}
	public Timestamp getOTime() {
		return OTime;
	}
	public void setOTime(Timestamp oTime) {
		OTime = oTime;
	}
	public int getOState() {
		return OState;
	}
	public void setOState(int oState) {
		OState = oState;
	}
	public int getUId() {
		return UId;
	}
	public void setUId(int uId) {
		UId = uId;
	}
	public int getPQuanlity() {
		return PQuanlity;
	}
	public void setPQuanlity(int pQuanlity) {
		PQuanlity = pQuanlity;
	}
	public int getPId() {
		return PId;
	}
	public void setPId(int pId) {
		PId = pId;
	}
	
	
}
