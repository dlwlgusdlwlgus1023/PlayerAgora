package com.example.teamProject.service.screenshot;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.screenshot.dao.ScreenshotDAO;
import com.example.teamProject.model.screenshot.dto.ScreenshotDTO;


@Service //service bean
public class ScreenshotServiceImpl implements ScreenshotService {
	
	@Inject
	ScreenshotDAO screenshotDao;

	@Override
	public void deleteFile(String fullName) {
		screenshotDao.deleteFile(fullName);
	}

	@Override
	public List<String> getUpload(int bno) {
		return screenshotDao.getUpload(bno);
	}

	//1.글쓰기 - 게시물 번호 생성
	//2.첨부파일 등록 - 해당 게시물 번호 사용
	//위 두개가 동시에 처리 (두개가 하나의 트랜잭션 단위가 됨)
	@Transactional
	@Override
	public void create(ScreenshotDTO dto) throws Exception {
		screenshotDao.create(dto);//board테이블에 레코드 추가
		//attach 테이블에 레코드 추가
		String[] files=dto.getFiles(); //첨부파일 이름 배열
		for(String name : files) {
			screenshotDao.addUpload(name);//attach 테이블에 insert
		}
		
	}

	@Transactional //트랜잭션 처리
	@Override
	public void update(ScreenshotDTO dto) throws Exception {
		screenshotDao.update(dto);
		//별도로 만들었던 파일처리 attach 테이블도 함께 수정해야함.
		//screenshot와 attach 테이블을 동시에 처리(transaction)해야 함.
		//service는 transaction 처리하기에 조금 더 유리하다.
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			System.out.println("첨부파일 이름:"+name);
			screenshotDao.updateUpload(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		//reply 레코드 삭제
		//attach 레코드 삭제
		//screenshot 레코드 삭제
		screenshotDao.delete(bno);
	}

	@Override
	public List<ScreenshotDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return screenshotDao.listAll(search_option, keyword, start,end);
	}
	@Override
	public List<ScreenshotDTO> listMine(String search_option, String keyword, int start, int end, String writer) throws Exception {
		return screenshotDao.listMine(search_option, keyword, start,end,writer);
	}	
	@Override
	public List<ScreenshotDTO> listBtg(String search_option, String keyword, int start, int end) throws Exception {
		return screenshotDao.listBtg(search_option, keyword, start,end);
	}
	@Override
	public List<ScreenshotDTO> listSud(String search_option, String keyword, int start, int end) throws Exception {
		return screenshotDao.listSud(search_option, keyword, start,end);
	}
	@Override
	public List<ScreenshotDTO> listOve(String search_option, String keyword, int start, int end) throws Exception {
		return screenshotDao.listOve(search_option, keyword, start,end);
	}
	@Override
	public List<ScreenshotDTO> listWow(String search_option, String keyword, int start, int end) throws Exception {
		return screenshotDao.listWow(search_option, keyword, start,end);
	}	
	@Override
	public List<ScreenshotDTO> listLoa(String search_option, String keyword, int start, int end) throws Exception {
		return screenshotDao.listLoa(search_option, keyword, start,end);
	}
	@Override
	public List<ScreenshotDTO> listMps(String search_option, String keyword, int start, int end) throws Exception {
		return screenshotDao.listMps(search_option, keyword, start,end);
	}
	@Override
	public List<ScreenshotDTO> listLol(String search_option, String keyword, int start, int end) throws Exception {
		return screenshotDao.listLol(search_option, keyword, start,end);
	}
	@Override
	public List<ScreenshotDTO> listDot(String search_option, String keyword, int start, int end) throws Exception {
		return screenshotDao.listDot(search_option, keyword, start,end);
	}
	@Override
	public List<ScreenshotDTO> listHos(String search_option, String keyword, int start, int end) throws Exception {
		return screenshotDao.listHos(search_option, keyword, start,end);
	}
	@Override
	public List<ScreenshotDTO> listSta(String search_option, String keyword, int start, int end) throws Exception {
		return screenshotDao.listSta(search_option, keyword, start,end);
	}
	@Override
	public List<ScreenshotDTO> listMic(String search_option, String keyword, int start, int end) throws Exception {
		return screenshotDao.listMic(search_option, keyword, start,end);
	}
	@Override
	public List<ScreenshotDTO> listCiv(String search_option, String keyword, int start, int end) throws Exception {
		return screenshotDao.listCiv(search_option, keyword, start,end);
	}
	@Override
	public List<ScreenshotDTO> listFif(String search_option, String keyword, int start, int end) throws Exception {
		return screenshotDao.listFif(search_option, keyword, start,end);
	}	
	@Override
	public List<ScreenshotDTO> listNfs(String search_option, String keyword, int start, int end) throws Exception {
		return screenshotDao.listNfs(search_option, keyword, start,end);
	}	
	@Override
	public List<ScreenshotDTO> listWin(String search_option, String keyword, int start, int end) throws Exception {
		return screenshotDao.listWin(search_option, keyword, start,end);
	}	

	//조회수 증가 처리
	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno) != null) {
			//최근에 조회수를 올린 시간
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		
		//일정 시간(5초)이 경과후 조회수 증가 처리
		if(current_time - update_time > 24*60*60*1000) {//24*60*60*1000(하루)
			//조회수 증가 처리
			screenshotDao.increateViewcnt(bno);
			//조회수를 올린 시간 저장
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticle(search_option, keyword);
	}
	@Override
	public int countArticleMine(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticleMine(search_option, keyword);
	}	
	
	@Override
	public int countArticleBtg(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticleBtg(search_option, keyword);
	}
	
	@Override
	public int countArticleSud(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticleSud(search_option, keyword);
	}
	@Override
	public int countArticleOve(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticleOve(search_option, keyword);
	}
	@Override
	public int countArticleWow(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticleWow(search_option, keyword);
	}
	@Override
	public int countArticleLoa(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticleLoa(search_option, keyword);
	}	
	@Override
	public int countArticleMps(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticleMps(search_option, keyword);
	}	
	@Override
	public int countArticleLol(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticleLol(search_option, keyword);
	}		
	@Override
	public int countArticleDot(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticleDot(search_option, keyword);
	}		
	@Override
	public int countArticleHos(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticleHos(search_option, keyword);
	}		
	@Override
	public int countArticleSta(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticleSta(search_option, keyword);
	}		
	@Override
	public int countArticleMic(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticleMic(search_option, keyword);
	}		
	@Override
	public int countArticleCiv(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticleCiv(search_option, keyword);
	}		
	@Override
	public int countArticleFif(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticleFif(search_option, keyword);
	}	

	@Override
	public int countArticleNfs(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticleNfs(search_option, keyword);
	}	
	@Override
	public int countArticleWin(String search_option, String keyword) throws Exception {
		return screenshotDao.countArticleWin(search_option, keyword);
	}	
	
	
	
	
	
	
	
	
	@Override
	public ScreenshotDTO read(int bno) throws Exception {
		return screenshotDao.read(bno);
	}
	



}
