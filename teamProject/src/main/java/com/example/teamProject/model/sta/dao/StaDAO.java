package com.example.teamProject.model.sta.dao;

import java.util.List;

import com.example.teamProject.model.sta.dto.StaDTO;

public interface StaDAO {
	public void deleteFile(String fullName); 
	public List<String> getAttach(int bno); 
	public void addAttach(String fullName); 
	public void updateAttach(String fullName, int bno);
	public void create(StaDTO dto) throws Exception;  
	public void update(StaDTO dto) throws Exception; 
	public void delete(int bno) throws Exception; 
	public List<StaDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increateViewcnt(int bno) throws Exception;
	public int countArticle(String search_option, String keyword) throws Exception;
	public int countArticle2(String search_option, String keyword) throws Exception;
	public int countArticle3(String search_option, String keyword) throws Exception;
	public int countArticle4(String search_option, String keyword) throws Exception;
	public StaDTO read(int bno) throws Exception;
	public StaDTO writer(String writer) throws Exception;
	public StaDTO nick(String nick) throws Exception;
	public List<StaDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;
	public List<StaDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;
	public List<StaDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;


}
