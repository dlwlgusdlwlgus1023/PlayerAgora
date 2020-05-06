package com.example.teamProject.model.sud.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.sud.dto.SudReplyDTO;

@Repository // dao bean
public class SudReplyDAOImpl implements SudReplyDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<SudReplyDTO> list(int bno) {
		return sqlSession.selectList("sudReply.sudlistReply", bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	// �뙎湲� 異붽�
	@Override
	public void create(SudReplyDTO dto) {
		sqlSession.insert("sudReply.sudinsertReply", dto);

	}

}
