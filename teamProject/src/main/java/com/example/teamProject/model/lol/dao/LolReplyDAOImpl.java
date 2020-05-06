package com.example.teamProject.model.lol.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.lol.dto.LolReplyDTO;

@Repository // dao bean
public class LolReplyDAOImpl implements LolReplyDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<LolReplyDTO> list(int bno) {
		return sqlSession.selectList("lolReply.lollistReply", bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 占쎈솊疫뀐옙 �빊遺쏙옙
	@Override
	public void create(LolReplyDTO dto) {
		sqlSession.insert("lolReply.lolinsertReply", dto);

	}

}
