package com.example.teamProject.controller.btg;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.teamProject.model.btg.dto.BtgReplyDTO;
import com.example.teamProject.service.btg.BtgReplyService;

@RestController //@ResponseBody를 붙이지 않아도 뷰가 아닌 데이터 리턴 가능
//spring 4.0부터 사용 가능
@RequestMapping("reply_btg/*")
public class BtgReplyController {
	@Inject
	BtgReplyService replyService;
	
	@RequestMapping("insert.do")
	public void insert(BtgReplyDTO dto, HttpSession session) {
		//세션에 저장된 댓글 작성자 아이디를 가져와 처리
		String userid=(String)session.getAttribute("userid");
		dto.setReplyer(userid);
		//댓글이 테이블에 저장
		replyService.create(dto);
		//Ajax로 값만넘기고 끝나기때문에 jsp페이지로 가거나 데이터를
		//리턴하지 않음
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(int bno, ModelAndView mav) {
		List<BtgReplyDTO> list=replyService.list(bno);
		mav.setViewName("btg/reply_btg"); //뷰의 이름
		mav.addObject("list", list); //뷰에 전달할 데이터 저장
		return mav;//뷰로 이동
	}
	
	
	@RequestMapping("list_json.do")
	public List<BtgReplyDTO> list_json(int bno){
		return replyService.list(bno);
	}

}
