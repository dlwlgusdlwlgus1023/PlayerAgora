package com.example.teamProject.service.nfs;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.nfs.dto.NfsDTO;

public interface NfsService {
   public void deleteFile(String fullName); //÷������ ����v
   public List<String> getAttach(int bno); //÷������ ����v
   public void create(NfsDTO dto) throws Exception; //�۾���v 
   public void update(NfsDTO dto) throws Exception; //�ۼ���v
   public void delete(int bno) throws Exception; //�ۻ���v
   public List<NfsDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//���v
   public void increateViewcnt(int bno, HttpSession session) throws Exception;//��ȸ�� ���� ó��v
   public int countArticle(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle2(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle3(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle4(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public NfsDTO read(int bno) throws Exception;//���ڵ� ��ȸv
   public List<NfsDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<NfsDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<NfsDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;//���v
}