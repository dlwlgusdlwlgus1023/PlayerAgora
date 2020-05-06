package com.example.teamProject.controller.screenshot;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.teamProject.model.screenshot.dto.ScreenshotDTO;
import com.example.teamProject.service.screenshot.ScreenshotService;
import com.example.teamProject.service.screenshot.Pager;

@Controller //controller bean
@RequestMapping("screenshot/*") //공통적인 url pattern
public class ScreenshotController {
	@Inject
	ScreenshotService screenshotService;
	
	@RequestMapping("list.do") //세부적인 url pattern
	public ModelAndView list(
			@RequestParam(defaultValue = "name") String search_option,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue="1") int curPage) 
			throws Exception {
				
		//레코드 갯수 계산
		int count=screenshotService.countArticle(search_option,keyword);
		//페이지 관련 설정
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		
		List<ScreenshotDTO> 
		list=screenshotService.listAll(search_option,keyword, start,end); //게시물 목록
		ModelAndView mav=new ModelAndView();
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", list); //map에 자료 저장
		map.put("count", count);
		map.put("pager", pager); //페이지 네비게이션을 위한 변수
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		mav.setViewName("screenshot/list"); //포워딩할 뷰의 이름
		mav.addObject("map", map); //ModelAndView에 map을 저장
		return mav; //screenshot/list.jsp로 이동
	}//list()
	@RequestMapping("write.do")
	public String write() {
		//글쓰기 폼 페이지로 이동
		return "screenshot/write";
	}//write()
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute ScreenshotDTO dto, 
			
			HttpSession session) throws Exception {
		//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
		String writer=(String)session.getAttribute("userid");
		//<input name="userid" id="userid">
		dto.setWriter(writer);
		//레코드 저장
		screenshotService.create(dto);
		//게시물 목록으로 이동
		return "redirect:/screenshot/list.do";
	}//insert()
	@RequestMapping("view.do")
	public ModelAndView view(int bno, HttpSession session) 
			throws Exception {
		
		//조회수 증가 처리
		screenshotService.increateViewcnt(bno, session);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("screenshot/view");//포워딩할 뷰의 이름
		mav.addObject("dto", screenshotService.read(bno)); //자료 저장
		return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
	}
	
	
	
	@RequestMapping("listMine.do") //세부적인 url pattern
	public ModelAndView listMine(
			@RequestParam(defaultValue = "name") String search_option,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "${sessionScope.userid}") String writer,
			@RequestParam(defaultValue="1") int curPage) 
			throws Exception {
				
		int count=screenshotService.countArticleMine(search_option,keyword);
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		
		List<ScreenshotDTO> 
		list=screenshotService.listMine(search_option,keyword, start,end, writer); //게시물 목록
		ModelAndView mav=new ModelAndView();
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", list); //map에 자료 저장
		map.put("count", count);
		map.put("pager", pager); //페이지 네비게이션을 위한 변수
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		mav.setViewName("screenshot/listMine"); //포워딩할 뷰의 이름
		mav.addObject("map", map); //ModelAndView에 map을 저장
		return mav; //screenshot/list.jsp로 이동
	}//list()
	@RequestMapping("writeMine.do")
	public String writeMine() {
		//글쓰기 폼 페이지로 이동
		return "screenshot/writeMine";
	}//write()
	@RequestMapping("insertMine.do")
	public String insertMine(@ModelAttribute ScreenshotDTO dto, 
			
			HttpSession session) throws Exception {
		//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
		String writer=(String)session.getAttribute("userid");
		//<input name="userid" id="userid">
		dto.setWriter(writer);
		//레코드 저장
		screenshotService.create(dto);
		//게시물 목록으로 이동
		return "redirect:/screenshot/listMine.do";
	}//insert()
	@RequestMapping("viewMine.do")
	public ModelAndView viewMine(int bno, HttpSession session) 
			throws Exception {
		
		//조회수 증가 처리
		screenshotService.increateViewcnt(bno, session);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("screenshot/view");//포워딩할 뷰의 이름
		mav.addObject("dto", screenshotService.read(bno)); //자료 저장
		return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//배그
	@RequestMapping("listBtg.do") //�꽭遺��쟻�씤 url pattern
	public ModelAndView listBtg(
			@RequestParam(defaultValue = "name") String search_option,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue="1") int curPage) 
			throws Exception {
				
		//�젅肄붾뱶 媛��닔 怨꾩궛
		int count=screenshotService.countArticleBtg(search_option,keyword);
		//�럹�씠吏� 愿��젴 �꽕�젙
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<ScreenshotDTO> list=screenshotService.listBtg(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
		ModelAndView mav=new ModelAndView();
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", list); //map�뿉 �옄猷� ���옣
		map.put("count", count);
		map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		mav.setViewName("screenshot/listBtg"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
		mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
		return mav; 
	}//list2()
	
	

	@RequestMapping("writeBtg.do")
	public String write1() {
		//글쓰기 폼 페이지로 이동
		return "screenshot/writeBtg";
	}//write()
		
	@RequestMapping("insertBtg.do")
	public String insertBtg(@ModelAttribute ScreenshotDTO dto, 
			
			HttpSession session) throws Exception {
		//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
		String writer=(String)session.getAttribute("userid");
		//<input name="userid" id="userid">
		dto.setWriter(writer);
		//레코드 저장
		screenshotService.create(dto);
		//게시물 목록으로 이동
		return "redirect:/screenshot/listBtg.do";
	}//insert()
	@RequestMapping("viewBtg.do")
	public ModelAndView viewBtg(int bno, HttpSession session) 
			throws Exception {
		
		//조회수 증가 처리
		screenshotService.increateViewcnt(bno, session);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("screenshot/viewBtg");//포워딩할 뷰의 이름
		mav.addObject("dto", screenshotService.read(bno)); //자료 저장
		return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
	}
	@RequestMapping("deleteBtg.do")
	public String deleteBtg(int bno) throws Exception{
		screenshotService.delete(bno);
		return "redirect:/screenshot/listBtg.do";//목록으로 이동
	}
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("listSud.do") //�꽭遺��쟻�씤 url pattern
	public ModelAndView listSud(
			@RequestParam(defaultValue = "name") String search_option,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue="1") int curPage) 
			throws Exception {
				
		//�젅肄붾뱶 媛��닔 怨꾩궛
		int count=screenshotService.countArticleSud(search_option,keyword);
		//�럹�씠吏� 愿��젴 �꽕�젙
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<ScreenshotDTO> list=screenshotService.listSud(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
		ModelAndView mav=new ModelAndView();
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", list); //map�뿉 �옄猷� ���옣
		map.put("count", count);
		map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		mav.setViewName("screenshot/listSud"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
		mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
		return mav; 
	}//list2()
	
	

	@RequestMapping("writeSud.do")
	public String writeSud() {
		//글쓰기 폼 페이지로 이동
		return "screenshot/writeSud";
	}//write()
		
	@RequestMapping("insertSud.do")
	public String insertSud(@ModelAttribute ScreenshotDTO dto, 
			
			HttpSession session) throws Exception {
		//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
		String writer=(String)session.getAttribute("userid");
		//<input name="userid" id="userid">
		dto.setWriter(writer);
		//레코드 저장
		screenshotService.create(dto);
		//게시물 목록으로 이동
		return "redirect:/screenshot/listSud.do";
	}//insert()
	@RequestMapping("viewSud.do")
	public ModelAndView viewSud(int bno, HttpSession session) 
			throws Exception {
		
		//조회수 증가 처리
		screenshotService.increateViewcnt(bno, session);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("screenshot/viewSud");//포워딩할 뷰의 이름
		mav.addObject("dto", screenshotService.read(bno)); //자료 저장
		return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
	}
	@RequestMapping("deleteSud.do")
	public String deleteSud(int bno) throws Exception{
		screenshotService.delete(bno);
		return "redirect:/screenshot/listSud.do";//목록으로 이동
	}
	
	//오버워치
	
		@RequestMapping("listOve.do") //�꽭遺��쟻�씤 url pattern
		public ModelAndView listOve(
				@RequestParam(defaultValue = "name") String search_option,
				@RequestParam(defaultValue = "") String keyword,
				@RequestParam(defaultValue="1") int curPage) 
				throws Exception {
					
			//�젅肄붾뱶 媛��닔 怨꾩궛
			int count=screenshotService.countArticleOve(search_option,keyword);
			//�럹�씠吏� 愿��젴 �꽕�젙
			Pager pager=new Pager(count, curPage);
			int start=pager.getPageBegin();
			int end=pager.getPageEnd();
			
			List<ScreenshotDTO> list=screenshotService.listOve(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
			ModelAndView mav=new ModelAndView();
			HashMap<String, Object> map=new HashMap<>();
			map.put("list", list); //map�뿉 �옄猷� ���옣
			map.put("count", count);
			map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
			map.put("search_option", search_option);
			map.put("keyword", keyword);
			mav.setViewName("screenshot/listOve"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
			mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
			return mav; 
		}//list2()
		
		

		@RequestMapping("writeOve.do")
		public String writeOve() {
			//글쓰기 폼 페이지로 이동
			return "screenshot/writeOve";
		}//write()
			
		@RequestMapping("insertOve.do")
		public String insertOve(@ModelAttribute ScreenshotDTO dto, 
				
				HttpSession session) throws Exception {
			//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
			String writer=(String)session.getAttribute("userid");
			//<input name="userid" id="userid">
			dto.setWriter(writer);
			//레코드 저장
			screenshotService.create(dto);
			//게시물 목록으로 이동
			return "redirect:/screenshot/listOve.do";
		}//insert()
		@RequestMapping("viewOve.do")
		public ModelAndView viewOve(int bno, HttpSession session) 
				throws Exception {
			
			//조회수 증가 처리
			screenshotService.increateViewcnt(bno, session);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("screenshot/viewOve");//포워딩할 뷰의 이름
			mav.addObject("dto", screenshotService.read(bno)); //자료 저장
			return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
		}
		@RequestMapping("deleteOve.do")
		public String deleteOve(int bno) throws Exception{
			screenshotService.delete(bno);
			return "redirect:/screenshot/listOve.do";//목록으로 이동
		}
		
		
		
		
		//와우
		
		@RequestMapping("listWow.do") //�꽭遺��쟻�씤 url pattern
		public ModelAndView listWow(
				@RequestParam(defaultValue = "name") String search_option,
				@RequestParam(defaultValue = "") String keyword,
				@RequestParam(defaultValue="1") int curPage) 
				throws Exception {
					
			//�젅肄붾뱶 媛��닔 怨꾩궛
			int count=screenshotService.countArticleWow(search_option,keyword);
			//�럹�씠吏� 愿��젴 �꽕�젙
			Pager pager=new Pager(count, curPage);
			int start=pager.getPageBegin();
			int end=pager.getPageEnd();
			
			List<ScreenshotDTO> list=screenshotService.listWow(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
			ModelAndView mav=new ModelAndView();
			HashMap<String, Object> map=new HashMap<>();
			map.put("list", list); //map�뿉 �옄猷� ���옣
			map.put("count", count);
			map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
			map.put("search_option", search_option);
			map.put("keyword", keyword);
			mav.setViewName("screenshot/listWow"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
			mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
			return mav; 
		}//list2()
		
		

		@RequestMapping("writeWow.do")
		public String writeWow() {
			//글쓰기 폼 페이지로 이동
			return "screenshot/writeWow";
		}//write()
			
		@RequestMapping("insertWow.do")
		public String insertWow(@ModelAttribute ScreenshotDTO dto, 
				
				HttpSession session) throws Exception {
			//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
			String writer=(String)session.getAttribute("userid");
			//<input name="userid" id="userid">
			dto.setWriter(writer);
			//레코드 저장
			screenshotService.create(dto);
			//게시물 목록으로 이동
			return "redirect:/screenshot/listWow.do";
		}//insert()
		@RequestMapping("viewWow.do")
		public ModelAndView viewWow(int bno, HttpSession session) 
				throws Exception {
			
			//조회수 증가 처리
			screenshotService.increateViewcnt(bno, session);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("screenshot/viewWow");//포워딩할 뷰의 이름
			mav.addObject("dto", screenshotService.read(bno)); //자료 저장
			return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
		}
		@RequestMapping("deleteWow.do")
		public String deleteWow(int bno) throws Exception{
			screenshotService.delete(bno);
			return "redirect:/screenshot/listWow.do";//목록으로 이동
		}
	
		
		
		
		
		//로스트아크
		
		@RequestMapping("listLoa.do") //�꽭遺��쟻�씤 url pattern
		public ModelAndView listLoa(
				@RequestParam(defaultValue = "name") String search_option,
				@RequestParam(defaultValue = "") String keyword,
				@RequestParam(defaultValue="1") int curPage) 
				throws Exception {
					
			//�젅肄붾뱶 媛��닔 怨꾩궛
			int count=screenshotService.countArticleLoa(search_option,keyword);
			//�럹�씠吏� 愿��젴 �꽕�젙
			Pager pager=new Pager(count, curPage);
			int start=pager.getPageBegin();
			int end=pager.getPageEnd();
			
			List<ScreenshotDTO> list=screenshotService.listLoa(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
			ModelAndView mav=new ModelAndView();
			HashMap<String, Object> map=new HashMap<>();
			map.put("list", list); //map�뿉 �옄猷� ���옣
			map.put("count", count);
			map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
			map.put("search_option", search_option);
			map.put("keyword", keyword);
			mav.setViewName("screenshot/listLoa"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
			mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
			return mav; 
		}//list2()
		
		

		@RequestMapping("writeLoa.do")
		public String writeLoa() {
			//글쓰기 폼 페이지로 이동
			return "screenshot/writeLoa";
		}//write()
			
		@RequestMapping("insertLoa.do")
		public String insertLoa(@ModelAttribute ScreenshotDTO dto, 
				
				HttpSession session) throws Exception {
			//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
			String writer=(String)session.getAttribute("userid");
			//<input name="userid" id="userid">
			dto.setWriter(writer);
			//레코드 저장
			screenshotService.create(dto);
			//게시물 목록으로 이동
			return "redirect:/screenshot/listLoa.do";
		}//insert()
		@RequestMapping("viewLoa.do")
		public ModelAndView viewLoa(int bno, HttpSession session) 
				throws Exception {
			
			//조회수 증가 처리
			screenshotService.increateViewcnt(bno, session);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("screenshot/viewLoa");//포워딩할 뷰의 이름
			mav.addObject("dto", screenshotService.read(bno)); //자료 저장
			return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
		}
		@RequestMapping("deleteLoa.do")
		public String deleteLoa(int bno) throws Exception{
			screenshotService.delete(bno);
			return "redirect:/screenshot/listLoa.do";//목록으로 이동
		}
	
	
		
		
		//메이플		
		@RequestMapping("listMps.do") //�꽭遺��쟻�씤 url pattern
		public ModelAndView listMps(
				@RequestParam(defaultValue = "name") String search_option,
				@RequestParam(defaultValue = "") String keyword,
				@RequestParam(defaultValue="1") int curPage) 
				throws Exception {
					
			//�젅肄붾뱶 媛��닔 怨꾩궛
			int count=screenshotService.countArticleMps(search_option,keyword);
			//�럹�씠吏� 愿��젴 �꽕�젙
			Pager pager=new Pager(count, curPage);
			int start=pager.getPageBegin();
			int end=pager.getPageEnd();
			
			List<ScreenshotDTO> list=screenshotService.listMps(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
			ModelAndView mav=new ModelAndView();
			HashMap<String, Object> map=new HashMap<>();
			map.put("list", list); //map�뿉 �옄猷� ���옣
			map.put("count", count);
			map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
			map.put("search_option", search_option);
			map.put("keyword", keyword);
			mav.setViewName("screenshot/listMps"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
			mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
			return mav; 
		}//list2()
		
		@RequestMapping("writeMps.do")
		public String writeMps() {
			//글쓰기 폼 페이지로 이동
			return "screenshot/writeMps";
		}//write()
			
		@RequestMapping("insertMps.do")
		public String insertMps(@ModelAttribute ScreenshotDTO dto, 
				
				HttpSession session) throws Exception {
			//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
			String writer=(String)session.getAttribute("userid");
			//<input name="userid" id="userid">
			dto.setWriter(writer);
			//레코드 저장
			screenshotService.create(dto);
			//게시물 목록으로 이동
			return "redirect:/screenshot/listMps.do";
		}//insert()
		@RequestMapping("viewMps.do")
		public ModelAndView viewMps(int bno, HttpSession session) 
				throws Exception {
			
			//조회수 증가 처리
			screenshotService.increateViewcnt(bno, session);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("screenshot/viewMps");//포워딩할 뷰의 이름
			mav.addObject("dto", screenshotService.read(bno)); //자료 저장
			return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
		}
		@RequestMapping("deleteMps.do")
		public String deleteMps(int bno) throws Exception{
			screenshotService.delete(bno);
			return "redirect:/screenshot/listMps.do";//목록으로 이동
		}
	
	
	//리그오브레전드
		@RequestMapping("listLol.do") //�꽭遺��쟻�씤 url pattern
		public ModelAndView listLol(
				@RequestParam(defaultValue = "name") String search_option,
				@RequestParam(defaultValue = "") String keyword,
				@RequestParam(defaultValue="1") int curPage) 
				throws Exception {
					
			//�젅肄붾뱶 媛��닔 怨꾩궛
			int count=screenshotService.countArticleLol(search_option,keyword);
			//�럹�씠吏� 愿��젴 �꽕�젙
			Pager pager=new Pager(count, curPage);
			int start=pager.getPageBegin();
			int end=pager.getPageEnd();
			
			List<ScreenshotDTO> list=screenshotService.listLol(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
			ModelAndView mav=new ModelAndView();
			HashMap<String, Object> map=new HashMap<>();
			map.put("list", list); //map�뿉 �옄猷� ���옣
			map.put("count", count);
			map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
			map.put("search_option", search_option);
			map.put("keyword", keyword);
			mav.setViewName("screenshot/listLol"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
			mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
			return mav; 
		}//list2()
		
		@RequestMapping("writeLol.do")
		public String writeLol() {
			//글쓰기 폼 페이지로 이동
			return "screenshot/writeLol";
		}//write()
			
		@RequestMapping("insertLol.do")
		public String insertLol(@ModelAttribute ScreenshotDTO dto, 
				
				HttpSession session) throws Exception {
			//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
			String writer=(String)session.getAttribute("userid");
			//<input name="userid" id="userid">
			dto.setWriter(writer);
			//레코드 저장
			screenshotService.create(dto);
			//게시물 목록으로 이동
			return "redirect:/screenshot/listLol.do";
		}//insert()
		@RequestMapping("viewLol.do")
		public ModelAndView viewLol(int bno, HttpSession session) 
				throws Exception {
			
			//조회수 증가 처리
			screenshotService.increateViewcnt(bno, session);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("screenshot/viewLol");//포워딩할 뷰의 이름
			mav.addObject("dto", screenshotService.read(bno)); //자료 저장
			return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
		}
		@RequestMapping("deleteLol.do")
		public String deleteLol(int bno) throws Exception{
			screenshotService.delete(bno);
			return "redirect:/screenshot/listLol.do";//목록으로 이동
		}
	
		//도타2
		@RequestMapping("listDot.do") //�꽭遺��쟻�씤 url pattern
		public ModelAndView listDot(
				@RequestParam(defaultValue = "name") String search_option,
				@RequestParam(defaultValue = "") String keyword,
				@RequestParam(defaultValue="1") int curPage) 
				throws Exception {
					
			//�젅肄붾뱶 媛��닔 怨꾩궛
			int count=screenshotService.countArticleDot(search_option,keyword);
			//�럹�씠吏� 愿��젴 �꽕�젙
			Pager pager=new Pager(count, curPage);
			int start=pager.getPageBegin();
			int end=pager.getPageEnd();
			
			List<ScreenshotDTO> list=screenshotService.listDot(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
			ModelAndView mav=new ModelAndView();
			HashMap<String, Object> map=new HashMap<>();
			map.put("list", list); //map�뿉 �옄猷� ���옣
			map.put("count", count);
			map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
			map.put("search_option", search_option);
			map.put("keyword", keyword);
			mav.setViewName("screenshot/listDot"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
			mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
			return mav; 
		}//list2()
		
		@RequestMapping("writeDot.do")
		public String writeDot() {
			//글쓰기 폼 페이지로 이동
			return "screenshot/writeDot";
		}//write()
			
		@RequestMapping("insertDot.do")
		public String insertDot(@ModelAttribute ScreenshotDTO dto, 
				
				HttpSession session) throws Exception {
			//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
			String writer=(String)session.getAttribute("userid");
			//<input name="userid" id="userid">
			dto.setWriter(writer);
			//레코드 저장
			screenshotService.create(dto);
			//게시물 목록으로 이동
			return "redirect:/screenshot/listDot.do";
		}//insert()
		@RequestMapping("viewDot.do")
		public ModelAndView viewDot(int bno, HttpSession session) 
				throws Exception {
			
			//조회수 증가 처리
			screenshotService.increateViewcnt(bno, session);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("screenshot/viewDot");//포워딩할 뷰의 이름
			mav.addObject("dto", screenshotService.read(bno)); //자료 저장
			return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
		}
		@RequestMapping("deleteDot.do")
		public String deleteDot(int bno) throws Exception{
			screenshotService.delete(bno);
			return "redirect:/screenshot/listDot.do";//목록으로 이동
		}
	
		//히오스
		@RequestMapping("listHos.do") //�꽭遺��쟻�씤 url pattern
		public ModelAndView listHos(
				@RequestParam(defaultValue = "name") String search_option,
				@RequestParam(defaultValue = "") String keyword,
				@RequestParam(defaultValue="1") int curPage) 
				throws Exception {
					
			//�젅肄붾뱶 媛��닔 怨꾩궛
			int count=screenshotService.countArticleHos(search_option,keyword);
			//�럹�씠吏� 愿��젴 �꽕�젙
			Pager pager=new Pager(count, curPage);
			int start=pager.getPageBegin();
			int end=pager.getPageEnd();
			
			List<ScreenshotDTO> list=screenshotService.listHos(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
			ModelAndView mav=new ModelAndView();
			HashMap<String, Object> map=new HashMap<>();
			map.put("list", list); //map�뿉 �옄猷� ���옣
			map.put("count", count);
			map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
			map.put("search_option", search_option);
			map.put("keyword", keyword);
			mav.setViewName("screenshot/listHos"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
			mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
			return mav; 
		}//list2()
		
		@RequestMapping("writeHos.do")
		public String writeHos() {
			//글쓰기 폼 페이지로 이동
			return "screenshot/writeHos";
		}//write()
			
		@RequestMapping("insertHos.do")
		public String insertHos(@ModelAttribute ScreenshotDTO dto, 
				
				HttpSession session) throws Exception {
			//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
			String writer=(String)session.getAttribute("userid");
			//<input name="userid" id="userid">
			dto.setWriter(writer);
			//레코드 저장
			screenshotService.create(dto);
			//게시물 목록으로 이동
			return "redirect:/screenshot/listHos.do";
		}//insert()
		@RequestMapping("viewHos.do")
		public ModelAndView viewHos(int bno, HttpSession session) 
				throws Exception {
			
			//조회수 증가 처리
			screenshotService.increateViewcnt(bno, session);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("screenshot/viewHos");//포워딩할 뷰의 이름
			mav.addObject("dto", screenshotService.read(bno)); //자료 저장
			return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
		}
		@RequestMapping("deleteHos.do")
		public String deleteHos(int bno) throws Exception{
			screenshotService.delete(bno);
			return "redirect:/screenshot/listHos.do";//목록으로 이동
		}
	
		//스타
		@RequestMapping("listSta.do") //�꽭遺��쟻�씤 url pattern
		public ModelAndView listSta(
				@RequestParam(defaultValue = "name") String search_option,
				@RequestParam(defaultValue = "") String keyword,
				@RequestParam(defaultValue="1") int curPage) 
				throws Exception {
					
			//�젅肄붾뱶 媛��닔 怨꾩궛
			int count=screenshotService.countArticleSta(search_option,keyword);
			//�럹�씠吏� 愿��젴 �꽕�젙
			Pager pager=new Pager(count, curPage);
			int start=pager.getPageBegin();
			int end=pager.getPageEnd();
			
			List<ScreenshotDTO> list=screenshotService.listSta(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
			ModelAndView mav=new ModelAndView();
			HashMap<String, Object> map=new HashMap<>();
			map.put("list", list); //map�뿉 �옄猷� ���옣
			map.put("count", count);
			map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
			map.put("search_option", search_option);
			map.put("keyword", keyword);
			mav.setViewName("screenshot/listSta"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
			mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
			return mav; 
		}//list2()
		
		@RequestMapping("writeSta.do")
		public String writeSta() {
			//글쓰기 폼 페이지로 이동
			return "screenshot/writeSta";
		}//write()
			
		@RequestMapping("insertSta.do")
		public String insertSta(@ModelAttribute ScreenshotDTO dto, 
				
				HttpSession session) throws Exception {
			//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
			String writer=(String)session.getAttribute("userid");
			//<input name="userid" id="userid">
			dto.setWriter(writer);
			//레코드 저장
			screenshotService.create(dto);
			//게시물 목록으로 이동
			return "redirect:/screenshot/listSta.do";
		}//insert()
		@RequestMapping("viewSta.do")
		public ModelAndView viewSta(int bno, HttpSession session) 
				throws Exception {
			
			//조회수 증가 처리
			screenshotService.increateViewcnt(bno, session);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("screenshot/viewSta");//포워딩할 뷰의 이름
			mav.addObject("dto", screenshotService.read(bno)); //자료 저장
			return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
		}
		@RequestMapping("deleteSta.do")
		public String deleteSta(int bno) throws Exception{
			screenshotService.delete(bno);
			return "redirect:/screenshot/listSta.do";//목록으로 이동
		}
	
		
		
		//마크
		@RequestMapping("listMic.do") //�꽭遺��쟻�씤 url pattern
		public ModelAndView listMic(
				@RequestParam(defaultValue = "name") String search_option,
				@RequestParam(defaultValue = "") String keyword,
				@RequestParam(defaultValue="1") int curPage) 
				throws Exception {
					
			//�젅肄붾뱶 媛��닔 怨꾩궛
			int count=screenshotService.countArticleMic(search_option,keyword);
			//�럹�씠吏� 愿��젴 �꽕�젙
			Pager pager=new Pager(count, curPage);
			int start=pager.getPageBegin();
			int end=pager.getPageEnd();
			
			List<ScreenshotDTO> list=screenshotService.listMic(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
			ModelAndView mav=new ModelAndView();
			HashMap<String, Object> map=new HashMap<>();
			map.put("list", list); //map�뿉 �옄猷� ���옣
			map.put("count", count);
			map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
			map.put("search_option", search_option);
			map.put("keyword", keyword);
			mav.setViewName("screenshot/listMic"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
			mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
			return mav; 
		}//list2()
		
		@RequestMapping("writeMic.do")
		public String writeMic() {
			//글쓰기 폼 페이지로 이동
			return "screenshot/writeMic";
		}//write()
			
		@RequestMapping("insertMic.do")
		public String insertMic(@ModelAttribute ScreenshotDTO dto, 
				
				HttpSession session) throws Exception {
			//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
			String writer=(String)session.getAttribute("userid");
			//<input name="userid" id="userid">
			dto.setWriter(writer);
			//레코드 저장
			screenshotService.create(dto);
			//게시물 목록으로 이동
			return "redirect:/screenshot/listMic.do";
		}//insert()
		@RequestMapping("viewMic.do")
		public ModelAndView viewMic(int bno, HttpSession session) 
				throws Exception {
			
			//조회수 증가 처리
			screenshotService.increateViewcnt(bno, session);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("screenshot/viewMic");//포워딩할 뷰의 이름
			mav.addObject("dto", screenshotService.read(bno)); //자료 저장
			return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
		}
		@RequestMapping("deleteMic.do")
		public String deleteMic(int bno) throws Exception{
			screenshotService.delete(bno);
			return "redirect:/screenshot/listMic.do";//목록으로 이동
		}
	
	
		//문명
		@RequestMapping("listCiv.do") //�꽭遺��쟻�씤 url pattern
		public ModelAndView listCiv(
				@RequestParam(defaultValue = "name") String search_option,
				@RequestParam(defaultValue = "") String keyword,
				@RequestParam(defaultValue="1") int curPage) 
				throws Exception {
					
			//�젅肄붾뱶 媛��닔 怨꾩궛
			int count=screenshotService.countArticleCiv(search_option,keyword);
			//�럹�씠吏� 愿��젴 �꽕�젙
			Pager pager=new Pager(count, curPage);
			int start=pager.getPageBegin();
			int end=pager.getPageEnd();
			
			List<ScreenshotDTO> list=screenshotService.listCiv(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
			ModelAndView mav=new ModelAndView();
			HashMap<String, Object> map=new HashMap<>();
			map.put("list", list); //map�뿉 �옄猷� ���옣
			map.put("count", count);
			map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
			map.put("search_option", search_option);
			map.put("keyword", keyword);
			mav.setViewName("screenshot/listCiv"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
			mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
			return mav; 
		}//list2()
		
		@RequestMapping("writeCiv.do")
		public String writeCiv() {
			//글쓰기 폼 페이지로 이동
			return "screenshot/writeCiv";
		}//write()
			
		@RequestMapping("insertCiv.do")
		public String insertCiv(@ModelAttribute ScreenshotDTO dto, 
				
				HttpSession session) throws Exception {
			//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
			String writer=(String)session.getAttribute("userid");
			//<input name="userid" id="userid">
			dto.setWriter(writer);
			//레코드 저장
			screenshotService.create(dto);
			//게시물 목록으로 이동
			return "redirect:/screenshot/listCiv.do";
		}//insert()
		@RequestMapping("viewCiv.do")
		public ModelAndView viewCiv(int bno, HttpSession session) 
				throws Exception {
			
			//조회수 증가 처리
			screenshotService.increateViewcnt(bno, session);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("screenshot/viewCiv");//포워딩할 뷰의 이름
			mav.addObject("dto", screenshotService.read(bno)); //자료 저장
			return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
		}
		@RequestMapping("deleteCiv.do")
		public String deleteCiv(int bno) throws Exception{
			screenshotService.delete(bno);
			return "redirect:/screenshot/listCiv.do";//목록으로 이동
		}
	
	
	
		//피파
		@RequestMapping("listFif.do") //�꽭遺��쟻�씤 url pattern
		public ModelAndView listFif(
				@RequestParam(defaultValue = "name") String search_option,
				@RequestParam(defaultValue = "") String keyword,
				@RequestParam(defaultValue="1") int curPage) 
				throws Exception {
					
			//�젅肄붾뱶 媛��닔 怨꾩궛
			int count=screenshotService.countArticleFif(search_option,keyword);
			//�럹�씠吏� 愿��젴 �꽕�젙
			Pager pager=new Pager(count, curPage);
			int start=pager.getPageBegin();
			int end=pager.getPageEnd();
			
			List<ScreenshotDTO> list=screenshotService.listFif(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
			ModelAndView mav=new ModelAndView();
			HashMap<String, Object> map=new HashMap<>();
			map.put("list", list); //map�뿉 �옄猷� ���옣
			map.put("count", count);
			map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
			map.put("search_option", search_option);
			map.put("keyword", keyword);
			mav.setViewName("screenshot/listFif"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
			mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
			return mav; 
		}//list2()
		
		@RequestMapping("writeFif.do")
		public String writeFif() {
			//글쓰기 폼 페이지로 이동
			return "screenshot/writeFif";
		}//write()
			
		@RequestMapping("insertFif.do")
		public String insertFif(@ModelAttribute ScreenshotDTO dto, 
				
				HttpSession session) throws Exception {
			//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
			String writer=(String)session.getAttribute("userid");
			//<input name="userid" id="userid">
			dto.setWriter(writer);
			//레코드 저장
			screenshotService.create(dto);
			//게시물 목록으로 이동
			return "redirect:/screenshot/listFif.do";
		}//insert()
		@RequestMapping("viewFif.do")
		public ModelAndView viewFif(int bno, HttpSession session) 
				throws Exception {
			
			//조회수 증가 처리
			screenshotService.increateViewcnt(bno, session);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("screenshot/viewFif");//포워딩할 뷰의 이름
			mav.addObject("dto", screenshotService.read(bno)); //자료 저장
			return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
		}
		@RequestMapping("deleteFif.do")
		public String deleteFif(int bno) throws Exception{
			screenshotService.delete(bno);
			return "redirect:/screenshot/listFif.do";//목록으로 이동
		}
		
		
		//니드포
		@RequestMapping("listNfs.do") //�꽭遺��쟻�씤 url pattern
		public ModelAndView listNfs(
				@RequestParam(defaultValue = "name") String search_option,
				@RequestParam(defaultValue = "") String keyword,
				@RequestParam(defaultValue="1") int curPage) 
				throws Exception {
					
			//�젅肄붾뱶 媛��닔 怨꾩궛
			int count=screenshotService.countArticleNfs(search_option,keyword);
			//�럹�씠吏� 愿��젴 �꽕�젙
			Pager pager=new Pager(count, curPage);
			int start=pager.getPageBegin();
			int end=pager.getPageEnd();
			
			List<ScreenshotDTO> list=screenshotService.listNfs(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
			ModelAndView mav=new ModelAndView();
			HashMap<String, Object> map=new HashMap<>();
			map.put("list", list); //map�뿉 �옄猷� ���옣
			map.put("count", count);
			map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
			map.put("search_option", search_option);
			map.put("keyword", keyword);
			mav.setViewName("screenshot/listNfs"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
			mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
			return mav; 
		}//list2()
		
		@RequestMapping("writeNfs.do")
		public String writeNfs() {
			//글쓰기 폼 페이지로 이동
			return "screenshot/writeNfs";
		}//write()
			
		@RequestMapping("insertNfs.do")
		public String insertNfs(@ModelAttribute ScreenshotDTO dto, 
				
				HttpSession session) throws Exception {
			//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
			String writer=(String)session.getAttribute("userid");
			//<input name="userid" id="userid">
			dto.setWriter(writer);
			//레코드 저장
			screenshotService.create(dto);
			//게시물 목록으로 이동
			return "redirect:/screenshot/listNfs.do";
		}//insert()
		@RequestMapping("viewNfs.do")
		public ModelAndView viewNfs(int bno, HttpSession session) 
				throws Exception {
			
			//조회수 증가 처리
			screenshotService.increateViewcnt(bno, session);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("screenshot/viewNfs");//포워딩할 뷰의 이름
			mav.addObject("dto", screenshotService.read(bno)); //자료 저장
			return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
		}
		@RequestMapping("deleteNfs.do")
		public String deleteNfs(int bno) throws Exception{
			screenshotService.delete(bno);
			return "redirect:/screenshot/listNfs.do";//목록으로 이동
		}
		
		
		//위닝
		@RequestMapping("listWin.do") //�꽭遺��쟻�씤 url pattern
		public ModelAndView listWin(
				@RequestParam(defaultValue = "name") String search_option,
				@RequestParam(defaultValue = "") String keyword,
				@RequestParam(defaultValue="1") int curPage) 
				throws Exception {
					
			//�젅肄붾뱶 媛��닔 怨꾩궛
			int count=screenshotService.countArticleWin(search_option,keyword);
			//�럹�씠吏� 愿��젴 �꽕�젙
			Pager pager=new Pager(count, curPage);
			int start=pager.getPageBegin();
			int end=pager.getPageEnd();
			
			List<ScreenshotDTO> list=screenshotService.listWin(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
			ModelAndView mav=new ModelAndView();
			HashMap<String, Object> map=new HashMap<>();
			map.put("list", list); //map�뿉 �옄猷� ���옣
			map.put("count", count);
			map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
			map.put("search_option", search_option);
			map.put("keyword", keyword);
			mav.setViewName("screenshot/listWin"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
			mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
			return mav; 
		}//list2()
		
		@RequestMapping("writeWin.do")
		public String writeWin() {
			//글쓰기 폼 페이지로 이동
			return "screenshot/writeWin";
		}//write()
			
		@RequestMapping("insertWin.do")
		public String insertWin(@ModelAttribute ScreenshotDTO dto, 
				
				HttpSession session) throws Exception {
			//이름이 없기때문에 대신 세션에서 사용자의 아이디를 가져옴
			String writer=(String)session.getAttribute("userid");
			//<input name="userid" id="userid">
			dto.setWriter(writer);
			//레코드 저장
			screenshotService.create(dto);
			//게시물 목록으로 이동
			return "redirect:/screenshot/listWin.do";
		}//insert()
		@RequestMapping("viewWin.do")
		public ModelAndView viewWin(int bno, HttpSession session) 
				throws Exception {
			
			//조회수 증가 처리
			screenshotService.increateViewcnt(bno, session);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("screenshot/viewWin");//포워딩할 뷰의 이름
			mav.addObject("dto", screenshotService.read(bno)); //자료 저장
			return mav; //view/screenshot/view.jsp로 넘어가서 출력됨
		}
		@RequestMapping("deleteWin.do")
		public String deleteWin(int bno) throws Exception{
			screenshotService.delete(bno);
			return "redirect:/screenshot/listWin.do";//목록으로 이동
		}
		
		
		


	
	
	
	//첨부파일 목록을 리턴
	//ArrayList를 json 배열로 변환하여 리턴
	@RequestMapping("getUpload/{bno}")
	@ResponseBody //view가 아닌 List<String>데이터 자체를 리턴
	public List<String> getUpload(@PathVariable int bno){
		return screenshotService.getUpload(bno);
	}
	
	//게시물 내용 수정
	@RequestMapping("update.do")
	public String update(ScreenshotDTO dto) throws Exception {
		System.out.println("dto:"+dto);
		if(dto != null) {
			screenshotService.update(dto);
		}
		//수정 후 상세 화면으로 되돌아감
		return "redirect:/screenshot/view.do?bno="+dto.getBno();
	}
	
	@RequestMapping("delete.do")
	public String delete(int bno) throws Exception{
		screenshotService.delete(bno);
		return "redirect:/screenshot/list.do";//목록으로 이동
	}
	
	
	
	

	

}
