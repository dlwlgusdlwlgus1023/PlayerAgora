package com.example.teamProject.model.sta.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.sta.dto.StaDTO;

@Repository //dao bean
public class StaDAOImpl implements StaDAO {
	
	@Inject //占쎌벥鈺곕떯占썸�④쑴竊쒙옙�뿯(DI)
	SqlSession sqlSession;

	@Override
	public void deleteFile(String fullName) {
		sqlSession.delete("sta.deleteFile", fullName);
	}

	//筌ｂ뫀占쏙옙�솁占쎌뵬 �뵳�딅뮞占쎈뱜
	@Override
	public List<String> getAttach(int bno) {
		return sqlSession.selectList("sta.getAttach", bno);
	}

	@Override
	public void addAttach(String fullName) {
		sqlSession.insert("sta.addAttach", fullName);
	}

	@Override
	public void updateAttach(String fullName, int bno) {
		Map<String,Object> map=new HashMap<>();
		map.put("fullName", fullName); //筌ｂ뫀占쏙옙�솁占쎌뵬 占쎌뵠�뵳占�
		map.put("bno", bno); //野껊슣�뻻�눧占� 甕곕뜇�깈
		sqlSession.insert("sta.updateAttach", map);
	}

	@Override
	public void create(StaDTO dto) throws Exception {
		sqlSession.insert("sta.insert", dto);
	}

	@Override
	public void update(StaDTO dto) throws Exception {
		sqlSession.update("sta.update", dto);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("sta.delete", bno);
	}

	@Override
	public List<StaDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("sta.listAll",map);
	}
	public List<StaDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("sta.listPath",map);
	}
	public List<StaDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("sta.listTip",map);
	}
	public List<StaDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("sta.listParty",map);
	}


	@Override
	public void increateViewcnt(int bno) throws Exception {
		sqlSession.update("sta.increateViewcnt", bno);
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("sta.countArticle", map);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("sta.countArticle2", map);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("sta.countArticle3", map);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("sta.countArticle4", map);
	}

	@Override
	public StaDTO read(int bno) throws Exception {
		return sqlSession.selectOne("sta.read", bno);
	}
	@Override
	public StaDTO writer(String writer) throws Exception {
		return sqlSession.selectOne("sta.writer", writer);
	}
	@Override
	public StaDTO nick(String nick) throws Exception {
		return sqlSession.selectOne("sta.nick", nick);
	}
}
