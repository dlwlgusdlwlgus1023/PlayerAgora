<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" 
value="${pageContext.request.contextPath}" />

<link rel="stylesheet" href="${path}/include/style.css">
<script src="${path}/include/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="${path}/include/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<style>
* {
	padding: 0;
	margin: 0;
}
.row.content {
	height: 450px
}


/* 반응형 - 작을때 */
@media screen and (max-width: 1022px) {
	#headspace {
		display: none;
	}
	#sidebtn{
		display: none;
	}
	#banner_compuzone{
		display: none;
	}
	#banner_danawa{
		display: none;
	}
	input[id="menuicon"] {
		display: none;
	}
	input[id="menuicon"]+label {
		float: right;
		display: block;
		width: 40px;
		height: 30px;
		position: relative;
		cursor: pointer;
		transition: .3s ease-in-out;
	}
	input[id="menuicon"]+label span {
		display: block;
		position: absolute;
		width: 100%;
		height: 5px;
		berder-radius: 30px;
		background: gray;
		transition: all .35s;
	}
	input[id="menuicon"]+label span:nth-child(1) {
		top: 0;
	}
	input[id="menuicon"]+label span:nth-child(2) {
		top: 50%;
		transform: translateY(-50%);
	}
	input[id="menuicon"]+label span:nth-child(3) {
		bottom: 0;
	}
	input[id="menuicon"]:checked+label span:nth-child(1) {
		top: 50%;
		transform: translateY(-50%) rotate(45deg);
	}
	input[id="menuicon"]:checked+label span:nth-child(2) {
		opacity: 0;
	}
	input[id="menuicon"]:checked+label span:nth-child(3) {
		bottom: 50%;
		transform: translateY(50%) rotate(-45deg);
	}
	input[id="menuicon"]+label+div {
		right: -200px;
	}
	input[id="menuicon"]:checked+label+div {
		right: 0px;
	}
	#menuslide {
		background-color: #111;
		color: #999;
		text-align: center;
		position: fixed;
		width: 200px;
		height: 100%;
		z-index: -1;
		transition: all .35s;
		margin: 0;
	}
	#menuslide ul li {
		margin-top: 50%;
		font-size: 1.5em;
	}
	#menuNav {
		display: none;
	}
	#logIcon {
		display: block;
		float: left;
		margin-left: 45px;
		position: absolute;
	}
	.submenu li:hover a {
		color: #999;
		text-decoration: none;
	}
	.submenu li a {
		color: #999;
		text-decoration: none;
	}
	/* 작은화면시 로긴창 */
	#loginform{
	max-width: 365px;
}	
	.input-group #userid{
	width: 70%;
	float: left;
	}
	.input-group #pwd{
	width: 70%;
	float: left;
	}
	.input-group #btnLogin{
	width: 28%;
	float: right;
	margin-left: 3px;
	}
	.input-group #btnJoin{
	width: 28%;
	float: right;	
	margin-left: 3px;
	}
	#fulllogin #btnLogin1{
	display: none;
	}
	#fulllogin #btnJoin1{
	display: none;
	}
/* footer */

footer{
	padding: 5px;
}
.footer-sec {
    box-shadow: inset 0 30px 30px -30px rgba(0,0,0,0.8);
    background-color: #444444;
    color: #f6f6f6;
    padding-top: 1em;
    padding-bottom: 1em;
    clear: left;
    clear: left;
}

.footer-sec-bottom {
    padding: 1em;
}

    .footer-sec-bottom h3 {
        color: #0065a2;
        padding: 0;
        font-size: 19px;
    }

    .footer-sec-bottom a:hover {
        transition: all .3s ease;
        color: #0065a2;
    }

.footer-logo {
    width: 13em;
}	
#slide{
	display : block;
	margin-top: -100px;
}
#slide1{
	display: none;
}

}
/* 전체화면 */
@media ( min-width :1023px) {
	/* 토글 버튼 */
	input[id="menuicon"] {
		display: none;
	}
	.menuNav li {
		width: auto;
	}
	#menuslide {
		display: none;
	}
	#menuNav {
		display: inline;
	}
	#headbtn{
		display: none;
	}
	/* 전체화면시 로긴창 */
	#loginform{
	max-width: 204px;
}
	.input-group #btnLogin{
	display: none;
	}
	.input-group #btnJoin{
	display: none;
	}
	#slide1{
	display :block;
	margin-top: 0%;
	}
	#slide{
	display: none;
}	
	
}



