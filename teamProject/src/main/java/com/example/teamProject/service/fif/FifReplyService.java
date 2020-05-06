package com.example.teamProject.service.fif;

import java.util.List;

import com.example.teamProject.model.fif.dto.FifReplyDTO;

public interface FifReplyService {
	public List<FifReplyDTO> list(int bno);
	public int count(int bno);
	public void create(FifReplyDTO dto);
}
