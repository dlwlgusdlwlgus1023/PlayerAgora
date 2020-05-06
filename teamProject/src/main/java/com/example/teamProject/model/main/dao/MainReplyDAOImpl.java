package com.example.teamProject.model.main.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.main.dto.MainReplyDTO;

@Repository // dao bean
public class MainReplyDAOImpl implements MainReplyDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<MainReplyDTO> list(int bno) {
		return sqlSession.selectList("loaReply.loalistReply", bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	// �뜝�럥�냺�뼨�먯삕 占쎈퉲�겫�룞�삕
	@Override
	public void create(MainReplyDTO dto) {
		sqlSession.insert("mainReply.maininsertReply", dto);

	}

}
