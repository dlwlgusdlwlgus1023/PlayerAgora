package com.example.teamProject.model.screenshot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.screenshot.dto.ScreenshotDTO;

@Repository //dao bean
public class ScreenshotDAOImpl implements ScreenshotDAO {
	
	@Inject //의존관계주입(DI)
	SqlSession sqlSession;

	@Override
	public void deleteFile(String fullName) {
		sqlSession.delete("screenshot.deleteFile", fullName);
	}

	//첨부파일 리스트
	@Override
	public List<String> getUpload(int bno) {
		return sqlSession.selectList("screenshot.getUpload", bno);
	}
	


	@Override
	public void addUpload(String fullName) {
		Map<String,Object> map=new HashMap<>();
		map.put("fullName", fullName); 
		sqlSession.insert("screenshot.addUpload", map);
	}

	@Override
	public void updateUpload(String fullName, int bno) {
		Map<String,Object> map=new HashMap<>();
		map.put("fullName", fullName); //첨부파일 이름
		map.put("bno", bno); //게시물 번호
		sqlSession.insert("screenshot.updateUpload", map);
		//게시물 screenshot는 update처리하지만 첨부파일 attach는 기존 파일이
		//있다 하더라도 기존것은 그대로 두거나 또는 새파일을 올려 수정하는
		//것이기 때문에 insert() 씀
	}

	@Override
	public void create(ScreenshotDTO dto) throws Exception {
		sqlSession.insert("screenshot.insert", dto);
	}

	@Override
	public void update(ScreenshotDTO dto) throws Exception {
		sqlSession.update("screenshot.update", dto);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("screenshot.delete", bno);
	}
	
	
	
	@Override
	public List<ScreenshotDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listAll",map);
	}
	@Override
	public List<ScreenshotDTO> listMine(String search_option, String keyword, int start, int end, String writer) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("writer", writer);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listMine",map);
	}	
	
	@Override
	public List<ScreenshotDTO> listBtg(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listBtg",map);
	}
	@Override
	public List<ScreenshotDTO> listSud(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listSud",map);
	}
	@Override
	public List<ScreenshotDTO> listOve(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listOve",map);
	}
	@Override
	public List<ScreenshotDTO> listWow(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listWow",map);
	}
	@Override
	public List<ScreenshotDTO> listLoa(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listLoa",map);
	}
	@Override
	public List<ScreenshotDTO> listMps(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listMps",map);
	}
	@Override
	public List<ScreenshotDTO> listLol(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listLol",map);
	}	
	@Override
	public List<ScreenshotDTO> listDot(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listDot",map);
	}	
	@Override
	public List<ScreenshotDTO> listHos(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listHos",map);
	}	
	@Override
	public List<ScreenshotDTO> listSta(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listSta",map);
	}	
	@Override
	public List<ScreenshotDTO> listMic(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listMic",map);
	}		
	@Override
	public List<ScreenshotDTO> listCiv(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listCiv",map);
	}		
	@Override
	public List<ScreenshotDTO> listFif(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listFif",map);
	}		
	@Override
	public List<ScreenshotDTO> listNfs(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listNfs",map);
	}	
	@Override
	public List<ScreenshotDTO> listWin(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);//맵에 자료저장
		map.put("end", end);
		return sqlSession.selectList("screenshot.listWin",map);
	}	
	
	
	
	
	@Override
	public void increateViewcnt(int bno) throws Exception {
		sqlSession.update("screenshot.increateViewcnt", bno);
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticle", map);
	}
	@Override
	public int countArticleMine(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticleMine", map);
	}
	
	@Override
	public int countArticleBtg(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticleBtg", map);
	}
	@Override
	public int countArticleSud(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticleSud", map);
	}
	
	@Override
	public int countArticleOve(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticleOve", map);
	}
	
	@Override
	public int countArticleWow(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticleWow", map);
	}
	@Override
	public int countArticleLoa(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticleLoa", map);
	}
	@Override
	public int countArticleMps(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticleMps", map);
	}
	@Override
	public int countArticleLol(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticleLol", map);
	}
	@Override
	public int countArticleDot(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticleDot", map);
	}
	@Override
	public int countArticleHos(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticleHos", map);
	}	
	@Override
	public int countArticleSta(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticleSta", map);
	}	
	@Override
	public int countArticleMic(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticleMic", map);
	}	
	@Override
	public int countArticleCiv(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticleCiv", map);
	}	
	@Override
	public int countArticleFif(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticleFif", map);
	}	
	
	@Override
	public int countArticleNfs(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticleNfs", map);
	}		
	@Override
	public int countArticleWin(String search_option, String keyword) throws Exception {
		Map<String,String> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		return sqlSession.selectOne("screenshot.countArticleWin", map);
	}	
	
	
	
	
	@Override
	public ScreenshotDTO read(int bno) throws Exception {
		return sqlSession.selectOne("screenshot.read", bno);
	}
	
	
	
	
	
	


}
