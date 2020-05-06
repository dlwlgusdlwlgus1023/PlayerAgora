package com.example.teamProject.model.win.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.win.dto.WinReplyDTO;

@Repository // dao bean
public class WinReplyDAOImpl implements WinReplyDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<WinReplyDTO> list(int bno) {
		return sqlSession.selectList("winReply.winlistReply", bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	// �뙎湲� 異붽�
	@Override
	public void create(WinReplyDTO dto) {
		sqlSession.insert("winReply.wininsertReply", dto);

	}

}
