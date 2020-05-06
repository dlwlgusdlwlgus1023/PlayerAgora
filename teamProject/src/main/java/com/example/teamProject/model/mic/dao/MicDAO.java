package com.example.teamProject.model.mic.dao;

import java.util.List;

import com.example.teamProject.model.mic.dto.MicDTO;

public interface MicDAO {
	public void deleteFile(String fullName); 
	public List<String> getAttach(int bno); 
	public void addAttach(String fullName); 
	public void updateAttach(String fullName, int bno);
	public void create(MicDTO dto) throws Exception;  
	public void update(MicDTO dto) throws Exception; 
	public void delete(int bno) throws Exception; 
	public List<MicDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increateViewcnt(int bno) throws Exception;
	public int countArticle(String search_option, String keyword) throws Exception;
	public int countArticle2(String search_option, String keyword) throws Exception;
	public int countArticle3(String search_option, String keyword) throws Exception;
	public int countArticle4(String search_option, String keyword) throws Exception;
	public MicDTO read(int bno) throws Exception;
	public MicDTO writer(String writer) throws Exception;
	public MicDTO nick(String nick) throws Exception;
	public List<MicDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;
	public List<MicDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;
	public List<MicDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;


}
