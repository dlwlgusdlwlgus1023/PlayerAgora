package com.example.teamProject.service.nfs;

import java.util.List;

import com.example.teamProject.model.nfs.dto.NfsReplyDTO;

public interface NfsReplyService {
	public List<NfsReplyDTO> list(int bno);
	public int count(int bno);
	public void create(NfsReplyDTO dto);
}
