package com.example.teamProject.model.wow.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.wow.dto.WowReplyDTO;

@Repository // dao bean
public class WowReplyDAOImpl implements WowReplyDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<WowReplyDTO> list(int bno) {
		return sqlSession.selectList("wowReply.wowlistReply", bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 占쎈솊疫뀐옙 �빊遺쏙옙
	@Override
	public void create(WowReplyDTO dto) {
		sqlSession.insert("wowReply.wowinsertReply", dto);

	}

}
