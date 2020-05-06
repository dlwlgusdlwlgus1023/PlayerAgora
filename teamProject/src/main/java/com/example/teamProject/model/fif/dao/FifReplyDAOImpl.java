package com.example.teamProject.model.fif.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.fif.dto.FifReplyDTO;

@Repository // dao bean
public class FifReplyDAOImpl implements FifReplyDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<FifReplyDTO> list(int bno) {
		return sqlSession.selectList("fifReply.fiflistReply", bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	// �뙎湲� 異붽�
	@Override
	public void create(FifReplyDTO dto) {
		sqlSession.insert("fifReply.fifinsertReply", dto);

	}

}
