package com.example.teamProject.service.btg;

import java.util.List;

import com.example.teamProject.model.btg.dto.BtgReplyDTO;

public interface BtgReplyService {
	public List<BtgReplyDTO> list(int bno);
	public int count(int bno);
	public void create(BtgReplyDTO dto);
}
