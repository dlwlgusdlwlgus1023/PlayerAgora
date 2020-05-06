package com.example.teamProject.model.civ.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.civ.dto.CivDTO;

@Repository //dao bean
public class CivDAOImpl implements CivDAO {
	
	@Inject //�쓽議닿�怨꾩＜�엯(DI)
	SqlSession sqlSession;

	@Override
	public void deleteFile(String fullName) {
		sqlSession.delete("civ.deleteFile", fullName);
	}

	//泥⑤��뙆�씪 由ъ뒪�듃
	@Override
	public List<String> getAttach(int bno) {
		return sqlSession.selectList("civ.getAttach", bno);
	}

	@Override
	public void addAttach(String fullName) {
		sqlSession.insert("civ.addAttach", fullName);
	}

	@Override
	public void updateAttach(String fullName, int bno) {
		Map<String,Object> map=new HashMap<>();
		map.put("fullName", fullName); //泥⑤��뙆�씪 �씠由�
		map.put("bno", bno); //寃뚯떆臾� 踰덊샇
		sqlSession.insert("civ.updateAttach", map);
	}

	@Override
	public void create(CivDTO dto) throws Exception {
		sqlSession.insert("civ.insert", dto);
	}

	@Override
	public void update(CivDTO dto) throws Exception {
		sqlSession.update("civ.update", dto);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("civ.delete", bno);
	}

	@Override
	public List<CivDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("civ.listAll",map);
	}
	public List<CivDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("civ.listPath",map);
	}
	public List<CivDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("civ.listTip",map);
	}
	public List<CivDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("civ.listParty",map);
	}


	@Override
	public void increateViewcnt(int bno) throws Exception {
		sqlSession.update("civ.increateViewcnt", bno);
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("civ.countArticle", map);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("civ.countArticle2", map);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("civ.countArticle3", map);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("civ.countArticle4", map);
	}

	@Override
	public CivDTO read(int bno) throws Exception {
		return sqlSession.selectOne("civ.read", bno);
	}
	@Override
	public CivDTO writer(String writer) throws Exception {
		return sqlSession.selectOne("civ.writer", writer);
	}
	@Override
	public CivDTO nick(String nick) throws Exception {
		return sqlSession.selectOne("civ.nick", nick);
	}
}
