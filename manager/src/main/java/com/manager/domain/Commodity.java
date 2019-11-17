package com.manager.domain;

public class Commodity {
	private int PId;
	private String PName;
	private int PPrise;
	private int SId;
	private String PDescribe;
	private int MId;
	public int getPId() {
		return PId;
	}
	public void setPId(int pId) {
		PId = pId;
	}
	public String getPName() {
		return PName;
	}
	public void setPName(String pName) {
		PName = pName;
	}
	public int getPPrise() {
		return PPrise;
	}
	public void setPPrise(int pPrise) {
		PPrise = pPrise;
	}
	public int getSId() {
		return SId;
	}
	public void setSId(int sId) {
		SId = sId;
	}
	public String getPDescribe() {
		return PDescribe;
	}
	public void setPDescribe(String pDescribe) {
		PDescribe = pDescribe;
	}
	public int getMId() {
		return MId;
	}
	public void setMId(int mId) {
		MId = mId;
	}
	@Override
	public String toString() {
		return "Commodity [PId=" + PId + ", PName=" + PName + ", PPrise=" + PPrise + ", SId=" + SId + ", PDescribe="
				+ PDescribe + ", MId=" + MId + "]";
	}
	
	
}
