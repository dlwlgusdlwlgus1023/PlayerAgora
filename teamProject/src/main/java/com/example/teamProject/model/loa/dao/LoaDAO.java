package com.example.teamProject.model.loa.dao;

import java.util.List;

import com.example.teamProject.model.loa.dto.LoaDTO;

public interface LoaDAO {
	public void deleteFile(String fullName); 
	public List<String> getAttach(int bno); 
	public void addAttach(String fullName); 
	public void updateAttach(String fullName, int bno);
	public void create(LoaDTO dto) throws Exception;  
	public void update(LoaDTO dto) throws Exception; 
	public void delete(int bno) throws Exception; 
	public List<LoaDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increateViewcnt(int bno) throws Exception;
	public int countArticle(String search_option, String keyword) throws Exception;
	public int countArticle2(String search_option, String keyword) throws Exception;
	public int countArticle3(String search_option, String keyword) throws Exception;
	public int countArticle4(String search_option, String keyword) throws Exception;
	public LoaDTO read(int bno) throws Exception;
	public LoaDTO writer(String writer) throws Exception;
	public LoaDTO nick(String nick) throws Exception;
	public List<LoaDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;
	public List<LoaDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;
	public List<LoaDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;


}
