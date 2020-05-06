package com.example.teamProject.model.btg.dao;

import java.util.List;

import com.example.teamProject.model.btg.dto.BtgReplyDTO;

public interface BtgReplyDAO {
	public List<BtgReplyDTO> list(int bno);
	public int count(int bno);
	public void create(BtgReplyDTO dto);

}
