package com.example.teamProject.service.loa;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.loa.dao.LoaDAO;
import com.example.teamProject.model.loa.dto.LoaDTO;


@Service //service bean
public class LoaServiceImpl implements LoaService {
	
	@Inject
	LoaDAO loaDao;

	@Override
	public void deleteFile(String fullName) {
		loaDao.deleteFile(fullName);
	}

	@Override
	public List<String> getAttach(int bno) {
		return loaDao.getAttach(bno);
	}

	@Transactional
	@Override
	public void create(LoaDTO dto) throws Exception {
		loaDao.create(dto);
		String[] files=dto.getFiles(); 
		if(files==null) return; 
		for(String name : files) {
			loaDao.addAttach(name);
		}
		
	}

	@Transactional
	@Override
	public void update(LoaDTO dto) throws Exception {
		loaDao.update(dto);
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			loaDao.updateAttach(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		loaDao.delete(bno);
	}

	@Override
	public List<LoaDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return loaDao.listAll(search_option, keyword, start,end);
	}
	@Override
	public List<LoaDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		return loaDao.listPath(search_option, keyword, start,end);
	}
	@Override
	public List<LoaDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		return loaDao.listTip(search_option, keyword, start,end);
	}
	@Override
	public List<LoaDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		return loaDao.listParty(search_option, keyword, start,end);
	}

	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 5*1000) {
			loaDao.increateViewcnt(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return loaDao.countArticle(search_option, keyword);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		return loaDao.countArticle2(search_option, keyword);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		return loaDao.countArticle3(search_option, keyword);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		return loaDao.countArticle4(search_option, keyword);
	}

	@Override
	public LoaDTO read(int bno) throws Exception {
		return loaDao.read(bno);
	}

}
