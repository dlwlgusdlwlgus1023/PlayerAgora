package com.example.teamProject.model.win.dao;

import java.util.List;

import com.example.teamProject.model.win.dto.WinDTO;

public interface WinDAO {
	public void deleteFile(String fullName); 
	public List<String> getAttach(int bno); 
	public void addAttach(String fullName); 
	public void updateAttach(String fullName, int bno);
	public void create(WinDTO dto) throws Exception;  
	public void update(WinDTO dto) throws Exception; 
	public void delete(int bno) throws Exception; 
	public List<WinDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increateViewcnt(int bno) throws Exception;
	public int countArticle(String search_option, String keyword) throws Exception;
	public int countArticle2(String search_option, String keyword) throws Exception;
	public int countArticle3(String search_option, String keyword) throws Exception;
	public int countArticle4(String search_option, String keyword) throws Exception;
	public WinDTO read(int bno) throws Exception;
	public WinDTO writer(String writer) throws Exception;
	public WinDTO nick(String nick) throws Exception;
	public List<WinDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;
	public List<WinDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;
	public List<WinDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;


}
