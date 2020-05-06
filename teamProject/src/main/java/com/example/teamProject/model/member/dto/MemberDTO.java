package com.example.teamProject.model.member.dto;

import java.util.Date;

public class MemberDTO {
	private String userid;
	private String pwd;
	private String pwd2;
	private String name;
	private String addr1;
	private String addr2;
	private String addr3;
	private String phone;
	private String email;
	private String birth;
	private String nick;
	private String sex;
	private Date join_date;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwd2() {
		return pwd2;
	}
	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getAddr3() {
		return addr3;
	}
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", pwd=" + pwd + ", pwd2=" + pwd2 + ", name=" + name + ", addr1=" + addr1
				+ ", addr2=" + addr2 + ", addr3=" + addr3 + ", phone=" + phone + ", email=" + email + ", birth=" + birth
				+ ", nick=" + nick + ", sex=" + sex + ", join_date=" + join_date + "]";
	}

	public MemberDTO() {
	
	}
}