#main-header {
	padding: 0 2em;
	position: fixed;
	top: 0;
	background: rgb(0, 0, 0);
	border-bottom: 2px solid #ccc;
	width: 100%;
	transition: .3s ease-in-out;
	z-index: 999;
}

#menuNav li {
	list-style: none;
	line-height: 6em;
	transition: .3s ease-in-out;
}

header.shrink nav #menuNav li {
	line-height: 2em;
}

.dropmenu a {
	margin: 25px 0;
	transition: .3s ease-in-out;
}

header.shrink nav .dropmenu a {
	margin: 0;
	transition: .3s ease-in-out;
}

#slideIcon {
	margin: 25px 0;
	float: right;
	display: inline-block;
	transition: .3s ease-in-out;
}

header.shrink nav #slideIcon {
	margin: 5px;
	margin-top: 9px;
	transition: .3s ease-in-out;
}
/* 드롭메뉴 */
/* 테스트  */
.dropmenu {
	border: none;
	border: 0px;
	margin: 0px;
	padding: 0px;
	font-size: 18px;
}

.dropmenu ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

.dropmenu li {
	float: left;
	padding: 0px;
	margin: 0px;
}

.dropmenu li a {
	color: #fff;
	display: block;
	margin: 0px;
	padding: 0px 19px;
	text-align: center;
	text-decoration: none;
	opacity: 0.8;
}

.dropmenu li a:hover {
	color: #FFFFFF;
	text-decoration: none;
	background-color: #666;
	opacity: 1;
}

.dropmenu li div {
	opacity: 1;
	z-index: -999;
	background-color: #000;
	position: absolute;
	top: 0px;
	left: 0px;
	transition: .3s ease-in-out;
	height: 0px;
	width: 100%;
}

.dropmenu li:hover div {
	transition-delay: 0.2s;
	transition: .3s ease-in-out;
	height: 25em;
}

.dropmenu li:hover div #divleft {
	transition-delay: 0.2s;
	transition-duration: .4s;
	visibility: visible;
	opacity: 1;
}

.dropmenu li:hover div #content {
	transition-delay: 0.2s;
	transition-duration: .4s;
	visibility: visible;
	opacity: 1;
}

.dropmenu li:hover div #divright {
	transition-delay: 0.2s;
	transition-duration: .4s;
	visibility: visible;
	opacity: 1;
}

div #divleft {
	background-size: cover;
	background-repeat: no-repeat;
	background-position: right;
	transition-duration: 0s;
	transition-delay: 0s;
	z-index: 9999;
	width: 30%;
	height: 340px;
	float: left;
	margin: 109px 0px 0px 0px;
	visibility: hidden;
	opacity: 0;
}

div #content {
	transition-duration: 0s;
	transition-delay: 0s;
	z-index: 1;
	left: 30%;
	width: 40%;
	height: 0px;
	float: left;
	margin: 109px 0px 0px 0px;
	visibility: hidden;
	opacity: 0;
}

div #divright {
	background-size: cover;
	background-repeat: no-repeat;
	transition-duration: 0s;
	transition-delay: 0s;
	z-index: 9999;
	left: 70%;
	width: 30%;
	height: 340px;
	text-align: right;
	float: right;
	margin: 109px 0px 0px 0px;
	visibility: hidden;
	opacity: 0;
}

div #content ul {
	width: 40%;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	display: list-item;
}

header.shrink div #divleft {
	margin: 48px 0px 0px 0px;
	transition-delay: 0s;
	transition-duration: 0.0s;
}

header.shrink div #divright {
	margin: 48px 0px 0px 0px;
	transition-delay: 0s;
	transition-duration: 0.0s;
}

header.shrink div #content {
	margin: 48px 0px 0px 0px;
	transition-delay: 0s;
	transition-duration: 0.0s;
}

header.shrink div {
	transition-delay: 0.0s;
	transition-duration: 0.4s;
}

header.shrink .dropmenu li:hover div {
	transition-delay: 0.2s;
	transition-duration: .4s;
}

