package com.example.teamProject.model.btg.dao;

import java.util.List;

import com.example.teamProject.model.btg.dto.BtgDTO;

public interface BtgDAO {
	public void deleteFile(String fullName); 
	public List<String> getAttach(int bno); 
	public void addAttach(String fullName); 
	public void updateAttach(String fullName, int bno);
	public void create(BtgDTO dto) throws Exception;  
	public void update(BtgDTO dto) throws Exception; 
	public void delete(int bno) throws Exception; 
	public List<BtgDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increateViewcnt(int bno) throws Exception;
	public int countArticle(String search_option, String keyword) throws Exception;
	public int countArticle2(String search_option, String keyword) throws Exception;
	public int countArticle3(String search_option, String keyword) throws Exception;
	public int countArticle4(String search_option, String keyword) throws Exception;
	public BtgDTO read(int bno) throws Exception;
	public BtgDTO writer(String writer) throws Exception;
	public BtgDTO nick(String nick) throws Exception;
	public List<BtgDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;
	public List<BtgDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;
	public List<BtgDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;


}
