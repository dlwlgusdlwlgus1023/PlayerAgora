package com.example.teamProject.service.btg;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.btg.dao.BtgReplyDAO;
import com.example.teamProject.model.btg.dto.BtgReplyDTO;

@Service //service bean
public class BtgReplyServiceImpl implements BtgReplyService {
	@Inject
	BtgReplyDAO replyDao;

	@Override
	public List<BtgReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//댓글 쓰기
	@Override
	public void create(BtgReplyDTO dto) {
		replyDao.create(dto);
	}

}
