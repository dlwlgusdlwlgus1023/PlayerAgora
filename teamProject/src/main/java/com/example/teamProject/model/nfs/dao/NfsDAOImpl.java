package com.example.teamProject.model.nfs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.nfs.dto.NfsDTO;

@Repository //dao bean
public class NfsDAOImpl implements NfsDAO {
	
	@Inject //�쓽議닿�怨꾩＜�엯(DI)
	SqlSession sqlSession;

	@Override
	public void deleteFile(String fullName) {
		sqlSession.delete("nfs.deleteFile", fullName);
	}

	//泥⑤��뙆�씪 由ъ뒪�듃
	@Override
	public List<String> getAttach(int bno) {
		return sqlSession.selectList("nfs.getAttach", bno);
	}

	@Override
	public void addAttach(String fullName) {
		sqlSession.insert("nfs.addAttach", fullName);
	}

	@Override
	public void updateAttach(String fullName, int bno) {
		Map<String,Object> map=new HashMap<>();
		map.put("fullName", fullName); //泥⑤��뙆�씪 �씠由�
		map.put("bno", bno); //寃뚯떆臾� 踰덊샇
		sqlSession.insert("nfs.updateAttach", map);
	}

	@Override
	public void create(NfsDTO dto) throws Exception {
		sqlSession.insert("nfs.insert", dto);
	}

	@Override
	public void update(NfsDTO dto) throws Exception {
		sqlSession.update("nfs.update", dto);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("nfs.delete", bno);
	}

	@Override
	public List<NfsDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("nfs.listAll",map);
	}
	public List<NfsDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("nfs.listPath",map);
	}
	public List<NfsDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("nfs.listTip",map);
	}
	public List<NfsDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("nfs.listParty",map);
	}


	@Override
	public void increateViewcnt(int bno) throws Exception {
		sqlSession.update("nfs.increateViewcnt", bno);
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("nfs.countArticle", map);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("nfs.countArticle2", map);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("nfs.countArticle3", map);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("nfs.countArticle4", map);
	}

	@Override
	public NfsDTO read(int bno) throws Exception {
		return sqlSession.selectOne("nfs.read", bno);
	}
	@Override
	public NfsDTO writer(String writer) throws Exception {
		return sqlSession.selectOne("nfs.writer", writer);
	}
	@Override
	public NfsDTO nick(String nick) throws Exception {
		return sqlSession.selectOne("nfs.nick", nick);
	}
}
