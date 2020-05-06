package com.example.teamProject.model.sta.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.sta.dto.StaReplyDTO;

@Repository // dao bean
public class StaReplyDAOImpl implements StaReplyDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<StaReplyDTO> list(int bno) {
		return sqlSession.selectList("staReply.stalistReply", bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 占쎈솊疫뀐옙 �빊遺쏙옙
	@Override
	public void create(StaReplyDTO dto) {
		sqlSession.insert("staReply.stainsertReply", dto);

	}

}
