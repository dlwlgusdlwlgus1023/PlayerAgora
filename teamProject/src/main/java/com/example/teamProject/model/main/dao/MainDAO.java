package com.example.teamProject.model.main.dao;

import java.util.List;

import com.example.teamProject.model.main.dto.MainDTO;

public interface MainDAO {
	public void deleteFile(String fullName); 
	public List<String> getAttach(int bno); 
	public void addAttach(String fullName); 
	public void updateAttach(String fullName, int bno);
	public void create(MainDTO dto) throws Exception;  
	public void update(MainDTO dto) throws Exception; 
	public void delete(int bno) throws Exception; 
	public List<MainDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;
	public void increateViewcnt(int bno) throws Exception;
	public MainDTO read(int bno) throws Exception;
	public MainDTO writer(String writer) throws Exception;
	public MainDTO nick(String nick) throws Exception;
	public MainDTO bord(String nick) throws Exception;
	public MainDTO t_name(String nick) throws Exception;


}
