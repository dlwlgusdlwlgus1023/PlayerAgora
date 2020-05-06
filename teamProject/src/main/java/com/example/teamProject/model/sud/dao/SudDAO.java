package com.example.teamProject.model.sud.dao;

import java.util.List;

import com.example.teamProject.model.sud.dto.SudDTO;

public interface SudDAO {
	public void deleteFile(String fullName); 
	public List<String> getAttach(int bno); 
	public void addAttach(String fullName); 
	public void updateAttach(String fullName, int bno);
	public void create(SudDTO dto) throws Exception;  
	public void update(SudDTO dto) throws Exception; 
	public void delete(int bno) throws Exception; 
	public List<SudDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increateViewcnt(int bno) throws Exception;
	public int countArticle(String search_option, String keyword) throws Exception;
	public int countArticle2(String search_option, String keyword) throws Exception;
	public int countArticle3(String search_option, String keyword) throws Exception;
	public int countArticle4(String search_option, String keyword) throws Exception;
	public SudDTO read(int bno) throws Exception;
	public SudDTO writer(String writer) throws Exception;
	public SudDTO nick(String nick) throws Exception;
	public List<SudDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;
	public List<SudDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;
	public List<SudDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;


}