header.shrink .dropmenu li:hover div #content {
	transition-delay: 0.4s;
	transition-duration: .4s;
}

header.shrink .dropmenu li:hover div #divleft {
	transition-delay: 0.4s;
	transition-duration: .4s;
}

header.shrink .dropmenu li:hover div #divright {
	transition-delay: 0.4s;
	transition-duration: .4s;
}

#menuslide ul li {
	margin-top: 20px;
	padding: 5px;
	list-style-type: none;
	padding: 5px;
}

#menuslide input {
	position: fixed;
	left: -9999px;
}

#menuslide label {
	cursor: pointer;
	color: gray;
}

.submenu {
	width: 100%;
	height: 0;
	font-size: 0;
	margin: 0;
	transition: font-size .01s, width .1s, height .1s, background-color .1s,
		transform .1s;
}

#menuBtn1:checked ~ .submenu {
	width: 100%;
	height: 100%;
	transition: font-size .08s, width .2s, height .2s, background-color .1s,
		transform .3s;
	font-size: 10px;
	display: block;
	background-color: #333;
}

#menuBtn2:checked ~ .submenu {
	width: 100%;
	height: 100%;
	transition: font-size .08s, width .2s, height .2s, background-color .1s,
		transform .3s;
	font-size: 10px;
	display: block;
	background-color: #333;
}

#menuBtn3:checked ~ .submenu {
	width: 100%;
	height: 100%;
	transition: font-size .08s, width .2s, height .2s, background-color .1s,
		transform .3s;
	font-size: 10px;
	display: block;
	background-color: #333;
}

#menuBtn4:checked ~ .submenu {
	width: 100%;
	height: 100%;
	transition: font-size .08s, width .2s, height .2s, background-color .1s,
		transform .3s;
	font-size: 10px;
	display: block;
	background-color: #333;
}

#menuBtn5:checked ~ .submenu {
	width: 100%;
	height: 100%;
	transition: font-size .08s, width .2s, height .2s, background-color .1s,
		transform .3s;
	font-size: 10px;
	display: block;
	background-color: #333;
}

.labelBtn {
	font-size: 15px;
}
/* 맨위로 버튼 */
a#MOVE_TOP_BTN {
    position: fixed;
    right: 2%;
    bottom: 30px;
    display: none;
    z-index: 999;
    border-radius: 100px;
    text-align: center;
      background-color: #555;
 	 width: 50px;
 	 height: 50px;
 	 text-decoration : none;
}

#MOVE_TOP_BTN::after {
  content: "\f077";
  font-family: FontAwesome;
  font-weight: normal;
  font-style: normal;
  font-size: 2em;
  line-height: 50px;
  color: #fff;
  text-decoration : none;
}
#MOVE_TOP_BTN:hover {
	text-decoration : none;
  cursor: pointer;
  background-color: #333;
  text-decoration : none;
}
#MOVE_TOP_BTN:active {
  background-color: #555;
  text-decoration : none;
}
/* 로그인css */
.input-group {
    margin-top: 1em;
    margin-bottom: 1em;
}

.login-box {
    line-height: 2.3em;
    font-size: 1em;
    color: #aaa;
    margin-top: 1em;
    margin-bottom: 1em;
    padding-top: 0.5em;
    padding-bottom: 0.5em;
}
/* footer */

footer{
	padding: 5px;
}
.footer-sec {
    box-shadow: inset 0 30px 30px -30px rgba(0,0,0,0.8);
    background-color: #444444;
    color: #f6f6f6;
    padding-top: 1em;
    padding-bottom: 1em;
    clear: left;
    clear: left;
}

.footer-sec-bottom {
    padding: 1em;
}

    .footer-sec-bottom h3 {
        color: #0065a2;
        padding: 0;
        font-size: 19px;
    }

    .footer-sec-bottom a:hover {
        transition: all .3s ease;
        color: #0065a2;
    }

.footer-logo {
    width: 13em;
}

