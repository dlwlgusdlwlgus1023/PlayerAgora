package com.example.teamProject.service.ovw;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.ovw.dao.OvwReplyDAO;
import com.example.teamProject.model.ovw.dto.OvwReplyDTO;

@Service //service bean
public class OvwReplyServiceImpl implements OvwReplyService {
	@Inject
	OvwReplyDAO replyDao;

	@Override
	public List<OvwReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�뙎湲� �벐湲�
	@Override
	public void create(OvwReplyDTO dto) {
		replyDao.create(dto);
	}

}
