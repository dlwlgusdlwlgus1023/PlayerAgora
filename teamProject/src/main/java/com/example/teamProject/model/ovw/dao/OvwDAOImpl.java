package com.example.teamProject.model.ovw.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.ovw.dto.OvwDTO;

@Repository //dao bean
public class OvwDAOImpl implements OvwDAO {
	
	@Inject //�쓽議닿�怨꾩＜�엯(DI)
	SqlSession sqlSession;

	@Override
	public void deleteFile(String fullName) {
		sqlSession.delete("ovw.deleteFile", fullName);
	}

	//泥⑤��뙆�씪 由ъ뒪�듃
	@Override
	public List<String> getAttach(int bno) {
		return sqlSession.selectList("ovw.getAttach", bno);
	}

	@Override
	public void addAttach(String fullName) {
		sqlSession.insert("ovw.addAttach", fullName);
	}

	@Override
	public void updateAttach(String fullName, int bno) {
		Map<String,Object> map=new HashMap<>();
		map.put("fullName", fullName); //泥⑤��뙆�씪 �씠由�
		map.put("bno", bno); //寃뚯떆臾� 踰덊샇
		sqlSession.insert("ovw.updateAttach", map);
	}

	@Override
	public void create(OvwDTO dto) throws Exception {
		sqlSession.insert("ovw.insert", dto);
	}

	@Override
	public void update(OvwDTO dto) throws Exception {
		sqlSession.update("ovw.update", dto);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("ovw.delete", bno);
	}

	@Override
	public List<OvwDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("ovw.listAll",map);
	}
	public List<OvwDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("ovw.listPath",map);
	}
	public List<OvwDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("ovw.listTip",map);
	}
	public List<OvwDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("ovw.listParty",map);
	}


	@Override
	public void increateViewcnt(int bno) throws Exception {
		sqlSession.update("ovw.increateViewcnt", bno);
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("ovw.countArticle", map);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("ovw.countArticle2", map);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("ovw.countArticle3", map);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("ovw.countArticle4", map);
	}

	@Override
	public OvwDTO read(int bno) throws Exception {
		return sqlSession.selectOne("ovw.read", bno);
	}
	@Override
	public OvwDTO writer(String writer) throws Exception {
		return sqlSession.selectOne("ovw.writer", writer);
	}
	@Override
	public OvwDTO nick(String nick) throws Exception {
		return sqlSession.selectOne("ovw.nick", nick);
	}
}
