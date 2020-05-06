package com.example.teamProject.service.mps;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.mps.dto.MpsDTO;

public interface MpsService {
   public void deleteFile(String fullName); //÷������ ����v
   public List<String> getAttach(int bno); //÷������ ����v
   public void create(MpsDTO dto) throws Exception; //�۾���v 
   public void update(MpsDTO dto) throws Exception; //�ۼ���v
   public void delete(int bno) throws Exception; //�ۻ���v
   public List<MpsDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//���v
   public void increateViewcnt(int bno, HttpSession session) throws Exception;//��ȸ�� ���� ó��v
   public int countArticle(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle2(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle3(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle4(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public MpsDTO read(int bno) throws Exception;//���ڵ� ��ȸv
   public List<MpsDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<MpsDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<MpsDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;//���v
}