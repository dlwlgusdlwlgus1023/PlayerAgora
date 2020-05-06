package com.example.teamProject.service.lol;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.lol.dao.LolDAO;
import com.example.teamProject.model.lol.dto.LolDTO;


@Service //service bean
public class LolServiceImpl implements LolService {
	
	@Inject
	LolDAO lolDao;

	@Override
	public void deleteFile(String fullName) {
		lolDao.deleteFile(fullName);
	}

	@Override
	public List<String> getAttach(int bno) {
		return lolDao.getAttach(bno);
	}

	@Transactional
	@Override
	public void create(LolDTO dto) throws Exception {
		lolDao.create(dto);
		String[] files=dto.getFiles(); 
		if(files==null) return; 
		for(String name : files) {
			lolDao.addAttach(name);
		}
		
	}

	@Transactional
	@Override
	public void update(LolDTO dto) throws Exception {
		lolDao.update(dto);
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			lolDao.updateAttach(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		lolDao.delete(bno);
	}

	@Override
	public List<LolDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return lolDao.listAll(search_option, keyword, start,end);
	}
	@Override
	public List<LolDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		return lolDao.listPath(search_option, keyword, start,end);
	}
	@Override
	public List<LolDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		return lolDao.listTip(search_option, keyword, start,end);
	}
	@Override
	public List<LolDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		return lolDao.listParty(search_option, keyword, start,end);
	}

	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 5*1000) {
			lolDao.increateViewcnt(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return lolDao.countArticle(search_option, keyword);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		return lolDao.countArticle2(search_option, keyword);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		return lolDao.countArticle3(search_option, keyword);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		return lolDao.countArticle4(search_option, keyword);
	}

	@Override
	public LolDTO read(int bno) throws Exception {
		return lolDao.read(bno);
	}

}
