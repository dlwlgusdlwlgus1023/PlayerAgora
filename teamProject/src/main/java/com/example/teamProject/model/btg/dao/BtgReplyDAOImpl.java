package com.example.teamProject.model.btg.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.btg.dto.BtgReplyDTO;

@Repository // dao bean
public class BtgReplyDAOImpl implements BtgReplyDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<BtgReplyDTO> list(int bno) {
		return sqlSession.selectList("btgReply.btglistReply", bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 댓글 추가
	@Override
	public void create(BtgReplyDTO dto) {
		sqlSession.insert("btgReply.btginsertReply", dto);

	}

}
