package com.example.teamProject.service.hos;

import java.util.List;

import com.example.teamProject.model.hos.dto.HosReplyDTO;

public interface HosReplyService {
	public List<HosReplyDTO> list(int bno);
	public int count(int bno);
	public void create(HosReplyDTO dto);
}
