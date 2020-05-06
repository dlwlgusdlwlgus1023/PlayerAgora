package com.example.teamProject.model.hos.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.hos.dto.HosReplyDTO;

@Repository // dao bean
public class HosReplyDAOImpl implements HosReplyDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<HosReplyDTO> list(int bno) {
		return sqlSession.selectList("hosReply.hoslistReply", bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 占쎈솊疫뀐옙 �빊遺쏙옙
	@Override
	public void create(HosReplyDTO dto) {
		sqlSession.insert("hosReply.hosinsertReply", dto);

	}

}
