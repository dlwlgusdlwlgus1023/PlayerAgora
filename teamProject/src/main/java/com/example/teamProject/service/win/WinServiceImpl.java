package com.example.teamProject.service.win;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.win.dao.WinDAO;
import com.example.teamProject.model.win.dto.WinDTO;


@Service //service bean
public class WinServiceImpl implements WinService {
	
	@Inject
	WinDAO winDao;

	@Override
	public void deleteFile(String fullName) {
		winDao.deleteFile(fullName);
	}

	@Override
	public List<String> getAttach(int bno) {
		return winDao.getAttach(bno);
	}

	@Transactional
	@Override
	public void create(WinDTO dto) throws Exception {
		winDao.create(dto);
		String[] files=dto.getFiles(); 
		if(files==null) return; 
		for(String name : files) {
			winDao.addAttach(name);
		}
		
	}

	@Transactional
	@Override
	public void update(WinDTO dto) throws Exception {
		winDao.update(dto);
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			winDao.updateAttach(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		winDao.delete(bno);
	}

	@Override
	public List<WinDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return winDao.listAll(search_option, keyword, start,end);
	}
	@Override
	public List<WinDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		return winDao.listPath(search_option, keyword, start,end);
	}
	@Override
	public List<WinDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		return winDao.listTip(search_option, keyword, start,end);
	}
	@Override
	public List<WinDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		return winDao.listParty(search_option, keyword, start,end);
	}

	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 5*1000) {
			winDao.increateViewcnt(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return winDao.countArticle(search_option, keyword);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		return winDao.countArticle2(search_option, keyword);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		return winDao.countArticle3(search_option, keyword);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		return winDao.countArticle4(search_option, keyword);
	}

	@Override
	public WinDTO read(int bno) throws Exception {
		return winDao.read(bno);
	}

}
