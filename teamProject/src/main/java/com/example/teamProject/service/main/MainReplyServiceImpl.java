package com.example.teamProject.service.main;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.main.dao.MainReplyDAO;
import com.example.teamProject.model.main.dto.MainReplyDTO;

@Service //service bean
public class MainReplyServiceImpl implements MainReplyService {
	@Inject
	MainReplyDAO replyDao;

	@Override
	public List<MainReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�뙎湲� �벐湲�
	@Override
	public void create(MainReplyDTO dto) {
		replyDao.create(dto);
	}

}
