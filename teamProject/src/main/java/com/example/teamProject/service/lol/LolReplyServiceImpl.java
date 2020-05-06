package com.example.teamProject.service.lol;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.lol.dao.LolReplyDAO;
import com.example.teamProject.model.lol.dto.LolReplyDTO;

@Service //service bean
public class LolReplyServiceImpl implements LolReplyService {
	@Inject
	LolReplyDAO replyDao;

	@Override
	public List<LolReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�뙎湲� �벐湲�
	@Override
	public void create(LolReplyDTO dto) {
		replyDao.create(dto);
	}

}
