package com.example.teamProject.model.mps.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.mps.dto.MpsDTO;

@Repository //dao bean
public class MpsDAOImpl implements MpsDAO {
	
	@Inject //占쎌벥鈺곕떯占썸�④쑴竊쒙옙�뿯(DI)
	SqlSession sqlSession;

	@Override
	public void deleteFile(String fullName) {
		sqlSession.delete("mps.deleteFile", fullName);
	}

	//筌ｂ뫀占쏙옙�솁占쎌뵬 �뵳�딅뮞占쎈뱜
	@Override
	public List<String> getAttach(int bno) {
		return sqlSession.selectList("mps.getAttach", bno);
	}

	@Override
	public void addAttach(String fullName) {
		sqlSession.insert("mps.addAttach", fullName);
	}

	@Override
	public void updateAttach(String fullName, int bno) {
		Map<String,Object> map=new HashMap<>();
		map.put("fullName", fullName); //筌ｂ뫀占쏙옙�솁占쎌뵬 占쎌뵠�뵳占�
		map.put("bno", bno); //野껊슣�뻻�눧占� 甕곕뜇�깈
		sqlSession.insert("mps.updateAttach", map);
	}

	@Override
	public void create(MpsDTO dto) throws Exception {
		sqlSession.insert("mps.insert", dto);
	}

	@Override
	public void update(MpsDTO dto) throws Exception {
		sqlSession.update("mps.update", dto);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("mps.delete", bno);
	}

	@Override
	public List<MpsDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("mps.listAll",map);
	}
	public List<MpsDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("mps.listPath",map);
	}
	public List<MpsDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("mps.listTip",map);
	}
	public List<MpsDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("mps.listParty",map);
	}


	@Override
	public void increateViewcnt(int bno) throws Exception {
		sqlSession.update("mps.increateViewcnt", bno);
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("mps.countArticle", map);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("mps.countArticle2", map);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("mps.countArticle3", map);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("mps.countArticle4", map);
	}

	@Override
	public MpsDTO read(int bno) throws Exception {
		return sqlSession.selectOne("mps.read", bno);
	}
	@Override
	public MpsDTO writer(String writer) throws Exception {
		return sqlSession.selectOne("mps.writer", writer);
	}
	@Override
	public MpsDTO nick(String nick) throws Exception {
		return sqlSession.selectOne("mps.nick", nick);
	}
}
