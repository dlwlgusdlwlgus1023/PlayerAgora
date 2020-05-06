package com.example.teamProject.service.win;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.win.dto.WinDTO;

public interface WinService {
   public void deleteFile(String fullName); //÷������ ����v
   public List<String> getAttach(int bno); //÷������ ����v
   public void create(WinDTO dto) throws Exception; //�۾���v 
   public void update(WinDTO dto) throws Exception; //�ۼ���v
   public void delete(int bno) throws Exception; //�ۻ���v
   public List<WinDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//���v
   public void increateViewcnt(int bno, HttpSession session) throws Exception;//��ȸ�� ���� ó��v
   public int countArticle(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle2(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle3(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle4(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public WinDTO read(int bno) throws Exception;//���ڵ� ��ȸv
   public List<WinDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<WinDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<WinDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;//���v
}