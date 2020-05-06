package com.example.teamProject.model.civ.dao;

import java.util.List;

import com.example.teamProject.model.civ.dto.CivDTO;

public interface CivDAO {
	public void deleteFile(String fullName); 
	public List<String> getAttach(int bno); 
	public void addAttach(String fullName); 
	public void updateAttach(String fullName, int bno);
	public void create(CivDTO dto) throws Exception;  
	public void update(CivDTO dto) throws Exception; 
	public void delete(int bno) throws Exception; 
	public List<CivDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increateViewcnt(int bno) throws Exception;
	public int countArticle(String search_option, String keyword) throws Exception;
	public int countArticle2(String search_option, String keyword) throws Exception;
	public int countArticle3(String search_option, String keyword) throws Exception;
	public int countArticle4(String search_option, String keyword) throws Exception;
	public CivDTO read(int bno) throws Exception;
	public CivDTO writer(String writer) throws Exception;
	public CivDTO nick(String nick) throws Exception;
	public List<CivDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;
	public List<CivDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;
	public List<CivDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;


}
