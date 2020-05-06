package com.example.teamProject.model.lol.dao;

import java.util.List;

import com.example.teamProject.model.lol.dto.LolDTO;

public interface LolDAO {
	public void deleteFile(String fullName); 
	public List<String> getAttach(int bno); 
	public void addAttach(String fullName); 
	public void updateAttach(String fullName, int bno);
	public void create(LolDTO dto) throws Exception;  
	public void update(LolDTO dto) throws Exception; 
	public void delete(int bno) throws Exception; 
	public List<LolDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increateViewcnt(int bno) throws Exception;
	public int countArticle(String search_option, String keyword) throws Exception;
	public int countArticle2(String search_option, String keyword) throws Exception;
	public int countArticle3(String search_option, String keyword) throws Exception;
	public int countArticle4(String search_option, String keyword) throws Exception;
	public LolDTO read(int bno) throws Exception;
	public LolDTO writer(String writer) throws Exception;
	public LolDTO nick(String nick) throws Exception;
	public List<LolDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;
	public List<LolDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;
	public List<LolDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;


}
