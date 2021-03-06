package com.example.teamProject.model.ovw.dto;

import java.sql.Date;
import java.util.Arrays;

public class OvwDTO {
	private int bno;//踰덊샇
	private String b_name;//蹂대뜑�씠由�
	private String title;//�젣紐�
	private String posts;//�궡�슜
	private String writer;//湲��벖�씠
	private Date regdate;//�궇吏�
	private int viewcnt;//議고쉶�닔
	private String nick;//�땳�꽕�엫
	private int cnt;
	private String show;
	private String[] files;
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getPosts() {
		return posts;
	}
	public void setPosts(String posts) {
		this.posts = posts;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	@Override
	public String toString() {
		return "OvwDTO [bno=" + bno + ", b_name=" + b_name + ", title=" + title + ", posts=" + posts + ", writer="
				+ writer + ", regdate=" + regdate + ", viewcnt=" + viewcnt + ", nick=" + nick + ", cnt=" + cnt
				+ ", show=" + show + ", files=" + Arrays.toString(files) + "]";
	}
	
}	
