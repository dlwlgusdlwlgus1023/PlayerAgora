package com.example.teamProject.service.civ;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.civ.dao.CivDAO;
import com.example.teamProject.model.civ.dto.CivDTO;


@Service //service bean
public class CivServiceImpl implements CivService {
	
	@Inject
	CivDAO civDao;

	@Override
	public void deleteFile(String fullName) {
		civDao.deleteFile(fullName);
	}

	@Override
	public List<String> getAttach(int bno) {
		return civDao.getAttach(bno);
	}

	@Transactional
	@Override
	public void create(CivDTO dto) throws Exception {
		civDao.create(dto);
		String[] files=dto.getFiles(); 
		if(files==null) return; 
		for(String name : files) {
			civDao.addAttach(name);
		}
		
	}

	@Transactional
	@Override
	public void update(CivDTO dto) throws Exception {
		civDao.update(dto);
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			civDao.updateAttach(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		civDao.delete(bno);
	}

	@Override
	public List<CivDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return civDao.listAll(search_option, keyword, start,end);
	}
	@Override
	public List<CivDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		return civDao.listPath(search_option, keyword, start,end);
	}
	@Override
	public List<CivDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		return civDao.listTip(search_option, keyword, start,end);
	}
	@Override
	public List<CivDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		return civDao.listParty(search_option, keyword, start,end);
	}

	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 5*1000) {
			civDao.increateViewcnt(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return civDao.countArticle(search_option, keyword);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		return civDao.countArticle2(search_option, keyword);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		return civDao.countArticle3(search_option, keyword);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		return civDao.countArticle4(search_option, keyword);
	}

	@Override
	public CivDTO read(int bno) throws Exception {
		return civDao.read(bno);
	}

}
