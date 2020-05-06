package com.example.teamProject.model.hos.dao;

import java.util.List;

import com.example.teamProject.model.hos.dto.HosDTO;

public interface HosDAO {
	public void deleteFile(String fullName); 
	public List<String> getAttach(int bno); 
	public void addAttach(String fullName); 
	public void updateAttach(String fullName, int bno);
	public void create(HosDTO dto) throws Exception;  
	public void update(HosDTO dto) throws Exception; 
	public void delete(int bno) throws Exception; 
	public List<HosDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increateViewcnt(int bno) throws Exception;
	public int countArticle(String search_option, String keyword) throws Exception;
	public int countArticle2(String search_option, String keyword) throws Exception;
	public int countArticle3(String search_option, String keyword) throws Exception;
	public int countArticle4(String search_option, String keyword) throws Exception;
	public HosDTO read(int bno) throws Exception;
	public HosDTO writer(String writer) throws Exception;
	public HosDTO nick(String nick) throws Exception;
	public List<HosDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;
	public List<HosDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;
	public List<HosDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;


}
