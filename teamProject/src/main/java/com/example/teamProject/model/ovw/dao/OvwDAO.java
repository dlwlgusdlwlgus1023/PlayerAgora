package com.example.teamProject.model.ovw.dao;

import java.util.List;

import com.example.teamProject.model.ovw.dto.OvwDTO;

public interface OvwDAO {
	public void deleteFile(String fullName); 
	public List<String> getAttach(int bno); 
	public void addAttach(String fullName); 
	public void updateAttach(String fullName, int bno);
	public void create(OvwDTO dto) throws Exception;  
	public void update(OvwDTO dto) throws Exception; 
	public void delete(int bno) throws Exception; 
	public List<OvwDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increateViewcnt(int bno) throws Exception;
	public int countArticle(String search_option, String keyword) throws Exception;
	public int countArticle2(String search_option, String keyword) throws Exception;
	public int countArticle3(String search_option, String keyword) throws Exception;
	public int countArticle4(String search_option, String keyword) throws Exception;
	public OvwDTO read(int bno) throws Exception;
	public OvwDTO writer(String writer) throws Exception;
	public OvwDTO nick(String nick) throws Exception;
	public List<OvwDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;
	public List<OvwDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;
	public List<OvwDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;


}
