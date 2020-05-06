package com.example.teamProject.service.dot;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.dot.dto.DotDTO;

public interface DotService {
   public void deleteFile(String fullName); //÷������ ����v
   public List<String> getAttach(int bno); //÷������ ����v
   public void create(DotDTO dto) throws Exception; //�۾���v 
   public void update(DotDTO dto) throws Exception; //�ۼ���v
   public void delete(int bno) throws Exception; //�ۻ���v
   public List<DotDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//���v
   public void increateViewcnt(int bno, HttpSession session) throws Exception;//��ȸ�� ���� ó��v
   public int countArticle(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle2(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle3(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle4(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public DotDTO read(int bno) throws Exception;//���ڵ� ��ȸv
   public List<DotDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<DotDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<DotDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;//���v
}