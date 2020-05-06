package com.example.teamProject.model.screenshot.dao;

import java.util.List;

import com.example.teamProject.model.screenshot.dto.ScreenshotDTO;

public interface ScreenshotDAO {
	public void deleteFile(String fullName); //첨부파일 삭제
	public List<String> getUpload(int bno); //첨부파일 정보
	public void addUpload(String fullName); //첨부파일 저장
	public void updateUpload(String fullName, int bno);//첨부파일 수정
	public void create(ScreenshotDTO dto) throws Exception; //글쓰기 
	public void update(ScreenshotDTO dto) throws Exception; //글수정
	public void delete(int bno) throws Exception; //글삭제
	public List<ScreenshotDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//목록
	public List<ScreenshotDTO> listMine(String search_option, String keyword, int start, int end, String writer) throws Exception;//목록
	public List<ScreenshotDTO> listBtg(String search_option, String keyword, int start, int end) throws Exception;//목록
	public List<ScreenshotDTO> listSud(String search_option, String keyword, int start, int end) throws Exception;//목록
	public List<ScreenshotDTO> listOve(String search_option, String keyword, int start, int end) throws Exception;//목록
	public List<ScreenshotDTO> listWow(String search_option, String keyword, int start, int end) throws Exception;//목록
	public List<ScreenshotDTO> listLoa(String search_option, String keyword, int start, int end) throws Exception;//목록
	public List<ScreenshotDTO> listMps(String search_option, String keyword, int start, int end) throws Exception;//목록
	public List<ScreenshotDTO> listLol(String search_option, String keyword, int start, int end) throws Exception;//목록
	public List<ScreenshotDTO> listDot(String search_option, String keyword, int start, int end) throws Exception;//목록
	public List<ScreenshotDTO> listHos(String search_option, String keyword, int start, int end) throws Exception;//목록
	public List<ScreenshotDTO> listSta(String search_option, String keyword, int start, int end) throws Exception;//목록
	public List<ScreenshotDTO> listMic(String search_option, String keyword, int start, int end) throws Exception;//목록
	public List<ScreenshotDTO> listCiv(String search_option, String keyword, int start, int end) throws Exception;//목록
	public List<ScreenshotDTO> listFif(String search_option, String keyword, int start, int end) throws Exception;//목록
	public List<ScreenshotDTO> listNfs(String search_option, String keyword, int start, int end) throws Exception;//목록
	public List<ScreenshotDTO> listWin(String search_option, String keyword, int start, int end) throws Exception;//목록
	public int countArticle(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public int countArticleMine(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public int countArticleBtg(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public int countArticleSud(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public int countArticleOve(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public int countArticleWow(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public int countArticleLoa(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public int countArticleMps(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public int countArticleLol(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public int countArticleDot(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public int countArticleHos(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public int countArticleSta(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public int countArticleMic(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public int countArticleCiv(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public int countArticleFif(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public int countArticleNfs(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public int countArticleWin(String search_option, String keyword) throws Exception;//레코드 갯수 계산
	public void increateViewcnt(int bno) throws Exception;//조회수 증가 처리
	public ScreenshotDTO read(int bno) throws Exception;//레코드 조회
}
