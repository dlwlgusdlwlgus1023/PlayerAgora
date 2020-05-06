package com.example.teamProject.model.mps.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.mps.dto.MpsReplyDTO;

@Repository // dao bean
public class MpsReplyDAOImpl implements MpsReplyDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<MpsReplyDTO> list(int bno) {
		return sqlSession.selectList("mpsReply.mpslistReply", bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 占쎈솊疫뀐옙 �빊遺쏙옙
	@Override
	public void create(MpsReplyDTO dto) {
		sqlSession.insert("mpsReply.mpsinsertReply", dto);

	}

}
