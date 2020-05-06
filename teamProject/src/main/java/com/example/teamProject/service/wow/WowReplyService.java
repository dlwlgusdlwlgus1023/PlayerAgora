package com.example.teamProject.service.wow;

import java.util.List;

import com.example.teamProject.model.wow.dto.WowReplyDTO;

public interface WowReplyService {
	public List<WowReplyDTO> list(int bno);
	public int count(int bno);
	public void create(WowReplyDTO dto);
}
