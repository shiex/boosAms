package com.xbb.entity;

public class User 
{

	private Integer uId ;
	private String loginName ;
	private String loginPass ;
	private String emali ;
	private Boolean status ;
	private String activationCode ;
	private String imgCode;

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}

	public String getEmali() {
		return emali;
	}

	public void setEmali(String emali) {
		this.emali = emali;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public String getImgCode() {
		return imgCode;
	}

	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}



    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", loginName='" + loginName + '\'' +
                ", loginPass='" + loginPass + '\'' +
                ", emali='" + emali + '\'' +
                ", status=" + status +
                ", activationCode='" + activationCode + '\'' +
                ", imgCode='" + imgCode + '\'' +
                '}';
    }
}
 