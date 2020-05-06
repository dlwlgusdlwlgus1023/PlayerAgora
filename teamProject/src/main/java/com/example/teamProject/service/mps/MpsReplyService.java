package com.example.teamProject.service.mps;

import java.util.List;

import com.example.teamProject.model.mps.dto.MpsReplyDTO;

public interface MpsReplyService {
	public List<MpsReplyDTO> list(int bno);
	public int count(int bno);
	public void create(MpsReplyDTO dto);
}
