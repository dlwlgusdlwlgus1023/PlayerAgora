package com.example.teamProject.model.wow.dao;

import java.util.List;

import com.example.teamProject.model.wow.dto.WowReplyDTO;

public interface WowReplyDAO {
	public List<WowReplyDTO> list(int bno);
	public int count(int bno);
	public void create(WowReplyDTO dto);

}
