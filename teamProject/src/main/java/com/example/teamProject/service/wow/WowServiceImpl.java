package com.example.teamProject.service.wow;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.wow.dao.WowDAO;
import com.example.teamProject.model.wow.dto.WowDTO;


@Service //service bean
public class WowServiceImpl implements WowService {
	
	@Inject
	WowDAO wowDao;

	@Override
	public void deleteFile(String fullName) {
		wowDao.deleteFile(fullName);
	}

	@Override
	public List<String> getAttach(int bno) {
		return wowDao.getAttach(bno);
	}

	@Transactional
	@Override
	public void create(WowDTO dto) throws Exception {
		wowDao.create(dto);
		String[] files=dto.getFiles(); 
		if(files==null) return; 
		for(String name : files) {
			wowDao.addAttach(name);
		}
		
	}

	@Transactional
	@Override
	public void update(WowDTO dto) throws Exception {
		wowDao.update(dto);
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			wowDao.updateAttach(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		wowDao.delete(bno);
	}

	@Override
	public List<WowDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return wowDao.listAll(search_option, keyword, start,end);
	}
	@Override
	public List<WowDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		return wowDao.listPath(search_option, keyword, start,end);
	}
	@Override
	public List<WowDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		return wowDao.listTip(search_option, keyword, start,end);
	}
	@Override
	public List<WowDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		return wowDao.listParty(search_option, keyword, start,end);
	}

	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 5*1000) {
			wowDao.increateViewcnt(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return wowDao.countArticle(search_option, keyword);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		return wowDao.countArticle2(search_option, keyword);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		return wowDao.countArticle3(search_option, keyword);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		return wowDao.countArticle4(search_option, keyword);
	}

	@Override
	public WowDTO read(int bno) throws Exception {
		return wowDao.read(bno);
	}

}
