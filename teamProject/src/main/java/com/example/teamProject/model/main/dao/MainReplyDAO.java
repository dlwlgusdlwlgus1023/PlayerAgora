package com.example.teamProject.model.main.dao;

import java.util.List;

import com.example.teamProject.model.main.dto.MainReplyDTO;

public interface MainReplyDAO {
	public List<MainReplyDTO> list(int bno);
	public int count(int bno);
	public void create(MainReplyDTO dto);

}
