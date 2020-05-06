package com.example.teamProject.service.sud;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.sud.dao.SudDAO;
import com.example.teamProject.model.sud.dto.SudDTO;


@Service //service bean
public class SudServiceImpl implements SudService {
	
	@Inject
	SudDAO sudDao;

	@Override
	public void deleteFile(String fullName) {
		sudDao.deleteFile(fullName);
	}

	@Override
	public List<String> getAttach(int bno) {
		return sudDao.getAttach(bno);
	}

	@Transactional
	@Override
	public void create(SudDTO dto) throws Exception {
		sudDao.create(dto);
		String[] files=dto.getFiles(); 
		if(files==null) return; 
		for(String name : files) {
			sudDao.addAttach(name);
		}
		
	}

	@Transactional
	@Override
	public void update(SudDTO dto) throws Exception {
		sudDao.update(dto);
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			sudDao.updateAttach(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		sudDao.delete(bno);
	}

	@Override
	public List<SudDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return sudDao.listAll(search_option, keyword, start,end);
	}
	@Override
	public List<SudDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		return sudDao.listPath(search_option, keyword, start,end);
	}
	@Override
	public List<SudDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		return sudDao.listTip(search_option, keyword, start,end);
	}
	@Override
	public List<SudDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		return sudDao.listParty(search_option, keyword, start,end);
	}

	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 5*1000) {
			sudDao.increateViewcnt(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return sudDao.countArticle(search_option, keyword);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		return sudDao.countArticle2(search_option, keyword);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		return sudDao.countArticle3(search_option, keyword);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		return sudDao.countArticle4(search_option, keyword);
	}

	@Override
	public SudDTO read(int bno) throws Exception {
		return sudDao.read(bno);
	}

}
