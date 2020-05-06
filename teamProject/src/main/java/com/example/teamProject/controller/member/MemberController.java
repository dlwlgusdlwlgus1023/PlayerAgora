package com.example.teamProject.controller.member;

import java.awt.Component;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.teamProject.model.member.dto.MemberDTO;
import com.example.teamProject.service.member.MemberService;

@Controller
@RequestMapping("member/*")
public class MemberController {
	
	@Inject
	MemberService memberService;

	
	private static final Logger logger=
			LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("login.do")
	public String login() {
		return "member/login";
	}
	
	   @RequestMapping("login_check.do")
	   public ModelAndView login_check(MemberDTO dto, 
	         HttpSession session) {
	      boolean result=memberService.loginCheck(dto, session);
	      ModelAndView mav=new ModelAndView();
	      if(result) {
	         mav.setViewName("home");
	      }else {
	         mav.setViewName("member/login");
	         mav.addObject("message", "error");
	      }
	      return mav;
	   }
	
	@RequestMapping("home_check.do")
	public ModelAndView home_check(MemberDTO dto, 
			HttpSession session) {
		boolean result=memberService.loginCheck(dto, session);
		ModelAndView mav=new ModelAndView();
		if(result) {
			mav.setViewName("home");
		}else {
			mav.setViewName("home");
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	@RequestMapping("join.do")
	public String join() {
		return "member/join";
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute MemberDTO dto) {
		memberService.insertMember(dto);
		return "member/login";
	}

	/* 로그아웃 */
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		//세션 초기화
		memberService.logout(session);
		//login.jsp로 이동
		mav.setViewName("member/login");
		return mav;
	}
	@RequestMapping("member/view.do")
	public String view(@RequestParam String userid, Model model) {
		//모델에 자료 저장
		model.addAttribute("dto", memberService.viewMember(userid));
		return "member/view";//view.jsp로 포워딩
	}
	@RequestMapping("member/update.do")
	public String update(MemberDTO dto, Model model,HttpSession session) {
		//비밀번호 체크
		boolean result=memberService.checkPw(dto.getUserid(), dto.getPwd());//create method
		if(result) {//비밀번호가 맞으면
			//회원정보 수정
			memberService.logout(session);
			memberService.updateMember(dto);//create method
			//수정 후 목록으로 이동
			return "member/login";
		}else {//비밀번호가 틀리면
			model.addAttribute("dto", dto);
			model.addAttribute("join_date", 
			memberService.viewMember(dto.getUserid()).getJoin_date());
			model.addAttribute("message", "비밀번호를 확인하세요.");
			
			return "member/view";
		}
	}
	

	@RequestMapping("member/delete.do")
	public String delete(String userid, String pwd, Model model, HttpSession session) {
		boolean result=memberService.checkPw(userid, pwd);
		if(result) {//비번이 맞으면 삭제 => 목록으로 이동
			memberService.logout(session);
			memberService.deleteMember(userid);
			return "member/login";
			
		}else {//비번이 틀리면 되돌아감
			model.addAttribute("message", "비밀번호를 확인하세요.");
			model.addAttribute("dto", memberService.viewMember(userid));
			return "member/view";
		}
	}

}
