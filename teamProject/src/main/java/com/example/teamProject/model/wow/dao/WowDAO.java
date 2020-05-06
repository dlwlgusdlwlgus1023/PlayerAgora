package com.example.teamProject.model.wow.dao;

import java.util.List;

import com.example.teamProject.model.wow.dto.WowDTO;

public interface WowDAO {
	public void deleteFile(String fullName); 
	public List<String> getAttach(int bno); 
	public void addAttach(String fullName); 
	public void updateAttach(String fullName, int bno);
	public void create(WowDTO dto) throws Exception;  
	public void update(WowDTO dto) throws Exception; 
	public void delete(int bno) throws Exception; 
	public List<WowDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increateViewcnt(int bno) throws Exception;
	public int countArticle(String search_option, String keyword) throws Exception;
	public int countArticle2(String search_option, String keyword) throws Exception;
	public int countArticle3(String search_option, String keyword) throws Exception;
	public int countArticle4(String search_option, String keyword) throws Exception;
	public WowDTO read(int bno) throws Exception;
	public WowDTO writer(String writer) throws Exception;
	public WowDTO nick(String nick) throws Exception;
	public List<WowDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;
	public List<WowDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;
	public List<WowDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;


}
