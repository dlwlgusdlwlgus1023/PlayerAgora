package com.example.teamProject.service.fif;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.fif.dto.FifDTO;

public interface FifService {
   public void deleteFile(String fullName); //÷������ ����v
   public List<String> getAttach(int bno); //÷������ ����v
   public void create(FifDTO dto) throws Exception; //�۾���v 
   public void update(FifDTO dto) throws Exception; //�ۼ���v
   public void delete(int bno) throws Exception; //�ۻ���v
   public List<FifDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//���v
   public void increateViewcnt(int bno, HttpSession session) throws Exception;//��ȸ�� ���� ó��v
   public int countArticle(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle2(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle3(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle4(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public FifDTO read(int bno) throws Exception;//���ڵ� ��ȸv
   public List<FifDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<FifDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<FifDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;//���v
}