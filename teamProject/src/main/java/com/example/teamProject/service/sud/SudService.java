package com.example.teamProject.service.sud;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.sud.dto.SudDTO;

public interface SudService {
   public void deleteFile(String fullName); //÷������ ����v
   public List<String> getAttach(int bno); //÷������ ����v
   public void create(SudDTO dto) throws Exception; //�۾���v 
   public void update(SudDTO dto) throws Exception; //�ۼ���v
   public void delete(int bno) throws Exception; //�ۻ���v
   public List<SudDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//���v
   public void increateViewcnt(int bno, HttpSession session) throws Exception;//��ȸ�� ���� ó��v
   public int countArticle(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle2(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle3(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle4(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public SudDTO read(int bno) throws Exception;//���ڵ� ��ȸv
   public List<SudDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<SudDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<SudDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;//���v
}