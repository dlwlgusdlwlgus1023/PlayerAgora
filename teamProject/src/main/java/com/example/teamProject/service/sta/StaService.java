package com.example.teamProject.service.sta;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.sta.dto.StaDTO;

public interface StaService {
   public void deleteFile(String fullName); //÷������ ����v
   public List<String> getAttach(int bno); //÷������ ����v
   public void create(StaDTO dto) throws Exception; //�۾���v 
   public void update(StaDTO dto) throws Exception; //�ۼ���v
   public void delete(int bno) throws Exception; //�ۻ���v
   public List<StaDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//���v
   public void increateViewcnt(int bno, HttpSession session) throws Exception;//��ȸ�� ���� ó��v
   public int countArticle(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle2(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle3(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle4(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public StaDTO read(int bno) throws Exception;//���ڵ� ��ȸv
   public List<StaDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<StaDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<StaDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;//���v
}