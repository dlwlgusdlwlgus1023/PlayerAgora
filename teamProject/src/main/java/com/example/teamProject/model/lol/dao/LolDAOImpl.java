package com.example.teamProject.model.lol.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.lol.dto.LolDTO;

@Repository //dao bean
public class LolDAOImpl implements LolDAO {
	
	@Inject //占쎌벥鈺곕떯占썸�④쑴竊쒙옙�뿯(DI)
	SqlSession sqlSession;

	@Override
	public void deleteFile(String fullName) {
		sqlSession.delete("lol.deleteFile", fullName);
	}

	//筌ｂ뫀占쏙옙�솁占쎌뵬 �뵳�딅뮞占쎈뱜
	@Override
	public List<String> getAttach(int bno) {
		return sqlSession.selectList("lol.getAttach", bno);
	}

	@Override
	public void addAttach(String fullName) {
		sqlSession.insert("lol.addAttach", fullName);
	}

	@Override
	public void updateAttach(String fullName, int bno) {
		Map<String,Object> map=new HashMap<>();
		map.put("fullName", fullName); //筌ｂ뫀占쏙옙�솁占쎌뵬 占쎌뵠�뵳占�
		map.put("bno", bno); //野껊슣�뻻�눧占� 甕곕뜇�깈
		sqlSession.insert("lol.updateAttach", map);
	}

	@Override
	public void create(LolDTO dto) throws Exception {
		sqlSession.insert("lol.insert", dto);
	}

	@Override
	public void update(LolDTO dto) throws Exception {
		sqlSession.update("lol.update", dto);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("lol.delete", bno);
	}

	@Override
	public List<LolDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("lol.listAll",map);
	}
	public List<LolDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("lol.listPath",map);
	}
	public List<LolDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("lol.listTip",map);
	}
	public List<LolDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("lol.listParty",map);
	}


	@Override
	public void increateViewcnt(int bno) throws Exception {
		sqlSession.update("lol.increateViewcnt", bno);
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("lol.countArticle", map);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("lol.countArticle2", map);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("lol.countArticle3", map);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("lol.countArticle4", map);
	}

	@Override
	public LolDTO read(int bno) throws Exception {
		return sqlSession.selectOne("lol.read", bno);
	}
	@Override
	public LolDTO writer(String writer) throws Exception {
		return sqlSession.selectOne("lol.writer", writer);
	}
	@Override
	public LolDTO nick(String nick) throws Exception {
		return sqlSession.selectOne("lol.nick", nick);
	}
}
