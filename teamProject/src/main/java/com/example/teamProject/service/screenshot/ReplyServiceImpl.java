package com.example.teamProject.service.screenshot;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.screenshot.dao.ReplyDAO;
import com.example.teamProject.model.screenshot.dto.ReplyDTO;

@Service //service bean
public class ReplyServiceImpl implements ReplyService {
	@Inject
	ReplyDAO replyDao;

	@Override
	public List<ReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//댓글 쓰기
	@Override
	public void create(ReplyDTO dto) {
		replyDao.create(dto);
	}

}
