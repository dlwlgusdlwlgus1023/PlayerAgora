package com.example.teamProject.model.screenshot.dto;

import java.util.Arrays;
import java.util.Date;

public class ScreenshotDTO {
	private int bno;
	private String title;
	private String posts;
	private String writer;
	private Date regdate;
	private int viewcnt;
	private String name; //작성자 이름
	private int cnt; //댓글 갯수
	private String show; //화면 표시 여부
	private String[] files; //첨부파일 이름 배열
	private String fullname;
	private String uploaddate;
	private String nick;
	private String game;
	private String abb;
	public String getAbb() {
		return abb;
	}
	public void setAbb(String abb) {
		this.abb = abb;
	}
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getUploaddate() {
		return uploaddate;
	}
	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	//getter,setter,toString()
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "ScreenshotDTO [abb=" + abb + "]";
	}
}
