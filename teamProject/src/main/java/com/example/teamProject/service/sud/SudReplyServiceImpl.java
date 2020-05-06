package com.example.teamProject.service.sud;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.sud.dao.SudReplyDAO;
import com.example.teamProject.model.sud.dto.SudReplyDTO;

@Service //service bean
public class SudReplyServiceImpl implements SudReplyService {
	@Inject
	SudReplyDAO replyDao;

	@Override
	public List<SudReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�뙎湲� �벐湲�
	@Override
	public void create(SudReplyDTO dto) {
		replyDao.create(dto);
	}

}
