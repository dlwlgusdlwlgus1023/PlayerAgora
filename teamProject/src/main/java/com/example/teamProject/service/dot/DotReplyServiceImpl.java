package com.example.teamProject.service.dot;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.dot.dao.DotReplyDAO;
import com.example.teamProject.model.dot.dto.DotReplyDTO;

@Service //service bean
public class DotReplyServiceImpl implements DotReplyService {
	@Inject
	DotReplyDAO replyDao;

	@Override
	public List<DotReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�뙎湲� �벐湲�
	@Override
	public void create(DotReplyDTO dto) {
		replyDao.create(dto);
	}

}
