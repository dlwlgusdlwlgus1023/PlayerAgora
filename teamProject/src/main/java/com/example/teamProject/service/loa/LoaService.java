package com.example.teamProject.service.loa;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.loa.dto.LoaDTO;

public interface LoaService {
   public void deleteFile(String fullName); //÷������ ����v
   public List<String> getAttach(int bno); //÷������ ����v
   public void create(LoaDTO dto) throws Exception; //�۾���v 
   public void update(LoaDTO dto) throws Exception; //�ۼ���v
   public void delete(int bno) throws Exception; //�ۻ���v
   public List<LoaDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//���v
   public void increateViewcnt(int bno, HttpSession session) throws Exception;//��ȸ�� ���� ó��v
   public int countArticle(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle2(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle3(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle4(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public LoaDTO read(int bno) throws Exception;//���ڵ� ��ȸv
   public List<LoaDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<LoaDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<LoaDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;//���v
}