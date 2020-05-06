package com.example.teamProject.service.hos;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.hos.dao.HosDAO;
import com.example.teamProject.model.hos.dto.HosDTO;


@Service //service bean
public class HosServiceImpl implements HosService {
	
	@Inject
	HosDAO hosDao;

	@Override
	public void deleteFile(String fullName) {
		hosDao.deleteFile(fullName);
	}

	@Override
	public List<String> getAttach(int bno) {
		return hosDao.getAttach(bno);
	}

	@Transactional
	@Override
	public void create(HosDTO dto) throws Exception {
		hosDao.create(dto);
		String[] files=dto.getFiles(); 
		if(files==null) return; 
		for(String name : files) {
			hosDao.addAttach(name);
		}
		
	}

	@Transactional
	@Override
	public void update(HosDTO dto) throws Exception {
		hosDao.update(dto);
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			hosDao.updateAttach(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		hosDao.delete(bno);
	}

	@Override
	public List<HosDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return hosDao.listAll(search_option, keyword, start,end);
	}
	@Override
	public List<HosDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		return hosDao.listPath(search_option, keyword, start,end);
	}
	@Override
	public List<HosDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		return hosDao.listTip(search_option, keyword, start,end);
	}
	@Override
	public List<HosDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		return hosDao.listParty(search_option, keyword, start,end);
	}

	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 5*1000) {
			hosDao.increateViewcnt(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return hosDao.countArticle(search_option, keyword);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		return hosDao.countArticle2(search_option, keyword);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		return hosDao.countArticle3(search_option, keyword);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		return hosDao.countArticle4(search_option, keyword);
	}

	@Override
	public HosDTO read(int bno) throws Exception {
		return hosDao.read(bno);
	}

}
