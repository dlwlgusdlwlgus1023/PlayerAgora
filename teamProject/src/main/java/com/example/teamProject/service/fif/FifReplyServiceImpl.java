package com.example.teamProject.service.fif;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.fif.dao.FifReplyDAO;
import com.example.teamProject.model.fif.dto.FifReplyDTO;

@Service //service bean
public class FifReplyServiceImpl implements FifReplyService {
	@Inject
	FifReplyDAO replyDao;

	@Override
	public List<FifReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�뙎湲� �벐湲�
	@Override
	public void create(FifReplyDTO dto) {
		replyDao.create(dto);
	}

}
