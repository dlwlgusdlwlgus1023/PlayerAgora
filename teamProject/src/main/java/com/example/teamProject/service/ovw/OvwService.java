package com.example.teamProject.service.ovw;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.ovw.dto.OvwDTO;

public interface OvwService {
   public void deleteFile(String fullName); //÷������ ����v
   public List<String> getAttach(int bno); //÷������ ����v
   public void create(OvwDTO dto) throws Exception; //�۾���v 
   public void update(OvwDTO dto) throws Exception; //�ۼ���v
   public void delete(int bno) throws Exception; //�ۻ���v
   public List<OvwDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//���v
   public void increateViewcnt(int bno, HttpSession session) throws Exception;//��ȸ�� ���� ó��v
   public int countArticle(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle2(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle3(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle4(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public OvwDTO read(int bno) throws Exception;//���ڵ� ��ȸv
   public List<OvwDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<OvwDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<OvwDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;//���v
}