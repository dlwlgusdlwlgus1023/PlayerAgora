package com.example.teamProject.model.mps.dao;

import java.util.List;

import com.example.teamProject.model.mps.dto.MpsDTO;

public interface MpsDAO {
	public void deleteFile(String fullName); 
	public List<String> getAttach(int bno); 
	public void addAttach(String fullName); 
	public void updateAttach(String fullName, int bno);
	public void create(MpsDTO dto) throws Exception;  
	public void update(MpsDTO dto) throws Exception; 
	public void delete(int bno) throws Exception; 
	public List<MpsDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increateViewcnt(int bno) throws Exception;
	public int countArticle(String search_option, String keyword) throws Exception;
	public int countArticle2(String search_option, String keyword) throws Exception;
	public int countArticle3(String search_option, String keyword) throws Exception;
	public int countArticle4(String search_option, String keyword) throws Exception;
	public MpsDTO read(int bno) throws Exception;
	public MpsDTO writer(String writer) throws Exception;
	public MpsDTO nick(String nick) throws Exception;
	public List<MpsDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;
	public List<MpsDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;
	public List<MpsDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;


}
