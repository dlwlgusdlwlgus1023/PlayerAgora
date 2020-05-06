package com.example.teamProject.model.dot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.dot.dto.DotDTO;

@Repository //dao bean
public class DotDAOImpl implements DotDAO {
	
	@Inject //占쎌벥鈺곕떯占썸�④쑴竊쒙옙�뿯(DI)
	SqlSession sqlSession;

	@Override
	public void deleteFile(String fullName) {
		sqlSession.delete("dot.deleteFile", fullName);
	}

	//筌ｂ뫀占쏙옙�솁占쎌뵬 �뵳�딅뮞占쎈뱜
	@Override
	public List<String> getAttach(int bno) {
		return sqlSession.selectList("dot.getAttach", bno);
	}

	@Override
	public void addAttach(String fullName) {
		sqlSession.insert("dot.addAttach", fullName);
	}

	@Override
	public void updateAttach(String fullName, int bno) {
		Map<String,Object> map=new HashMap<>();
		map.put("fullName", fullName); //筌ｂ뫀占쏙옙�솁占쎌뵬 占쎌뵠�뵳占�
		map.put("bno", bno); //野껊슣�뻻�눧占� 甕곕뜇�깈
		sqlSession.insert("dot.updateAttach", map);
	}

	@Override
	public void create(DotDTO dto) throws Exception {
		sqlSession.insert("dot.insert", dto);
	}

	@Override
	public void update(DotDTO dto) throws Exception {
		sqlSession.update("dot.update", dto);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("dot.delete", bno);
	}

	@Override
	public List<DotDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("dot.listAll",map);
	}
	public List<DotDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("dot.listPath",map);
	}
	public List<DotDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("dot.listTip",map);
	}
	public List<DotDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("dot.listParty",map);
	}


	@Override
	public void increateViewcnt(int bno) throws Exception {
		sqlSession.update("dot.increateViewcnt", bno);
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("dot.countArticle", map);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("dot.countArticle2", map);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("dot.countArticle3", map);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("dot.countArticle4", map);
	}

	@Override
	public DotDTO read(int bno) throws Exception {
		return sqlSession.selectOne("dot.read", bno);
	}
	@Override
	public DotDTO writer(String writer) throws Exception {
		return sqlSession.selectOne("dot.writer", writer);
	}
	@Override
	public DotDTO nick(String nick) throws Exception {
		return sqlSession.selectOne("dot.nick", nick);
	}
}
