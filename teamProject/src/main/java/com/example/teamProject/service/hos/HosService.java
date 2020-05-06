package com.example.teamProject.service.hos;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.hos.dto.HosDTO;

public interface HosService {
   public void deleteFile(String fullName); //÷������ ����v
   public List<String> getAttach(int bno); //÷������ ����v
   public void create(HosDTO dto) throws Exception; //�۾���v 
   public void update(HosDTO dto) throws Exception; //�ۼ���v
   public void delete(int bno) throws Exception; //�ۻ���v
   public List<HosDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//���v
   public void increateViewcnt(int bno, HttpSession session) throws Exception;//��ȸ�� ���� ó��v
   public int countArticle(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle2(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle3(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle4(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public HosDTO read(int bno) throws Exception;//���ڵ� ��ȸv
   public List<HosDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<HosDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<HosDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;//���v
}