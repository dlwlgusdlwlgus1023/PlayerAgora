package com.example.teamProject.model.dot.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.dot.dto.DotReplyDTO;

@Repository // dao bean
public class DotReplyDAOImpl implements DotReplyDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<DotReplyDTO> list(int bno) {
		return sqlSession.selectList("dotReply.dotlistReply", bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 占쎈솊疫뀐옙 �빊遺쏙옙
	@Override
	public void create(DotReplyDTO dto) {
		sqlSession.insert("dotReply.dotinsertReply", dto);

	}

}
