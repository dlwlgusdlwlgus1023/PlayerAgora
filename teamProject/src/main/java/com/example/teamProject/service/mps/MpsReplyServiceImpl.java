package com.example.teamProject.service.mps;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.mps.dao.MpsReplyDAO;
import com.example.teamProject.model.mps.dto.MpsReplyDTO;

@Service //service bean
public class MpsReplyServiceImpl implements MpsReplyService {
	@Inject
	MpsReplyDAO replyDao;

	@Override
	public List<MpsReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�뙎湲� �벐湲�
	@Override
	public void create(MpsReplyDTO dto) {
		replyDao.create(dto);
	}

}
