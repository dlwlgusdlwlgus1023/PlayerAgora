package com.example.teamProject.service.mic;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.mic.dto.MicDTO;

public interface MicService {
   public void deleteFile(String fullName); //÷������ ����v
   public List<String> getAttach(int bno); //÷������ ����v
   public void create(MicDTO dto) throws Exception; //�۾���v 
   public void update(MicDTO dto) throws Exception; //�ۼ���v
   public void delete(int bno) throws Exception; //�ۻ���v
   public List<MicDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//���v
   public void increateViewcnt(int bno, HttpSession session) throws Exception;//��ȸ�� ���� ó��v
   public int countArticle(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle2(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle3(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public int countArticle4(String search_option, String keyword) throws Exception;//���ڵ� ���� ���v
   public MicDTO read(int bno) throws Exception;//���ڵ� ��ȸv
   public List<MicDTO> listPath(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<MicDTO> listTip(String search_option, String keyword, int start, int end) throws Exception;//���v
   public List<MicDTO> listParty(String search_option, String keyword, int start, int end) throws Exception;//���v
}