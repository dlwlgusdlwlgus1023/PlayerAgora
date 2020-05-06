package com.example.teamProject.service.main;

import java.util.List;

import com.example.teamProject.model.main.dto.MainReplyDTO;

public interface MainReplyService {
	public List<MainReplyDTO> list(int bno);
	public int count(int bno);
	public void create(MainReplyDTO dto);
}
