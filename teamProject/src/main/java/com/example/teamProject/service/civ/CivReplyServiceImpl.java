package com.example.teamProject.service.civ;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.civ.dao.CivReplyDAO;
import com.example.teamProject.model.civ.dto.CivReplyDTO;

@Service //service bean
public class CivReplyServiceImpl implements CivReplyService {
	@Inject
	CivReplyDAO replyDao;

	@Override
	public List<CivReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�뙎湲� �벐湲�
	@Override
	public void create(CivReplyDTO dto) {
		replyDao.create(dto);
	}

}
