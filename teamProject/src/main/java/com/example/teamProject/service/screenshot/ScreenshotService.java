package com.example.teamProject.service.screenshot;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.screenshot.dto.ScreenshotDTO;

public interface ScreenshotService {
	public void deleteFile(String fullName); //첨부파일 삭제v
	public List<String> getUpload(int bno); //첨부파일 정보v
	public void create(ScreenshotDTO dto) throws Exception; //글쓰기v 
	public void update(ScreenshotDTO dto) throws Exception; //글수정v
	public void delete(int bno) throws Exception; //글삭제v
	public List<ScreenshotDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//목록v
	public List<ScreenshotDTO> listMine(String search_option, String keyword, int start, int end, String writer) throws Exception;//목록v
	public List<ScreenshotDTO> listBtg(String search_option, String keyword, int start, int end) throws Exception;//���v
	public List<ScreenshotDTO> listSud(String search_option, String keyword, int start, int end) throws Exception;//���v
	public List<ScreenshotDTO> listOve(String search_option, String keyword, int start, int end) throws Exception;//���v
	public List<ScreenshotDTO> listWow(String search_option, String keyword, int start, int end) throws Exception;//���v
	public List<ScreenshotDTO> listLoa(String search_option, String keyword, int start, int end) throws Exception;//���v
	public List<ScreenshotDTO> listMps(String search_option, String keyword, int start, int end) throws Exception;//���v
	public List<ScreenshotDTO> listLol(String search_option, String keyword, int start, int end) throws Exception;//���v
	public List<ScreenshotDTO> listDot(String search_option, String keyword, int start, int end) throws Exception;//���v
	public List<ScreenshotDTO> listHos(String search_option, String keyword, int start, int end) throws Exception;//���v
	public List<ScreenshotDTO> listSta(String search_option, String keyword, int start, int end) throws Exception;//���v
	public List<ScreenshotDTO> listMic(String search_option, String keyword, int start, int end) throws Exception;//���v
	public List<ScreenshotDTO> listCiv(String search_option, String keyword, int start, int end) throws Exception;//���v
	public List<ScreenshotDTO> listFif(String search_option, String keyword, int start, int end) throws Exception;//���v
	public List<ScreenshotDTO> listNfs(String search_option, String keyword, int start, int end) throws Exception;//���v
	public List<ScreenshotDTO> listWin(String search_option, String keyword, int start, int end) throws Exception;//���v
	public int countArticle(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public int countArticleMine(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public int countArticleBtg(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public int countArticleSud(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public int countArticleOve(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public int countArticleWow(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public int countArticleLoa(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public int countArticleMps(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public int countArticleLol(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public int countArticleDot(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public int countArticleHos(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public int countArticleSta(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public int countArticleMic(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public int countArticleCiv(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public int countArticleFif(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public int countArticleNfs(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public int countArticleWin(String search_option, String keyword) throws Exception;//레코드 갯수 계산v
	public void increateViewcnt(int bno, HttpSession session) throws Exception;//조회수 증가 처리v
	public ScreenshotDTO read(int bno) throws Exception;//레코드 조회v

}
