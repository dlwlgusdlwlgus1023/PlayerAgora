package com.example.teamProject.service.hos;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.hos.dao.HosReplyDAO;
import com.example.teamProject.model.hos.dto.HosReplyDTO;

@Service //service bean
public class HosReplyServiceImpl implements HosReplyService {
	@Inject
	HosReplyDAO replyDao;

	@Override
	public List<HosReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�뙎湲� �벐湲�
	@Override
	public void create(HosReplyDTO dto) {
		replyDao.create(dto);
	}

}
