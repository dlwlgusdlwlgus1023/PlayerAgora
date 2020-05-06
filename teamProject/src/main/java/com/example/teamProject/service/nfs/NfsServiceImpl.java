package com.example.teamProject.service.nfs;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.nfs.dao.NfsDAO;
import com.example.teamProject.model.nfs.dto.NfsDTO;


@Service //service bean
public class NfsServiceImpl implements NfsService {
	
	@Inject
	NfsDAO nfsDao;

	@Override
	public void deleteFile(String fullName) {
		nfsDao.deleteFile(fullName);
	}

	@Override
	public List<String> getAttach(int bno) {
		return nfsDao.getAttach(bno);
	}

	@Transactional
	@Override
	public void create(NfsDTO dto) throws Exception {
		nfsDao.create(dto);
		String[] files=dto.getFiles(); 
		if(files==null) return; 
		for(String name : files) {
			nfsDao.addAttach(name);
		}
		
	}

	@Transactional
	@Override
	public void update(NfsDTO dto) throws Exception {
		nfsDao.update(dto);
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			nfsDao.updateAttach(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		nfsDao.delete(bno);
	}

	@Override
	public List<NfsDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return nfsDao.listAll(search_option, keyword, start,end);
	}
	@Override
	public List<NfsDTO> listPath(String search_option, String keyword, int start, int end) throws Exception {
		return nfsDao.listPath(search_option, keyword, start,end);
	}
	@Override
	public List<NfsDTO> listTip(String search_option, String keyword, int start, int end) throws Exception {
		return nfsDao.listTip(search_option, keyword, start,end);
	}
	@Override
	public List<NfsDTO> listParty(String search_option, String keyword, int start, int end) throws Exception {
		return nfsDao.listParty(search_option, keyword, start,end);
	}

	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time=(long)session.getAttribute("update_time_"+bno);
		}
		long current_time=System.currentTimeMillis();
		if(current_time - update_time > 5*1000) {
			nfsDao.increateViewcnt(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		return nfsDao.countArticle(search_option, keyword);
	}
	@Override
	public int countArticle2(String search_option, String keyword) throws Exception {
		return nfsDao.countArticle2(search_option, keyword);
	}
	@Override
	public int countArticle3(String search_option, String keyword) throws Exception {
		return nfsDao.countArticle3(search_option, keyword);
	}
	@Override
	public int countArticle4(String search_option, String keyword) throws Exception {
		return nfsDao.countArticle4(search_option, keyword);
	}

	@Override
	public NfsDTO read(int bno) throws Exception {
		return nfsDao.read(bno);
	}

}
