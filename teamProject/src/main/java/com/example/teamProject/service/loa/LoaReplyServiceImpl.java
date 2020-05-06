package com.example.teamProject.service.loa;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.loa.dao.LoaReplyDAO;
import com.example.teamProject.model.loa.dto.LoaReplyDTO;

@Service //service bean
public class LoaReplyServiceImpl implements LoaReplyService {
	@Inject
	LoaReplyDAO replyDao;

	@Override
	public List<LoaReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�뙎湲� �벐湲�
	@Override
	public void create(LoaReplyDTO dto) {
		replyDao.create(dto);
	}

}
