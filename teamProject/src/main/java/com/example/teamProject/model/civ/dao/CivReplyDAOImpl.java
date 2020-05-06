package com.example.teamProject.model.civ.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.civ.dto.CivReplyDTO;

@Repository // dao bean
public class CivReplyDAOImpl implements CivReplyDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<CivReplyDTO> list(int bno) {
		return sqlSession.selectList("civReply.civlistReply", bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	// �뙎湲� 異붽�
	@Override
	public void create(CivReplyDTO dto) {
		sqlSession.insert("civReply.civinsertReply", dto);

	}

}
