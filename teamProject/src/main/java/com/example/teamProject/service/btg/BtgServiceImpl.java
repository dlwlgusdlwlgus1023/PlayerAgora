package com.example.teamProject.service.btg;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.btg.dao.BtgDAO;
import com.example.teamProject.model.btg.dto.BtgDTO;


@Service //service bean
public class BtgServiceImpl implements BtgService {
	
	@Inject
	BtgDAO btgDao;

	@Override
	public void deleteFile(String fullName) {
		btgDao.deleteFile(fullName);
	}

	@Override
	public List<String> getAttach(int bno) {
		return btgDao.getAttach(bno);
	}

	@Transactional
	@Override
	public void create(BtgDTO dto) throws Exception {
		btgDao.create(dto);
		String[] files=dto.getFiles(); 
		if(files==null) return; 
		for(String name : files) {
			btgDao.addAttach(name);
		}
		
	}

	@Transactional
	@Override
	public void update(BtgDTO dto) throws Exception {
		btgDao.update(dto);
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			btgDao.updateAttach(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		btgDao.delete(bno);
	}

	@Override
	public List<BtgDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return btgDao.listAll(search_option, keyword, start,end);
	}
	@Override
	public List<BtgDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		return btgDao.listPath(search_option, keyword, start,end);
	}
	@Override
	public List<BtgDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		return btgDao.listTip(search_option, keyword, start,end);
	}
	@Override
	public List<BtgDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		return btgDao.listParty(search_option, keyword, start,end);
	}

	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 5*1000) {
			btgDao.increateViewcnt(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return btgDao.countArticle(search_option, keyword);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		return btgDao.countArticle2(search_option, keyword);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		return btgDao.countArticle3(search_option, keyword);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		return btgDao.countArticle4(search_option, keyword);
	}

	@Override
	public BtgDTO read(int bno) throws Exception {
		return btgDao.read(bno);
	}

}
