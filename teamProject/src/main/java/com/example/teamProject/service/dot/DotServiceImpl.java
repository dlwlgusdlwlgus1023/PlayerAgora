package com.example.teamProject.service.dot;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.dot.dao.DotDAO;
import com.example.teamProject.model.dot.dto.DotDTO;


@Service //service bean
public class DotServiceImpl implements DotService {
	
	@Inject
	DotDAO dotDao;

	@Override
	public void deleteFile(String fullName) {
		dotDao.deleteFile(fullName);
	}

	@Override
	public List<String> getAttach(int bno) {
		return dotDao.getAttach(bno);
	}

	@Transactional
	@Override
	public void create(DotDTO dto) throws Exception {
		dotDao.create(dto);
		String[] files=dto.getFiles(); 
		if(files==null) return; 
		for(String name : files) {
			dotDao.addAttach(name);
		}
		
	}

	@Transactional
	@Override
	public void update(DotDTO dto) throws Exception {
		dotDao.update(dto);
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			dotDao.updateAttach(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		dotDao.delete(bno);
	}

	@Override
	public List<DotDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return dotDao.listAll(search_option, keyword, start,end);
	}
	@Override
	public List<DotDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		return dotDao.listPath(search_option, keyword, start,end);
	}
	@Override
	public List<DotDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		return dotDao.listTip(search_option, keyword, start,end);
	}
	@Override
	public List<DotDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		return dotDao.listParty(search_option, keyword, start,end);
	}

	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 5*1000) {
			dotDao.increateViewcnt(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return dotDao.countArticle(search_option, keyword);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		return dotDao.countArticle2(search_option, keyword);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		return dotDao.countArticle3(search_option, keyword);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		return dotDao.countArticle4(search_option, keyword);
	}

	@Override
	public DotDTO read(int bno) throws Exception {
		return dotDao.read(bno);
	}

}
