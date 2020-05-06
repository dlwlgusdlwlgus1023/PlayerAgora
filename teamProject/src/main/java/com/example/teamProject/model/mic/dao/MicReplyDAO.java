package com.example.teamProject.model.mic.dao;

import java.util.List;

import com.example.teamProject.model.mic.dto.MicReplyDTO;

public interface MicReplyDAO {
	public List<MicReplyDTO> list(int bno);
	public int count(int bno);
	public void create(MicReplyDTO dto);

}
