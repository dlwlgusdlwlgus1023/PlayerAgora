package com.example.teamProject.model.mic.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.mic.dto.MicDTO;

@Repository //dao bean
public class MicDAOImpl implements MicDAO {
	
	@Inject //�쓽議닿�怨꾩＜�엯(DI)
	SqlSession sqlSession;

	@Override
	public void deleteFile(String fullName) {
		sqlSession.delete("mic.deleteFile", fullName);
	}

	//泥⑤��뙆�씪 由ъ뒪�듃
	@Override
	public List<String> getAttach(int bno) {
		return sqlSession.selectList("mic.getAttach", bno);
	}

	@Override
	public void addAttach(String fullName) {
		sqlSession.insert("mic.addAttach", fullName);
	}

	@Override
	public void updateAttach(String fullName, int bno) {
		Map<String,Object> map=new HashMap<>();
		map.put("fullName", fullName); //泥⑤��뙆�씪 �씠由�
		map.put("bno", bno); //寃뚯떆臾� 踰덊샇
		sqlSession.insert("mic.updateAttach", map);
	}

	@Override
	public void create(MicDTO dto) throws Exception {
		sqlSession.insert("mic.insert", dto);
	}

	@Override
	public void update(MicDTO dto) throws Exception {
		sqlSession.update("mic.update", dto);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("mic.delete", bno);
	}

	@Override
	public List<MicDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("mic.listAll",map);
	}
	public List<MicDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("mic.listPath",map);
	}
	public List<MicDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("mic.listTip",map);
	}
	public List<MicDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("mic.listParty",map);
	}


	@Override
	public void increateViewcnt(int bno) throws Exception {
		sqlSession.update("mic.increateViewcnt", bno);
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("mic.countArticle", map);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("mic.countArticle2", map);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("mic.countArticle3", map);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("mic.countArticle4", map);
	}

	@Override
	public MicDTO read(int bno) throws Exception {
		return sqlSession.selectOne("mic.read", bno);
	}
	@Override
	public MicDTO writer(String writer) throws Exception {
		return sqlSession.selectOne("mic.writer", writer);
	}
	@Override
	public MicDTO nick(String nick) throws Exception {
		return sqlSession.selectOne("mic.nick", nick);
	}
}
