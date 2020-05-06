<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
$(function() { //자동으로 실행되는 코드
	   //댓글 목록 출력
	   //listReply();
	   listReply2();
	   //댓글 쓰기
	   $("#btnReply").click(function() {
	      var replytext = $("#replytext").val(); //댓글 내용
	      var bno = "${dto.bno}"; //게시물 번호
	      var param = {
	         "replytext" : replytext,
	         "bno" : bno
	      };
	      if($("#replytext").val()==''){   
	       alert('댓글내용을 입력하여주십시오.');
	      }else {
	      //var param="replytext="+replytext+"&bno="+bno;
	      $.ajax({
	         type : "post",
	         url : "${path}/reply_btg/insert.do",
	         data : param,
	         success : function() {
	            //listReply();
	            listReply2(); //댓글 목록 출력
	            var result = confirm("작성한 댓글을 확인하시겠습니까?");
	            if(result){
	            $('html, body').animate({ scrollTop: $(document).height()},1000);
	            $('#replytext').val('');


	            }else{
	                alert("댓글이 작성되었습니다.");
	                $('#replytext').val('');
	   
	            }
	         }
	      });
	      }
	   });
	});
//댓글 목록 출력 함수
function listReply() {
	$.ajax({
		type : "get",
		url : "${path}/reply_btg/list.do?bno=${dto.bno}",
		success : function(result) {
			//result : responseText 응답텍스트(html)
			$("#listReply").html(result);
		}
	});
}
//타임스탬프값(숫자형)을 문자열 형식으로 변환
function changeDate(date) {
	date = new Date(parseInt(date));
	year = date.getFullYear();
	month = date.getMonth();
	day = date.getDate();
	hour = date.getHours();
	minute = date.getMinutes();
	second = date.getSeconds();
	strDate = year + "-" + month + "-" + day + " " + hour + ":" + minute
			+ ":" + second;
	return strDate;
}
function listReply2() {
	$
			.ajax({
				type : "get",
				contentType : "application/json",
				url : "${path}/reply_btg/list_json.do?bno=${dto.bno}",
				success : function(result) {
					//view를 만들지 않는 대신에 자바스크립트로 table등을 만들어야 한다.
					console.log(result);
					var output = "<table id='replytable' style='width: 100%; max-width: 1000px; margin-left: auto;margin-right: auto;'>";
					for ( var i in result) {
						var repl = result[i].replytext;
						// /정규식/(규칙) => 정규표현식
						// 규칙 g: global 전역검색, i: 대소문자 무시
						// ex) /java/gi => JAVA 또는 java를 모두 찾음
						repl = repl.replace(/  /gi, "&nbsp;&nbsp;");//공백처리
						repl = repl.replace(/</gi, "&lt;"); //태그문자 처리
						repl = repl.replace(/>/gi, "&gt;");
						repl = repl.replace(/\n/gi, "<br>"); //줄바꿈 처리

						output += "<tr id='upside'><td id='upside_nick'>" + result[i].nick;
						date = changeDate(result[i].regdate);
						output += "</td><td id='upside_date'>(" + date + ")";
						output += "</td></tr><tr><td colspan='2'>" + repl + "</td></tr>";
					}
					output += "</table>";
					$("#listReply").html(output);
				}
			});
}
</script>
<style>
 #upside {
	border-top : 1px solid #dcdcdc;
	border-collapse: collapse;
}
#upside_nick{
	font-weight: bold;
	padding-left: 15px; 
	
}
#upside_date{
	font-size: 10px;
	color: #848484;
	float: right;
	padding-right: 20px;
}
#replytable tr td{
	padding-top: 15px;
	padding-bottom: 15px;
	padding-left: 15px; 
}
</style>