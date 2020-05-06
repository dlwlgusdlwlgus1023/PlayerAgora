package com.example.teamProject.service.wow;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.wow.dao.WowReplyDAO;
import com.example.teamProject.model.wow.dto.WowReplyDTO;

@Service //service bean
public class WowReplyServiceImpl implements WowReplyService {
	@Inject
	WowReplyDAO replyDao;

	@Override
	public List<WowReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�뙎湲� �벐湲�
	@Override
	public void create(WowReplyDTO dto) {
		replyDao.create(dto);
	}

}
