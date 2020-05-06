package com.example.teamProject.model.main.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.main.dto.MainDTO;

@Repository //dao bean
public class MainDAOImpl implements MainDAO {
	
	@Inject //�뜝�럩踰ι댖怨뺣뼬�뜝�뜽占썩몿�뫒塋딆뮋�삕占쎈엷(DI)
	SqlSession sqlSession;

	@Override
	public void deleteFile(String fullName) {
		sqlSession.delete("main.deleteFile", fullName);
	}

	//嶺뚳퐘維��뜝�룞�삕占쎌냱�뜝�럩逾� 占쎈뎨占쎈봾裕욃뜝�럥諭�
	@Override
	public List<String> getAttach(int bno) {
		return sqlSession.selectList("main.getAttach", bno);
	}

	@Override
	public void addAttach(String fullName) {
		sqlSession.insert("main.addAttach", fullName);
	}

	@Override
	public void updateAttach(String fullName, int bno) {
		Map<String,Object> map=new HashMap<>();
		map.put("fullName", fullName); //嶺뚳퐘維��뜝�룞�삕占쎌냱�뜝�럩逾� �뜝�럩逾좑옙逾녑뜝占�
		map.put("bno", bno); //�뇦猿딆뒩占쎈뻣占쎈닱�뜝占� �뵓怨뺣쐡占쎄퉰
		sqlSession.insert("main.updateAttach", map);
	}

	@Override
	public void create(MainDTO dto) throws Exception {
		sqlSession.insert("main.insert", dto);
	}

	@Override
	public void update(MainDTO dto) throws Exception {
		sqlSession.update("main.update", dto);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("main.delete", bno);
	}

	@Override
	public List<MainDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("main.listAll",map);
	}


	@Override
	public void increateViewcnt(int bno) throws Exception {
		sqlSession.update("main.increateViewcnt", bno);
	}




	@Override
	public MainDTO read(int bno) throws Exception {
		return sqlSession.selectOne("main.read", bno);
	}
	@Override
	public MainDTO writer(String writer) throws Exception {
		return sqlSession.selectOne("main.writer", writer);
	}
	@Override
	public MainDTO nick(String nick) throws Exception {
		return sqlSession.selectOne("main.nick", nick);
	}
	@Override
	public MainDTO bord(String nick) throws Exception {
		return sqlSession.selectOne("main.bord", nick);
	}
	@Override
	public MainDTO t_name(String nick) throws Exception {
		return sqlSession.selectOne("main.t_name", nick);
	}
}
