package model;

import java.io.Serializable;

public class Admin implements Serializable{
	private int adminID;
	private String adminName;
	private String passWord;
	
	public Admin() {
	}
	
	public void setAdminID(int adminID) {
		this.adminID = adminID;			
	}
	
	public int getAdminID() {
		return this.adminID;
	}
	
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public String getAdminName() {
		return this.adminName;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getPassWord() {
		return this.passWord;
	}
}
