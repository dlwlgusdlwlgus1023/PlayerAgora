package com.example.teamProject.controller.dot;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.teamProject.model.dot.dto.DotReplyDTO;
import com.example.teamProject.service.dot.DotReplyService;

@RestController //@ResponseBody�몴占� �겫�늿�뵠筌욑옙 占쎈륫占쎈툡占쎈즲 �뀎怨뚳옙 占쎈툡占쎈빒 占쎈쑓占쎌뵠占쎄숲 �뵳�뗪쉘 揶쏉옙占쎈뮟
//spring 4.0�겫占쏙옙苑� 占쎄텢占쎌뒠 揶쏉옙占쎈뮟
@RequestMapping("reply_dot/*")
public class DotReplyController {
	@Inject
	DotReplyService replyService;
	
	@RequestMapping("insert.do")
	public void insert(DotReplyDTO dto, HttpSession session) {
		//占쎄쉭占쎈�∽옙肉� 占쏙옙占쎌삢占쎈쭆 占쎈솊疫뀐옙 占쎌삂占쎄쉐占쎌쁽 占쎈툡占쎌뵠占쎈탵�몴占� 揶쏉옙占쎌죬占쏙옙 筌ｌ꼶�봺
		String userid=(String)session.getAttribute("userid");
		dto.setReplyer(userid);
		//占쎈솊疫뀐옙占쎌뵠 占쎈�믭옙�뵠�뇡遺용퓠 占쏙옙占쎌삢
		replyService.create(dto);
		//Ajax嚥∽옙 揶쏅�⑹춸占쎄퐜疫꿸퀗�� 占쎄국占쎄돌疫꿸퀡釉ｈ눧紐꾨퓠 jsp占쎈읂占쎌뵠筌욑옙嚥∽옙 揶쏉옙椰꾧퀡援� 占쎈쑓占쎌뵠占쎄숲�몴占�
		//�뵳�뗪쉘占쎈릭筌욑옙 占쎈륫占쎌벉
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(int bno, ModelAndView mav) {
		List<DotReplyDTO> list=replyService.list(bno);
		mav.setViewName("dot/reply_dot"); //�뀎怨쀬벥 占쎌뵠�뵳占�
		mav.addObject("list", list); //�뀎怨쀫퓠 占쎌읈占쎈뼎占쎈막 占쎈쑓占쎌뵠占쎄숲 占쏙옙占쎌삢
		return mav;//�뀎怨뺤쨮 占쎌뵠占쎈짗
	}
	
	
	@RequestMapping("list_json.do")
	public List<DotReplyDTO> list_json(int bno){
		return replyService.list(bno);
	}

}
