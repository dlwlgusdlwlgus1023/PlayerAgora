package com.example.teamProject.model.dot.dao;

import java.util.List;

import com.example.teamProject.model.dot.dto.DotDTO;

public interface DotDAO {
	public void deleteFile(String fullName); 
	public List<String> getAttach(int bno); 
	public void addAttach(String fullName); 
	public void updateAttach(String fullName, int bno);
	public void create(DotDTO dto) throws Exception;  
	public void update(DotDTO dto) throws Exception; 
	public void delete(int bno) throws Exception; 
	public List<DotDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increateViewcnt(int bno) throws Exception;
	public int countArticle(String search_option, String keyword) throws Exception;
	public int countArticle2(String search_option, String keyword) throws Exception;
	public int countArticle3(String search_option, String keyword) throws Exception;
	public int countArticle4(String search_option, String keyword) throws Exception;
	public DotDTO read(int bno) throws Exception;
	public DotDTO writer(String writer) throws Exception;
	public DotDTO nick(String nick) throws Exception;
	public List<DotDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;
	public List<DotDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;
	public List<DotDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;


}
