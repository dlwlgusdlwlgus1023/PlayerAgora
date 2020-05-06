package com.example.teamProject.service.ovw;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.ovw.dao.OvwDAO;
import com.example.teamProject.model.ovw.dto.OvwDTO;


@Service //service bean
public class OvwServiceImpl implements OvwService {
	
	@Inject
	OvwDAO ovwDao;

	@Override
	public void deleteFile(String fullName) {
		ovwDao.deleteFile(fullName);
	}

	@Override
	public List<String> getAttach(int bno) {
		return ovwDao.getAttach(bno);
	}

	@Transactional
	@Override
	public void create(OvwDTO dto) throws Exception {
		ovwDao.create(dto);
		String[] files=dto.getFiles(); 
		if(files==null) return; 
		for(String name : files) {
			ovwDao.addAttach(name);
		}
		
	}

	@Transactional
	@Override
	public void update(OvwDTO dto) throws Exception {
		ovwDao.update(dto);
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			ovwDao.updateAttach(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		ovwDao.delete(bno);
	}

	@Override
	public List<OvwDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return ovwDao.listAll(search_option, keyword, start,end);
	}
	@Override
	public List<OvwDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		return ovwDao.listPath(search_option, keyword, start,end);
	}
	@Override
	public List<OvwDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		return ovwDao.listTip(search_option, keyword, start,end);
	}
	@Override
	public List<OvwDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		return ovwDao.listParty(search_option, keyword, start,end);
	}

	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 5*1000) {
			ovwDao.increateViewcnt(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return ovwDao.countArticle(search_option, keyword);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		return ovwDao.countArticle2(search_option, keyword);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		return ovwDao.countArticle3(search_option, keyword);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		return ovwDao.countArticle4(search_option, keyword);
	}

	@Override
	public OvwDTO read(int bno) throws Exception {
		return ovwDao.read(bno);
	}

}
