package com.manager.domain;

public class FirstClass {
	private int FId;
	private String FName;
	public int getFId() {
		return FId;
	}
	public void setFId(int fId) {
		FId = fId;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	@Override
	public String toString() {
		return FName;
	}
	
	
}
