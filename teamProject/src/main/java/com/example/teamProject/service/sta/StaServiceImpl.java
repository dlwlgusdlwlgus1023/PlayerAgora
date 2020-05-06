package com.example.teamProject.service.sta;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.sta.dao.StaDAO;
import com.example.teamProject.model.sta.dto.StaDTO;


@Service //service bean
public class StaServiceImpl implements StaService {
	
	@Inject
	StaDAO staDao;

	@Override
	public void deleteFile(String fullName) {
		staDao.deleteFile(fullName);
	}

	@Override
	public List<String> getAttach(int bno) {
		return staDao.getAttach(bno);
	}

	@Transactional
	@Override
	public void create(StaDTO dto) throws Exception {
		staDao.create(dto);
		String[] files=dto.getFiles(); 
		if(files==null) return; 
		for(String name : files) {
			staDao.addAttach(name);
		}
		
	}

	@Transactional
	@Override
	public void update(StaDTO dto) throws Exception {
		staDao.update(dto);
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			staDao.updateAttach(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		staDao.delete(bno);
	}

	@Override
	public List<StaDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return staDao.listAll(search_option, keyword, start,end);
	}
	@Override
	public List<StaDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		return staDao.listPath(search_option, keyword, start,end);
	}
	@Override
	public List<StaDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		return staDao.listTip(search_option, keyword, start,end);
	}
	@Override
	public List<StaDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		return staDao.listParty(search_option, keyword, start,end);
	}

	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 5*1000) {
			staDao.increateViewcnt(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return staDao.countArticle(search_option, keyword);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		return staDao.countArticle2(search_option, keyword);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		return staDao.countArticle3(search_option, keyword);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		return staDao.countArticle4(search_option, keyword);
	}

	@Override
	public StaDTO read(int bno) throws Exception {
		return staDao.read(bno);
	}

}
