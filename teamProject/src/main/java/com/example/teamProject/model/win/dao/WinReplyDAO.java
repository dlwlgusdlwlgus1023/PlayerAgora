package com.example.teamProject.model.win.dao;

import java.util.List;

import com.example.teamProject.model.win.dto.WinReplyDTO;

public interface WinReplyDAO {
	public List<WinReplyDTO> list(int bno);
	public int count(int bno);
	public void create(WinReplyDTO dto);

}
