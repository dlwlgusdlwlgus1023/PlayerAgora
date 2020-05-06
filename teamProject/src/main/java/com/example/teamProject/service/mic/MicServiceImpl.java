package com.example.teamProject.service.mic;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.mic.dao.MicDAO;
import com.example.teamProject.model.mic.dto.MicDTO;


@Service //service bean
public class MicServiceImpl implements MicService {
	
	@Inject
	MicDAO micDao;

	@Override
	public void deleteFile(String fullName) {
		micDao.deleteFile(fullName);
	}

	@Override
	public List<String> getAttach(int bno) {
		return micDao.getAttach(bno);
	}

	@Transactional
	@Override
	public void create(MicDTO dto) throws Exception {
		micDao.create(dto);
		String[] files=dto.getFiles(); 
		if(files==null) return; 
		for(String name : files) {
			micDao.addAttach(name);
		}
		
	}

	@Transactional
	@Override
	public void update(MicDTO dto) throws Exception {
		micDao.update(dto);
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			micDao.updateAttach(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		micDao.delete(bno);
	}

	@Override
	public List<MicDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return micDao.listAll(search_option, keyword, start,end);
	}
	@Override
	public List<MicDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		return micDao.listPath(search_option, keyword, start,end);
	}
	@Override
	public List<MicDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		return micDao.listTip(search_option, keyword, start,end);
	}
	@Override
	public List<MicDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		return micDao.listParty(search_option, keyword, start,end);
	}

	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 5*1000) {
			micDao.increateViewcnt(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return micDao.countArticle(search_option, keyword);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		return micDao.countArticle2(search_option, keyword);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		return micDao.countArticle3(search_option, keyword);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		return micDao.countArticle4(search_option, keyword);
	}

	@Override
	public MicDTO read(int bno) throws Exception {
		return micDao.read(bno);
	}

}
