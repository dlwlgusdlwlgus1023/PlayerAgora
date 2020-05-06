package com.example.teamProject.service.mic;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.mic.dao.MicReplyDAO;
import com.example.teamProject.model.mic.dto.MicReplyDTO;

@Service //service bean
public class MicReplyServiceImpl implements MicReplyService {
	@Inject
	MicReplyDAO replyDao;

	@Override
	public List<MicReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�뙎湲� �벐湲�
	@Override
	public void create(MicReplyDTO dto) {
		replyDao.create(dto);
	}

}
