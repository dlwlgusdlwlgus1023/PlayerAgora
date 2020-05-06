package com.example.teamProject.model.nfs.dao;

import java.util.List;

import com.example.teamProject.model.nfs.dto.NfsDTO;

public interface NfsDAO {
	public void deleteFile(String fullName); 
	public List<String> getAttach(int bno); 
	public void addAttach(String fullName); 
	public void updateAttach(String fullName, int bno);
	public void create(NfsDTO dto) throws Exception;  
	public void update(NfsDTO dto) throws Exception; 
	public void delete(int bno) throws Exception; 
	public List<NfsDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increateViewcnt(int bno) throws Exception;
	public int countArticle(String search_option, String keyword) throws Exception;
	public int countArticle2(String search_option, String keyword) throws Exception;
	public int countArticle3(String search_option, String keyword) throws Exception;
	public int countArticle4(String search_option, String keyword) throws Exception;
	public NfsDTO read(int bno) throws Exception;
	public NfsDTO writer(String writer) throws Exception;
	public NfsDTO nick(String nick) throws Exception;
	public List<NfsDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;
	public List<NfsDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;
	public List<NfsDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;


}
