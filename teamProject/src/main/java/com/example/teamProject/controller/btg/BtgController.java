package com.example.teamProject.controller.btg;

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

import com.example.teamProject.model.btg.dto.BtgDTO;
import com.example.teamProject.service.btg.Pager;
import com.example.teamProject.service.btg.BtgService;


@Controller //controller bean
@RequestMapping("btg/*") //怨듯넻�쟻�씤 url pattern
public class BtgController {
	@Inject
	BtgService btgService;
	
	@RequestMapping("list1.do") //�꽭遺��쟻�씤 url pattern
	public ModelAndView list1(
			@RequestParam(defaultValue = "name") String search_option,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue="1") int curPage) 
			throws Exception {
				
		//�젅肄붾뱶 媛��닔 怨꾩궛
		int count=btgService.countArticle(search_option,keyword);
		//�럹�씠吏� 愿��젴 �꽕�젙
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<BtgDTO> list=btgService.listAll(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
		ModelAndView mav=new ModelAndView();
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", list); //map�뿉 �옄猷� ���옣
		map.put("count", count);
		map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		mav.setViewName("btg/list1"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
		mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
		return mav; 
	}//list()
	@RequestMapping("list2.do") //�꽭遺��쟻�씤 url pattern
	public ModelAndView list2(
			@RequestParam(defaultValue = "name") String search_option,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue="1") int curPage) 
			throws Exception {
				
		//�젅肄붾뱶 媛��닔 怨꾩궛
		int count=btgService.countArticle2(search_option,keyword);
		//�럹�씠吏� 愿��젴 �꽕�젙
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<BtgDTO> list2=btgService.listPath(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
		ModelAndView mav=new ModelAndView();
		HashMap<String, Object> map=new HashMap<>();
		map.put("list2", list2); //map�뿉 �옄猷� ���옣
		map.put("count", count);
		map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		mav.setViewName("btg/list2"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
		mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
		return mav; 
	}//list2()
	@RequestMapping("list3.do") //�꽭遺��쟻�씤 url pattern
	public ModelAndView list3(
			@RequestParam(defaultValue = "name") String search_option,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue="1") int curPage) 
			throws Exception {
				
		//�젅肄붾뱶 媛��닔 怨꾩궛
		int count=btgService.countArticle3(search_option,keyword);
		//�럹�씠吏� 愿��젴 �꽕�젙
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<BtgDTO> list3=btgService.listTip(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
		ModelAndView mav=new ModelAndView();
		HashMap<String, Object> map=new HashMap<>();
		map.put("list3", list3); //map�뿉 �옄猷� ���옣
		map.put("count", count);
		map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		mav.setViewName("btg/list3"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
		mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
		return mav; 
	}//list3()
	@RequestMapping("list4.do") //�꽭遺��쟻�씤 url pattern
	public ModelAndView list4(
			@RequestParam(defaultValue = "name") String search_option,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue="1") int curPage) 
			throws Exception {
				
		//�젅肄붾뱶 媛��닔 怨꾩궛
		int count=btgService.countArticle4(search_option,keyword);
		//�럹�씠吏� 愿��젴 �꽕�젙
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<BtgDTO> list4=btgService.listParty(search_option,keyword, start,end); //寃뚯떆臾� 紐⑸줉
		ModelAndView mav=new ModelAndView();
		HashMap<String, Object> map=new HashMap<>();
		map.put("list4", list4); //map�뿉 �옄猷� ���옣
		map.put("count", count);
		map.put("pager", pager); //�럹�씠吏� �꽕鍮꾧쾶�씠�뀡�쓣 �쐞�븳 蹂��닔
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		mav.setViewName("btg/list4"); //�룷�썙�뵫�븷 酉곗쓽 �씠由�
		mav.addObject("map", map); //ModelAndView�뿉 map�쓣 ���옣
		return mav; 
	}//list4()
	
	
	@RequestMapping("write.do")
	public String write1() {
		return "btg/write";
	}//write()
	@RequestMapping("write2.do")
	public String write2() {
		return "btg/write2";
	}//write2()
	@RequestMapping("write3.do")
	public String write3() {
		return "btg/write3";
	}//write3()
	@RequestMapping("write4.do")
	public String write4() {
		return "btg/write4";
	}//write4()

	@RequestMapping("insert.do")
	public String insert(@ModelAttribute BtgDTO dto, 
			HttpSession session) throws Exception {
		//�씠由꾩씠 �뾾湲곕븣臾몄뿉 ���떊 �꽭�뀡�뿉�꽌 �궗�슜�옄�쓽 �븘�씠�뵒瑜� 媛��졇�샂
		String writer=(String)session.getAttribute("userid");
		//<input name="userid" id="userid">
		dto.setWriter(writer);
		//�젅肄붾뱶 ���옣
		btgService.create(dto);
		//寃뚯떆臾� 紐⑸줉�쑝濡� �씠�룞
		return "redirect:/btg/list1.do";
	}//insert()
	
	
	@RequestMapping("view.do")
	public ModelAndView view(int bno, HttpSession session) 
			throws Exception {
		btgService.increateViewcnt(bno, session);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("btg/view");
		mav.addObject("dto", btgService.read(bno));
		return mav; 
	}
	
	//泥⑤��뙆�씪 紐⑸줉�쓣 由ы꽩
	//ArrayList瑜� json 諛곗뿴濡� 蹂��솚�븯�뿬 由ы꽩
	@RequestMapping("getAttach/{bno}")
	@ResponseBody //view媛� �븘�땶 List<String>�뜲�씠�꽣 �옄泥대�� 由ы꽩
	public List<String> getAttach(@PathVariable int bno){
		return btgService.getAttach(bno);
	}
	
	//寃뚯떆臾� �궡�슜 �닔�젙
	@RequestMapping("update.do")
	public String update(BtgDTO dto) throws Exception {
		System.out.println("dto:"+dto);
		if(dto != null) {
			btgService.update(dto);
		}
		//�닔�젙 �썑 �긽�꽭 �솕硫댁쑝濡� �릺�룎�븘媛�
		return "redirect:/btg/view.do?bno="+dto.getBno();
	}
	
	@RequestMapping("delete.do")
	public String delete(int bno) throws Exception{
		btgService.delete(bno);
		return "redirect:/btg/list1.do";//紐⑸줉�쑝濡� �씠�룞
	}
	
	

}
