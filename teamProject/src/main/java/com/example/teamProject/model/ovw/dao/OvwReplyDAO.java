package com.example.teamProject.model.ovw.dao;

import java.util.List;

import com.example.teamProject.model.ovw.dto.OvwReplyDTO;

public interface OvwReplyDAO {
	public List<OvwReplyDTO> list(int bno);
	public int count(int bno);
	public void create(OvwReplyDTO dto);

}
