package com.example.teamProject.model.loa.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.loa.dto.LoaReplyDTO;

@Repository // dao bean
public class LoaReplyDAOImpl implements LoaReplyDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<LoaReplyDTO> list(int bno) {
		return sqlSession.selectList("loaReply.loalistReply", bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 占쎈솊疫뀐옙 �빊遺쏙옙
	@Override
	public void create(LoaReplyDTO dto) {
		sqlSession.insert("loaReply.loainsertReply", dto);

	}

}
