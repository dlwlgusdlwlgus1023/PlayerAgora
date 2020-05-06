package com.example.teamProject.controller.main;

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

import com.example.teamProject.model.main.dto.MainDTO;
import com.example.teamProject.service.main.Pager;
import com.example.teamProject.service.main.MainService;


@Controller //controller bean
@RequestMapping("main/*") //�⑤벏�꽰占쎌읅占쎌뵥 url pattern
public class MainController {
	@Inject
	MainService mainService;
	
	@RequestMapping("mainList.do") //占쎄쉭�겫占쏙옙�읅占쎌뵥 url pattern
	public ModelAndView mainList(
			@RequestParam(defaultValue = "name") String search_option,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue="1") int curPage) 
			throws Exception {
				
		
		List<MainDTO> list=mainService.listAll(search_option,keyword); //野껊슣�뻻�눧占� 筌뤴뫖以�
		ModelAndView mav=new ModelAndView();
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", list); //map占쎈퓠 占쎌쁽�뙴占� 占쏙옙占쎌삢
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		mav.setViewName("main/mainList"); //占쎈７占쎌뜖占쎈뎃占쎈막 �뀎怨쀬벥 占쎌뵠�뵳占�
		mav.addObject("map", map); //ModelAndView占쎈퓠 map占쎌뱽 占쏙옙占쎌삢
		return mav; 
	}//list()
	
	
	@RequestMapping("write.do")
	public String write1() {
		return "main/write";
	}//write()
	

	@RequestMapping("insert.do")
	public String insert(@ModelAttribute MainDTO dto, 
			HttpSession session) throws Exception {
		//占쎌뵠�뵳袁⑹뵠 占쎈씨疫꿸퀡釉ｈ눧紐꾨퓠 占쏙옙占쎈뻿 占쎄쉭占쎈�∽옙肉됵옙苑� 占쎄텢占쎌뒠占쎌쁽占쎌벥 占쎈툡占쎌뵠占쎈탵�몴占� 揶쏉옙占쎌죬占쎌긾
		String writer=(String)session.getAttribute("userid");
		//<input name="userid" id="userid">
		dto.setWriter(writer);
		//占쎌쟿�굜遺얜굡 占쏙옙占쎌삢
		mainService.create(dto);
		//野껊슣�뻻�눧占� 筌뤴뫖以됵옙�몵嚥∽옙 占쎌뵠占쎈짗
		return "redirect:/main/mainList.do";
	}//insert()
	
	
	@RequestMapping("view.do")
	public ModelAndView view(int bno, HttpSession session) 
			throws Exception {
		mainService.increateViewcnt(bno, session);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("main/view");
		mav.addObject("dto", mainService.read(bno));
		return mav; 
	}
	
	//筌ｂ뫀占쏙옙�솁占쎌뵬 筌뤴뫖以됵옙�뱽 �뵳�뗪쉘
	//ArrayList�몴占� json 獄쏄퀣肉닸에占� 癰귨옙占쎌넎占쎈릭占쎈연 �뵳�뗪쉘
	@RequestMapping("getAttach/{bno}")
	@ResponseBody //view揶쏉옙 占쎈툡占쎈빒 List<String>占쎈쑓占쎌뵠占쎄숲 占쎌쁽筌ｋ�占쏙옙 �뵳�뗪쉘
	public List<String> getAttach(@PathVariable int bno){
		return mainService.getAttach(bno);
	}
	
	//野껊슣�뻻�눧占� 占쎄땀占쎌뒠 占쎈땾占쎌젟
	@RequestMapping("update.do")
	public String update(MainDTO dto) throws Exception {
		System.out.println("dto:"+dto);
		if(dto != null) {
			mainService.update(dto);
		}
		//占쎈땾占쎌젟 占쎌뜎 占쎄맒占쎄쉭 占쎌넅筌롫똻�몵嚥∽옙 占쎈┷占쎈즼占쎈툡揶쏉옙
		return "redirect:/main/view.do?bno="+dto.getBno();
	}
	
	@RequestMapping("delete.do")
	public String delete(int bno) throws Exception{
		mainService.delete(bno);
		return "redirect:/main/mainList.do";//筌뤴뫖以됵옙�몵嚥∽옙 占쎌뵠占쎈짗
	}
	
	

}
