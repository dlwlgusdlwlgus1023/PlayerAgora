package com.example.teamProject.service.mic;

import java.util.List;

import com.example.teamProject.model.mic.dto.MicReplyDTO;

public interface MicReplyService {
	public List<MicReplyDTO> list(int bno);
	public int count(int bno);
	public void create(MicReplyDTO dto);
}
