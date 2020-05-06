package com.example.teamProject.service.win;

import java.util.List;

import com.example.teamProject.model.win.dto.WinReplyDTO;

public interface WinReplyService {
	public List<WinReplyDTO> list(int bno);
	public int count(int bno);
	public void create(WinReplyDTO dto);
}
