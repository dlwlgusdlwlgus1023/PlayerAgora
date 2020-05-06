package com.example.teamProject.model.nfs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.nfs.dto.NfsReplyDTO;

@Repository // dao bean
public class NfsReplyDAOImpl implements NfsReplyDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<NfsReplyDTO> list(int bno) {
		return sqlSession.selectList("nfsReply.nfslistReply", bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	// �뙎湲� 異붽�
	@Override
	public void create(NfsReplyDTO dto) {
		sqlSession.insert("nfsReply.nfsinsertReply", dto);

	}

}
