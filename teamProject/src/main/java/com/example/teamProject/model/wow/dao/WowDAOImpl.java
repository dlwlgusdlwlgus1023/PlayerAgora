package com.example.teamProject.model.wow.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.wow.dto.WowDTO;

@Repository //dao bean
public class WowDAOImpl implements WowDAO {
	
	@Inject //占쎌벥鈺곕떯占썸�④쑴竊쒙옙�뿯(DI)
	SqlSession sqlSession;

	@Override
	public void deleteFile(String fullName) {
		sqlSession.delete("wow.deleteFile", fullName);
	}

	//筌ｂ뫀占쏙옙�솁占쎌뵬 �뵳�딅뮞占쎈뱜
	@Override
	public List<String> getAttach(int bno) {
		return sqlSession.selectList("wow.getAttach", bno);
	}

	@Override
	public void addAttach(String fullName) {
		sqlSession.insert("wow.addAttach", fullName);
	}

	@Override
	public void updateAttach(String fullName, int bno) {
		Map<String,Object> map=new HashMap<>();
		map.put("fullName", fullName); //筌ｂ뫀占쏙옙�솁占쎌뵬 占쎌뵠�뵳占�
		map.put("bno", bno); //野껊슣�뻻�눧占� 甕곕뜇�깈
		sqlSession.insert("wow.updateAttach", map);
	}

	@Override
	public void create(WowDTO dto) throws Exception {
		sqlSession.insert("wow.insert", dto);
	}

	@Override
	public void update(WowDTO dto) throws Exception {
		sqlSession.update("wow.update", dto);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("wow.delete", bno);
	}

	@Override
	public List<WowDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("wow.listAll",map);
	}
	public List<WowDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("wow.listPath",map);
	}
	public List<WowDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("wow.listTip",map);
	}
	public List<WowDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("wow.listParty",map);
	}


	@Override
	public void increateViewcnt(int bno) throws Exception {
		sqlSession.update("wow.increateViewcnt", bno);
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("wow.countArticle", map);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("wow.countArticle2", map);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("wow.countArticle3", map);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("wow.countArticle4", map);
	}

	@Override
	public WowDTO read(int bno) throws Exception {
		return sqlSession.selectOne("wow.read", bno);
	}
	@Override
	public WowDTO writer(String writer) throws Exception {
		return sqlSession.selectOne("wow.writer", writer);
	}
	@Override
	public WowDTO nick(String nick) throws Exception {
		return sqlSession.selectOne("wow.nick", nick);
	}
}
