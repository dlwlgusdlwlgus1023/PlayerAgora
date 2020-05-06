package com.example.teamProject.model.main.dto;

import java.sql.Date;
import java.util.Arrays;

public class MainDTO {
	private int bno;//�뵓怨뺣쐡占쎄퉰
	private String b_name;//�솻洹ｏ옙占쎌맠�뜝�럩逾좑옙逾녑뜝占�
	private String title;//�뜝�럩�젷嶺뚮쪋�삕
	private String posts;//�뜝�럡���뜝�럩�뮔
	private String writer;//�뼨�먯삕�뜝�럥荑��뜝�럩逾�
	private Date regdate;//�뜝�럡�뀏嶺뚯쉻�삕
	private int viewcnt;//�댖怨뚰�э옙�뤂�뜝�럥�빢
	private String nick;//�뜝�럥鍮뤷뜝�럡�맟�뜝�럩肉�
	private int cnt;
	private String show;
	private String bord;
	private String t_name;
	private String[] files;
	
	
	public String getBord() {
		return bord;
	}
	public void setBord(String bord) {
		this.bord = bord;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
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
		return "MainDTO [bno=" + bno + ", b_name=" + b_name + ", title=" + title + ", posts=" + posts + ", writer="
				+ writer + ", regdate=" + regdate + ", viewcnt=" + viewcnt + ", nick=" + nick + ", cnt=" + cnt
				+ ", show=" + show + ", bord=" + bord + ", t_name=" + t_name + ", files=" + Arrays.toString(files)
				+ "]";
	}
	
	
}	
