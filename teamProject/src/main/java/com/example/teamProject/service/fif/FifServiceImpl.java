package com.example.teamProject.service.fif;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.fif.dao.FifDAO;
import com.example.teamProject.model.fif.dto.FifDTO;


@Service //service bean
public class FifServiceImpl implements FifService {
	
	@Inject
	FifDAO fifDao;

	@Override
	public void deleteFile(String fullName) {
		fifDao.deleteFile(fullName);
	}

	@Override
	public List<String> getAttach(int bno) {
		return fifDao.getAttach(bno);
	}

	@Transactional
	@Override
	public void create(FifDTO dto) throws Exception {
		fifDao.create(dto);
		String[] files=dto.getFiles(); 
		if(files==null) return; 
		for(String name : files) {
			fifDao.addAttach(name);
		}
		
	}

	@Transactional
	@Override
	public void update(FifDTO dto) throws Exception {
		fifDao.update(dto);
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			fifDao.updateAttach(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		fifDao.delete(bno);
	}

	@Override
	public List<FifDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return fifDao.listAll(search_option, keyword, start,end);
	}
	@Override
	public List<FifDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		return fifDao.listPath(search_option, keyword, start,end);
	}
	@Override
	public List<FifDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		return fifDao.listTip(search_option, keyword, start,end);
	}
	@Override
	public List<FifDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		return fifDao.listParty(search_option, keyword, start,end);
	}

	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 5*1000) {
			fifDao.increateViewcnt(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return fifDao.countArticle(search_option, keyword);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		return fifDao.countArticle2(search_option, keyword);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		return fifDao.countArticle3(search_option, keyword);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		return fifDao.countArticle4(search_option, keyword);
	}

	@Override
	public FifDTO read(int bno) throws Exception {
		return fifDao.read(bno);
	}

}
