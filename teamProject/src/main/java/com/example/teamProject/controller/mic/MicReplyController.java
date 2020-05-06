package com.example.teamProject.controller.mic;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.teamProject.model.mic.dto.MicReplyDTO;
import com.example.teamProject.service.mic.MicReplyService;

@RestController //@ResponseBody瑜� 遺숈씠吏� �븡�븘�룄 酉곌� �븘�땶 �뜲�씠�꽣 由ы꽩 媛��뒫
//spring 4.0遺��꽣 �궗�슜 媛��뒫
@RequestMapping("reply_mic/*")
public class MicReplyController {
	@Inject
	MicReplyService replyService;
	
	@RequestMapping("insert.do")
	public void insert(MicReplyDTO dto, HttpSession session) {
		//�꽭�뀡�뿉 ���옣�맂 �뙎湲� �옉�꽦�옄 �븘�씠�뵒瑜� 媛��졇�� 泥섎━
		String userid=(String)session.getAttribute("userid");
		dto.setReplyer(userid);
		//�뙎湲��씠 �뀒�씠釉붿뿉 ���옣
		replyService.create(dto);
		//Ajax濡� 媛믩쭔�꽆湲곌퀬 �걹�굹湲곕븣臾몄뿉 jsp�럹�씠吏�濡� 媛�嫄곕굹 �뜲�씠�꽣瑜�
		//由ы꽩�븯吏� �븡�쓬
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(int bno, ModelAndView mav) {
		List<MicReplyDTO> list=replyService.list(bno);
		mav.setViewName("mic/reply_mic"); //酉곗쓽 �씠由�
		mav.addObject("list", list); //酉곗뿉 �쟾�떖�븷 �뜲�씠�꽣 ���옣
		return mav;//酉곕줈 �씠�룞
	}
	
	
	@RequestMapping("list_json.do")
	public List<MicReplyDTO> list_json(int bno){
		return replyService.list(bno);
	}

}
