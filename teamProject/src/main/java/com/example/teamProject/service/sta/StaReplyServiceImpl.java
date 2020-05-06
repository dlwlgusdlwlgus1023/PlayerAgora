package com.example.teamProject.service.sta;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.sta.dao.StaReplyDAO;
import com.example.teamProject.model.sta.dto.StaReplyDTO;

@Service //service bean
public class StaReplyServiceImpl implements StaReplyService {
	@Inject
	StaReplyDAO replyDao;

	@Override
	public List<StaReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�뙎湲� �벐湲�
	@Override
	public void create(StaReplyDTO dto) {
		replyDao.create(dto);
	}

}
