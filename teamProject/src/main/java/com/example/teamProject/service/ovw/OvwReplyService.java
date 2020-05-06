package com.example.teamProject.service.ovw;

import java.util.List;

import com.example.teamProject.model.ovw.dto.OvwReplyDTO;

public interface OvwReplyService {
	public List<OvwReplyDTO> list(int bno);
	public int count(int bno);
	public void create(OvwReplyDTO dto);
}