ul.social {
    padding: 0px;
    list-style: none;
    margin: 0px;
}

    ul.social li {
        display: inline;
        padding: 0;
        margin: 0 5px;
    }

        ul.social li a {
            transition: all 0.6s ease;
            display: inline-block;
            margin: 0 auto;
            -moz-border-radius: 50%;
            -webkit-border-radius: 50%;
            border-radius: 50%;
            text-align: center;
            width: 50px;
            height: 50px;
            font-size: 24px;
            position: relative;
            background-color: transparent;
        }

            ul.social li a i {
                color: #FFF;
                text-align: center;
                margin: 0;
                line-height: 50px;
                -webkit-transition: all 0.8s;
                -moz-transition: all 0.8s;
                -o-transition: all 0.8s;
                -ms-transition: all 0.8s;
                transition: all 0.8s;
            }

            ul.social li a:hover i {

                -webkit-transition: all 0.4s;
                -moz-transition: all 0.4s;
                -o-transition: all 0.4s;
                -ms-transition: all 0.4s;
                transition: all 0.4s;
            }

.social li a.insta:hover {
    background-color: #007bb7;
}

.social li a.face:hover {
    background-color: #3B5998;
}

.social li a.twit:hover {
    background-color: #33ccff;
}

.social li a.google:hover {
    background-color: #BD3518;
}

.social li a.linkedin:hover {
    background-color: #007bb7;
}

@media ( max-width :992px) {
	.footer-section{
	display: none;
	}
	#screen{
	margin-top: -100px;
	}
}
</style>
<!-- 우주좌가 헤더로 잘 옮겨줄거 내가하니까안됨 ㅋㅋ  -->
<script type="text/javascript">
$(function(){
      $("#btnLogin").click(function(){
         var userid=$("#userid").val(); //태그의 value 속성값
         var pwd=$("#pwd").val();
         if(userid==""){
            alert("아이디를 입력하세요.");
            $("#userid").focus(); //입력 포커스 이동
            return; //함수 종료
         }
         if(pwd==""){
            alert("비밀번호를 입력하세요.");
            $("#pwd").focus();
            return;
         }
         //폼 데이터를 서버로 제출
         document.formLog.action="${path}/member/login_check.do";
         document.formLog.submit();
      });
      $("#btnJoin").click(function(){
         location.href="http://localhost/teamProject/member/join.do";
         });
      $("#btnLogin1").click(function(){
          var userid=$("#userid").val(); //태그의 value 속성값
          var pwd=$("#pwd").val();
          if(userid==""){
             alert("아이디를 입력하세요.");
             $("#userid").focus(); //입력 포커스 이동
             return; //함수 종료
          }
          if(pwd==""){
             alert("비밀번호를 입력하세요.");
             $("#pwd").focus();
             return;
          }
          //폼 데이터를 서버로 제출
          document.formLog.action="${path}/member/login_check.do";
          document.formLog.submit();
       });
       $("#btnJoin1").click(function(){
          location.href="http://localhost/teamProject/member/join.do";
          });
   });

$(function(){
    $("#homeLogin").click(function(){
       var userid=$("#userid").val(); //태그의 value 속성값
       var pwd=$("#pwd").val();
       if(userid==""){
          alert("아이디를 입력하세요.");
          $("#userid").focus(); //입력 포커스 이동
          return; //함수 종료
       }
       if(pwd==""){
          alert("비밀번호를 입력하세요.");
          $("#pwd").focus();
          return;
       }
       //폼 데이터를 서버로 제출
       document.formLog.action="${path}/member/login_check.do";
       document.formLog.submit();
    });
    $("#btnJoin").click(function(){
       location.href="http://localhost/teamProject/member/join.do";
       });
 });

/* 맨위로 버튼 */
$(function() {
    $(window).scroll(function() {
        if ($(this).scrollTop() > 800) {
            $('#MOVE_TOP_BTN').fadeIn();
        } else {
            $('#MOVE_TOP_BTN').fadeOut();
        }
    });
    
    $("#MOVE_TOP_BTN").click(function() {
        $('html, body').animate({
            scrollTop : 0
        }, 400);
        return false;
    });
}); 



</script>
<!-- 우주좌가 헤더로 잘 옮겨줄거 내가하니까안됨 ㅋㅋ  -->
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type='text/css'>
<link rel="apple-touch-icon" sizes="180x180"
	href="${path}/images/favicon/favicon_io/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="${path}/images/favicon/favicon_io/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="${path}/images/favicon/favicon_io/favicon-16x16.png">
