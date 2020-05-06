package com.example.teamProject.model.fif.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.fif.dto.FifDTO;

@Repository //dao bean
public class FifDAOImpl implements FifDAO {
	
	@Inject //�쓽議닿�怨꾩＜�엯(DI)
	SqlSession sqlSession;

	@Override
	public void deleteFile(String fullName) {
		sqlSession.delete("fif.deleteFile", fullName);
	}

	//泥⑤��뙆�씪 由ъ뒪�듃
	@Override
	public List<String> getAttach(int bno) {
		return sqlSession.selectList("fif.getAttach", bno);
	}

	@Override
	public void addAttach(String fullName) {
		sqlSession.insert("fif.addAttach", fullName);
	}

	@Override
	public void updateAttach(String fullName, int bno) {
		Map<String,Object> map=new HashMap<>();
		map.put("fullName", fullName); //泥⑤��뙆�씪 �씠由�
		map.put("bno", bno); //寃뚯떆臾� 踰덊샇
		sqlSession.insert("fif.updateAttach", map);
	}

	@Override
	public void create(FifDTO dto) throws Exception {
		sqlSession.insert("fif.insert", dto);
	}

	@Override
	public void update(FifDTO dto) throws Exception {
		sqlSession.update("fif.update", dto);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("fif.delete", bno);
	}

	@Override
	public List<FifDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("fif.listAll",map);
	}
	public List<FifDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("fif.listPath",map);
	}
	public List<FifDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("fif.listTip",map);
	}
	public List<FifDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("fif.listParty",map);
	}


	@Override
	public void increateViewcnt(int bno) throws Exception {
		sqlSession.update("fif.increateViewcnt", bno);
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("fif.countArticle", map);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("fif.countArticle2", map);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("fif.countArticle3", map);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("fif.countArticle4", map);
	}

	@Override
	public FifDTO read(int bno) throws Exception {
		return sqlSession.selectOne("fif.read", bno);
	}
	@Override
	public FifDTO writer(String writer) throws Exception {
		return sqlSession.selectOne("fif.writer", writer);
	}
	@Override
	public FifDTO nick(String nick) throws Exception {
		return sqlSession.selectOne("fif.nick", nick);
	}
}
