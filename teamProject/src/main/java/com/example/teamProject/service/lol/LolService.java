package com.example.teamProject.service.lol;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.lol.dto.LolDTO;

public interface LolService {
   public void deleteFile(String fullName); //÷������ ����v
   public List<String> getAttach(int bno); //÷������ ����v
   public void create(LolDTO dto) throws Exception; //�۾���v 
   public void update(LolDTO dto) throws Exception; //�ۼ���v
   public void delete(int bno) throws Exception; //�ۻ���v
   public List<LolDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//���v
   public void increateViewcnt(int bno, HttpSession session) throws Exception;//��ȸ�� ���� ó��v
   public int countArticle(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle2(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle3(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle4(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public LolDTO read(int bno) throws Exception;//���ڵ� ��ȸv
   public List<LolDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<LolDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<LolDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;//���v
}