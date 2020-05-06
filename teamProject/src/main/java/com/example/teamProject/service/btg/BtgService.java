package com.example.teamProject.service.btg;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.btg.dto.BtgDTO;

public interface BtgService {
   public void deleteFile(String fullName); //÷������ ����v
   public List<String> getAttach(int bno); //÷������ ����v
   public void create(BtgDTO dto) throws Exception; //�۾���v 
   public void update(BtgDTO dto) throws Exception; //�ۼ���v
   public void delete(int bno) throws Exception; //�ۻ���v
   public List<BtgDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//���v
   public void increateViewcnt(int bno, HttpSession session) throws Exception;//��ȸ�� ���� ó��v
   public int countArticle(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle2(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle3(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle4(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public BtgDTO read(int bno) throws Exception;//���ڵ� ��ȸv
   public List<BtgDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<BtgDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<BtgDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;//���v
}