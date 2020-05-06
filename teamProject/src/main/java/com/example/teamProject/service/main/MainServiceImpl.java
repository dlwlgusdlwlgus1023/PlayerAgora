package com.example.teamProject.service.main;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamProject.model.main.dao.MainDAO;
import com.example.teamProject.model.main.dto.MainDTO;

@Service // service bean
public class MainServiceImpl implements MainService {

	@Inject
	MainDAO mainDao;

	@Override
	public void deleteFile(String fullName) {
		mainDao.deleteFile(fullName);
	}

	@Override
	public List<String> getAttach(int bno) {
		return mainDao.getAttach(bno);
	}

	@Transactional
	@Override
	public void create(MainDTO dto) throws Exception {
		mainDao.create(dto);
		String[] files = dto.getFiles();
		if (files == null)
			return;
		for (String name : files) {
			mainDao.addAttach(name);
		}

	}

	@Transactional
	@Override
	public void update(MainDTO dto) throws Exception {
		mainDao.update(dto);
		String[] files = dto.getFiles();
		if (files == null)
			return;
		for (String name : files) {
			mainDao.updateAttach(name, dto.getBno());
		}
	}

	@Transactional
	@Override
	public void delete(int bno) throws Exception {
		mainDao.delete(bno);
	}

	@Override
	public List<MainDTO> listAll(String search_option, String keyword) throws Exception {
		return mainDao.listAll(search_option, keyword, 1, 20);
	}

	@Override
	public void increateViewcnt(int bno, HttpSession session) throws Exception {
		long update_time = 0;
		if (session.getAttribute("update_time_" + bno) != null) {
			update_time = (long) session.getAttribute("update_time_" + bno);
		}
		long current_time = System.currentTimeMillis();
		if (current_time - update_time > 5 * 1000) {
			mainDao.increateViewcnt(bno);
			session.setAttribute("update_time_" + bno, current_time);
		}
	}

	@Override
	public MainDTO read(int bno) throws Exception {
		return mainDao.read(bno);
	}

}
