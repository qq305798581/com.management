package com.manager.domain;

public class SecondClass {
	
	private int SId;
	private String SName;
	private int FId;
	public int getSId() {
		return SId;
	}
	public void setSId(int sId) {
		SId = sId;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}
	public int getFId() {
		return FId;
	}
	public void setFId(int fId) {
		FId = fId;
	}
	@Override
	public String toString() {
		return SName;
	}
	
	
}
