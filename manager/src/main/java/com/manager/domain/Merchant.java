package com.manager.domain;

public class Merchant {
	private int MId;
	private String MAccount;
	private String MPasswd;
	private String MName;
	private String MPhone;
	public int getMId() {
		return MId;
	}
	public void setMId(int mId) {
		MId = mId;
	}
	public String getMAccount() {
		return MAccount;
	}
	public void setMAccount(String mAccount) {
		MAccount = mAccount;
	}
	public String getMPasswd() {
		return MPasswd;
	}
	public void setMPasswd(String mPasswd) {
		MPasswd = mPasswd;
	}
	public String getMName() {
		return MName;
	}
	public void setMName(String mName) {
		MName = mName;
	}
	public String getMPhone() {
		return MPhone;
	}
	public void setMPhone(String mPhone) {
		MPhone = mPhone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MAccount == null) ? 0 : MAccount.hashCode());
		result = prime * result + MId;
		result = prime * result + ((MName == null) ? 0 : MName.hashCode());
		result = prime * result + ((MPasswd == null) ? 0 : MPasswd.hashCode());
		result = prime * result + ((MPhone == null) ? 0 : MPhone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Merchant other = (Merchant) obj;
		if (MAccount == null) {
			if (other.MAccount != null)
				return false;
		} else if (!MAccount.equals(other.MAccount))
			return false;
		if (MId != other.MId)
			return false;
		if (MName == null) {
			if (other.MName != null)
				return false;
		} else if (!MName.equals(other.MName))
			return false;
		if (MPasswd == null) {
			if (other.MPasswd != null)
				return false;
		} else if (!MPasswd.equals(other.MPasswd))
			return false;
		if (MPhone == null) {
			if (other.MPhone != null)
				return false;
		} else if (!MPhone.equals(other.MPhone))
			return false;
		return true;
	}
	
	
}
