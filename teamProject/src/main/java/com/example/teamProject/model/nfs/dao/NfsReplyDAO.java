package com.example.teamProject.model.nfs.dao;

import java.util.List;

import com.example.teamProject.model.nfs.dto.NfsReplyDTO;

public interface NfsReplyDAO {
	public List<NfsReplyDTO> list(int bno);
	public int count(int bno);
	public void create(NfsReplyDTO dto);

}
