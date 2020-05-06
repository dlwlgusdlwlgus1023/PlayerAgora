package com.example.teamProject.service.main;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.main.dto.MainDTO;

public interface MainService {
   public void deleteFile(String fullName); //÷������ ����v
   public List<String> getAttach(int bno); //÷������ ����v
   public void create(MainDTO dto) throws Exception; //�۾���v 
   public void update(MainDTO dto) throws Exception; //�ۼ���v
   public void delete(int bno) throws Exception; //�ۻ���v
   public List<MainDTO> listAll(String search_option, String keyword) throws Exception;//���v
   public void increateViewcnt(int bno, HttpSession session) throws Exception;//��ȸ�� ���� ó��v
   public MainDTO read(int bno) throws Exception;//���ڵ� ��ȸv
}