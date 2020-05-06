package com.example.teamProject.service.mps;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.mps.dao.MpsDAO;
import com.example.teamProject.model.mps.dto.MpsDTO;


@Service //service bean
public class MpsServiceImpl implements MpsService {
	
	@Inject
	MpsDAO mpsDao;

	@Override
	public void deleteFile(String fullName) {
		mpsDao.deleteFile(fullName);
	}

	@Override
	public List<String> getAttach(int bno) {
		return mpsDao.getAttach(bno);
	}

	@Transactional
	@Override
	public void create(MpsDTO dto) throws Exception {
		mpsDao.create(dto);
		String[] files=dto.getFiles(); 
		if(files==null) return; 
		for(String name : files) {
			mpsDao.addAttach(name);
		}
		
	}

	@Transactional
	@Override
	public void update(MpsDTO dto) throws Exception {
		mpsDao.update(dto);
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			mpsDao.updateAttach(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		mpsDao.delete(bno);
	}

	@Override
	public List<MpsDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return mpsDao.listAll(search_option, keyword, start,end);
	}
	@Override
	public List<MpsDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		return mpsDao.listPath(search_option, keyword, start,end);
	}
	@Override
	public List<MpsDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		return mpsDao.listTip(search_option, keyword, start,end);
	}
	@Override
	public List<MpsDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		return mpsDao.listParty(search_option, keyword, start,end);
	}

	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 5*1000) {
			mpsDao.increateViewcnt(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return mpsDao.countArticle(search_option, keyword);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		return mpsDao.countArticle2(search_option, keyword);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		return mpsDao.countArticle3(search_option, keyword);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		return mpsDao.countArticle4(search_option, keyword);
	}

	@Override
	public MpsDTO read(int bno) throws Exception {
		return mpsDao.read(bno);
	}

}
