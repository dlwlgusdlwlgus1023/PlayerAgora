package com.example.teamProject.service.nfs;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.nfs.dao.NfsReplyDAO;
import com.example.teamProject.model.nfs.dto.NfsReplyDTO;

@Service //service bean
public class NfsReplyServiceImpl implements NfsReplyService {
	@Inject
	NfsReplyDAO replyDao;

	@Override
	public List<NfsReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�뙎湲� �벐湲�
	@Override
	public void create(NfsReplyDTO dto) {
		replyDao.create(dto);
	}

}
