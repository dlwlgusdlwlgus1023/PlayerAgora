package com.example.teamProject.controller.hos;

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

import com.example.teamProject.model.hos.dto.HosDTO;
import com.example.teamProject.service.hos.Pager;
import com.example.teamProject.service.hos.HosService;


@Controller //controller bean
@RequestMapping("hos/*") //�⑤벏�꽰占쎌읅占쎌뵥 url pattern
public class HosController {
	@Inject
	HosService hosService;
	
	@RequestMapping("list1.do") //占쎄쉭�겫占쏙옙�읅占쎌뵥 url pattern
	public ModelAndView list1(
			@RequestParam(defaultValue = "name") String search_option,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue="1") int curPage) 
			throws Exception {
				
		//占쎌쟿�굜遺얜굡 揶쏉옙占쎈땾 �④쑴沅�
		int count=hosService.countArticle(search_option,keyword);
		//占쎈읂占쎌뵠筌욑옙 �꽴占쏙옙�졃 占쎄퐬占쎌젟
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<HosDTO> list=hosService.listAll(search_option,keyword, start,end); //野껊슣�뻻�눧占� 筌뤴뫖以�
		ModelAndView mav=new ModelAndView();
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", list); //map占쎈퓠 占쎌쁽�뙴占� 占쏙옙占쎌삢
		map.put("count", count);
		map.put("pager", pager); //占쎈읂占쎌뵠筌욑옙 占쎄퐬�뜮袁㏃쓺占쎌뵠占쎈�∽옙�뱽 占쎌맄占쎈립 癰귨옙占쎈땾
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		mav.setViewName("hos/list1"); //占쎈７占쎌뜖占쎈뎃占쎈막 �뀎怨쀬벥 占쎌뵠�뵳占�
		mav.addObject("map", map); //ModelAndView占쎈퓠 map占쎌뱽 占쏙옙占쎌삢
		return mav; 
	}//list()
	@RequestMapping("list2.do") //占쎄쉭�겫占쏙옙�읅占쎌뵥 url pattern
	public ModelAndView list2(
			@RequestParam(defaultValue = "name") String search_option,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue="1") int curPage) 
			throws Exception {
				
		//占쎌쟿�굜遺얜굡 揶쏉옙占쎈땾 �④쑴沅�
		int count=hosService.countArticle2(search_option,keyword);
		//占쎈읂占쎌뵠筌욑옙 �꽴占쏙옙�졃 占쎄퐬占쎌젟
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<HosDTO> list2=hosService.listPath(search_option,keyword, start,end); //野껊슣�뻻�눧占� 筌뤴뫖以�
		ModelAndView mav=new ModelAndView();
		HashMap<String, Object> map=new HashMap<>();
		map.put("list2", list2); //map占쎈퓠 占쎌쁽�뙴占� 占쏙옙占쎌삢
		map.put("count", count);
		map.put("pager", pager); //占쎈읂占쎌뵠筌욑옙 占쎄퐬�뜮袁㏃쓺占쎌뵠占쎈�∽옙�뱽 占쎌맄占쎈립 癰귨옙占쎈땾
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		mav.setViewName("hos/list2"); //占쎈７占쎌뜖占쎈뎃占쎈막 �뀎怨쀬벥 占쎌뵠�뵳占�
		mav.addObject("map", map); //ModelAndView占쎈퓠 map占쎌뱽 占쏙옙占쎌삢
		return mav; 
	}//list2()
	@RequestMapping("list3.do") //占쎄쉭�겫占쏙옙�읅占쎌뵥 url pattern
	public ModelAndView list3(
			@RequestParam(defaultValue = "name") String search_option,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue="1") int curPage) 
			throws Exception {
				
		//占쎌쟿�굜遺얜굡 揶쏉옙占쎈땾 �④쑴沅�
		int count=hosService.countArticle3(search_option,keyword);
		//占쎈읂占쎌뵠筌욑옙 �꽴占쏙옙�졃 占쎄퐬占쎌젟
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<HosDTO> list3=hosService.listTip(search_option,keyword, start,end); //野껊슣�뻻�눧占� 筌뤴뫖以�
		ModelAndView mav=new ModelAndView();
		HashMap<String, Object> map=new HashMap<>();
		map.put("list3", list3); //map占쎈퓠 占쎌쁽�뙴占� 占쏙옙占쎌삢
		map.put("count", count);
		map.put("pager", pager); //占쎈읂占쎌뵠筌욑옙 占쎄퐬�뜮袁㏃쓺占쎌뵠占쎈�∽옙�뱽 占쎌맄占쎈립 癰귨옙占쎈땾
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		mav.setViewName("hos/list3"); //占쎈７占쎌뜖占쎈뎃占쎈막 �뀎怨쀬벥 占쎌뵠�뵳占�
		mav.addObject("map", map); //ModelAndView占쎈퓠 map占쎌뱽 占쏙옙占쎌삢
		return mav; 
	}//list3()
	@RequestMapping("list4.do") //占쎄쉭�겫占쏙옙�읅占쎌뵥 url pattern
	public ModelAndView list4(
			@RequestParam(defaultValue = "name") String search_option,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue="1") int curPage) 
			throws Exception {
				
		//占쎌쟿�굜遺얜굡 揶쏉옙占쎈땾 �④쑴沅�
		int count=hosService.countArticle4(search_option,keyword);
		//占쎈읂占쎌뵠筌욑옙 �꽴占쏙옙�졃 占쎄퐬占쎌젟
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<HosDTO> list4=hosService.listParty(search_option,keyword, start,end); //野껊슣�뻻�눧占� 筌뤴뫖以�
		ModelAndView mav=new ModelAndView();
		HashMap<String, Object> map=new HashMap<>();
		map.put("list4", list4); //map占쎈퓠 占쎌쁽�뙴占� 占쏙옙占쎌삢
		map.put("count", count);
		map.put("pager", pager); //占쎈읂占쎌뵠筌욑옙 占쎄퐬�뜮袁㏃쓺占쎌뵠占쎈�∽옙�뱽 占쎌맄占쎈립 癰귨옙占쎈땾
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		mav.setViewName("hos/list4"); //占쎈７占쎌뜖占쎈뎃占쎈막 �뀎怨쀬벥 占쎌뵠�뵳占�
		mav.addObject("map", map); //ModelAndView占쎈퓠 map占쎌뱽 占쏙옙占쎌삢
		return mav; 
	}//list4()
	
	
	@RequestMapping("write.do")
	public String write1() {
		return "hos/write";
	}//write()
	@RequestMapping("write2.do")
	public String write2() {
		return "hos/write2";
	}//write2()
	@RequestMapping("write3.do")
	public String write3() {
		return "hos/write3";
	}//write3()
	@RequestMapping("write4.do")
	public String write4() {
		return "hos/write4";
	}//write4()

	@RequestMapping("insert.do")
	public String insert(@ModelAttribute HosDTO dto, 
			HttpSession session) throws Exception {
		//占쎌뵠�뵳袁⑹뵠 占쎈씨疫꿸퀡釉ｈ눧紐꾨퓠 占쏙옙占쎈뻿 占쎄쉭占쎈�∽옙肉됵옙苑� 占쎄텢占쎌뒠占쎌쁽占쎌벥 占쎈툡占쎌뵠占쎈탵�몴占� 揶쏉옙占쎌죬占쎌긾
		String writer=(String)session.getAttribute("userid");
		//<input name="userid" id="userid">
		dto.setWriter(writer);
		//占쎌쟿�굜遺얜굡 占쏙옙占쎌삢
		hosService.create(dto);
		//野껊슣�뻻�눧占� 筌뤴뫖以됵옙�몵嚥∽옙 占쎌뵠占쎈짗
		return "redirect:/hos/list1.do";
	}//insert()
	
	
	@RequestMapping("view.do")
	public ModelAndView view(int bno, HttpSession session) 
			throws Exception {
		hosService.increateViewcnt(bno, session);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("hos/view");
		mav.addObject("dto", hosService.read(bno));
		return mav; 
	}
	
	//筌ｂ뫀占쏙옙�솁占쎌뵬 筌뤴뫖以됵옙�뱽 �뵳�뗪쉘
	//ArrayList�몴占� json 獄쏄퀣肉닸에占� 癰귨옙占쎌넎占쎈릭占쎈연 �뵳�뗪쉘
	@RequestMapping("getAttach/{bno}")
	@ResponseBody //view揶쏉옙 占쎈툡占쎈빒 List<String>占쎈쑓占쎌뵠占쎄숲 占쎌쁽筌ｋ�占쏙옙 �뵳�뗪쉘
	public List<String> getAttach(@PathVariable int bno){
		return hosService.getAttach(bno);
	}
	
	//野껊슣�뻻�눧占� 占쎄땀占쎌뒠 占쎈땾占쎌젟
	@RequestMapping("update.do")
	public String update(HosDTO dto) throws Exception {
		System.out.println("dto:"+dto);
		if(dto != null) {
			hosService.update(dto);
		}
		//占쎈땾占쎌젟 占쎌뜎 占쎄맒占쎄쉭 占쎌넅筌롫똻�몵嚥∽옙 占쎈┷占쎈즼占쎈툡揶쏉옙
		return "redirect:/hos/view.do?bno="+dto.getBno();
	}
	
	@RequestMapping("delete.do")
	public String delete(int bno) throws Exception{
		hosService.delete(bno);
		return "redirect:/hos/list1.do";//筌뤴뫖以됵옙�몵嚥∽옙 占쎌뵠占쎈짗
	}
	
	

}
