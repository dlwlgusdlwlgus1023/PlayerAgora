package com.example.teamProject.model.ovw.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.ovw.dto.OvwReplyDTO;

@Repository // dao bean
public class OvwReplyDAOImpl implements OvwReplyDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<OvwReplyDTO> list(int bno) {
		return sqlSession.selectList("ovwReply.ovwlistReply", bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	// �뙎湲� 異붽�
	@Override
	public void create(OvwReplyDTO dto) {
		sqlSession.insert("ovwReply.ovwinsertReply", dto);

	}

}
