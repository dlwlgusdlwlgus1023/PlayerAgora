package com.example.teamProject.service.wow;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.wow.dto.WowDTO;

public interface WowService {
   public void deleteFile(String fullName); //÷������ ����v
   public List<String> getAttach(int bno); //÷������ ����v
   public void create(WowDTO dto) throws Exception; //�۾���v 
   public void update(WowDTO dto) throws Exception; //�ۼ���v
   public void delete(int bno) throws Exception; //�ۻ���v
   public List<WowDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//���v
   public void increateViewcnt(int bno, HttpSession session) throws Exception;//��ȸ�� ���� ó��v
   public int countArticle(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle2(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle3(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle4(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public WowDTO read(int bno) throws Exception;//���ڵ� ��ȸv
   public List<WowDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<WowDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<WowDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;//���v
}