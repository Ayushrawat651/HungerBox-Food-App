package com.bean;

public class Admin {
	private int adminId;
	private String adminName;
	private String adminEmail;
	private long adminPhoneNo;
	private String adminPassword;
	
	public Admin(int adminId,String adminName,String adminEmail,long adminPhoneNo,String adminPassword){
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPhoneNo = adminPhoneNo;
		this.adminPassword = adminPassword;
	}
	
	public int getAdminId() {
		return adminId;
	}
	
	public String getAdminName() {
		return adminName;
	}
	
	public String getAdminEmail() {
		return adminEmail;
	}

	public long getAdminPhoneNo() {
		return adminPhoneNo;
	}
	
	public String getAdminPassword() {
		return adminPassword;
	}
	
    // Setters
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public void setAdminPhoneNo(long adminPhoneNo) {
        this.adminPhoneNo = adminPhoneNo;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
