package com.example.teamProject.model.fif.dao;

import java.util.List;

import com.example.teamProject.model.fif.dto.FifDTO;

public interface FifDAO {
	public void deleteFile(String fullName); 
	public List<String> getAttach(int bno); 
	public void addAttach(String fullName); 
	public void updateAttach(String fullName, int bno);
	public void create(FifDTO dto) throws Exception;  
	public void update(FifDTO dto) throws Exception; 
	public void delete(int bno) throws Exception; 
	public List<FifDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increateViewcnt(int bno) throws Exception;
	public int countArticle(String search_option, String keyword) throws Exception;
	public int countArticle2(String search_option, String keyword) throws Exception;
	public int countArticle3(String search_option, String keyword) throws Exception;
	public int countArticle4(String search_option, String keyword) throws Exception;
	public FifDTO read(int bno) throws Exception;
	public FifDTO writer(String writer) throws Exception;
	public FifDTO nick(String nick) throws Exception;
	public List<FifDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;
	public List<FifDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;
	public List<FifDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;


}
