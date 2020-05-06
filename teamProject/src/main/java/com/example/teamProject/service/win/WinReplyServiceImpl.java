package com.example.teamProject.service.win;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.win.dao.WinReplyDAO;
import com.example.teamProject.model.win.dto.WinReplyDTO;

@Service //service bean
public class WinReplyServiceImpl implements WinReplyService {
	@Inject
	WinReplyDAO replyDao;

	@Override
	public List<WinReplyDTO> list(int bno) {
		return replyDao.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�뙎湲� �벐湲�
	@Override
	public void create(WinReplyDTO dto) {
		replyDao.create(dto);
	}

}
