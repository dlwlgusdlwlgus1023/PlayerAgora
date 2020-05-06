package com.example.teamProject.model.mic.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.mic.dto.MicReplyDTO;

@Repository // dao bean
public class MicReplyDAOImpl implements MicReplyDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<MicReplyDTO> list(int bno) {
		return sqlSession.selectList("micReply.miclistReply", bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	// �뙎湲� 異붽�
	@Override
	public void create(MicReplyDTO dto) {
		sqlSession.insert("micReply.micinsertReply", dto);

	}

}
