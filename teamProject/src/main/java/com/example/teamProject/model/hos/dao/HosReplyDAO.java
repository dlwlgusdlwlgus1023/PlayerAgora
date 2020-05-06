package com.example.teamProject.model.hos.dao;

import java.util.List;

import com.example.teamProject.model.hos.dto.HosReplyDTO;

public interface HosReplyDAO {
	public List<HosReplyDTO> list(int bno);
	public int count(int bno);
	public void create(HosReplyDTO dto);

}
