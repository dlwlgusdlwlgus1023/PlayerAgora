<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="favicon.ico" />
<title>Player Agora</title>
<meta charset="utf-8">
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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
/* 라디오버튼 css */

input[type=radio] {
	text-align : center;
    display:none; 
    height: 50px;
    padding: 35px 20px 30px 20px;
}
input[type=radio] + label {
    display:inline-block;
    margin:-2px;
    padding: 35px 20px 5px 20px;
    background-color: #ccc;
    border-color: #ddd;
    height: 50px;
}
input[type=radio]:checked + label { 
	padding: 35px 20px 5px 20px;
   	background-image: none;
    background-color:#666;
    height: 50px;
}

/* 검색 css */
fieldset {
  position: relative;
  display: inline-block;
  padding: 0 0 0 40px;
  background: #666;
  border: none;
  border-radius: 5px;
}

.search1, .search2 {
  position: relative;
  width: 200px;
  height: 50px;
  padding: 0;
  display: inline-block;
  float: left;
}

.search1 {
  color: #fff;
  background-color : #666;
  z-index: 2;
  border: 0 none;
}
.search1:focus {
  outline: 0 none;
}
.search1:focus + .search2 {
  -webkit-transform: translate(0, 0);
      -ms-transform: translate(0, 0);
          transform: translate(0, 0);
  -webkit-transition-duration: 0.3s;
          transition-duration: 0.3s;
}
.search1:focus + .search2 .fa {
  -webkit-transform: translate(0px, 0);
      -ms-transform: translate(0px, 0);
          transform: translate(0px, 0);
  -webkit-transition-duration: 0.3s;
          transition-duration: 0.3s;
  color: #666;
  background-color : #ccc;
}

.search2 {
  z-index: 1;
  width: 50px;
  border: 0 none;
  background: #ccc;
  cursor: pointer;
  border-radius: 0 5px 5px 0;  
  -webkit-transform: translate(-50px, 0);
      -ms-transform: translate(-50px, 0);
          transform: translate(-50px, 0);
  -webkit-transition-duration: 0.3s;
          transition-duration: 0.3s;
}

.fa-search {
  font-size: 1.4rem;
  color: #fff;
  z-index: 3;
  top: 25%;
  -webkit-transform: translate(-190px, 0);
      -ms-transform: translate(-190px, 0);
          transform: translate(-190px, 0);
  -webkit-transition-duration: 0.3s;
          transition-duration: 0.3s;
  -webkit-transition: all 0.1s ease-in-out;
          transition: all 0.1s ease-in-out;
}


/* html 값 변경 */
html, body {
	width: 100%;
	height: 100%;
}

body {
	padding-top: 20px;
}
/* Remove the navbar's default margin-bottom and rounded borders */

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* 반응형 - 작을때 */
@media screen and (max-width: 1022px) {
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
border:none;
border:0px;
margin:0px;
padding:0px;
font-size:18px;
}

.dropmenu ul{
list-style:none;
margin:0;
padding:0;
}

.dropmenu li{
float:left;
padding:0px;
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


.dropmenu li div{
	opacity : 1;
	z-index : -999;
	background-color : #000;
    position: absolute;
    top: 0px;
    left: 0px;
    transition: .3s ease-in-out;
    height:0px;
    width: 100%;
}

.dropmenu li:hover div{
	transition-delay: 0.2s;
	transition: .3s ease-in-out;
	height:25em;
}

.dropmenu li:hover div #divleft{
	transition-delay: 0.2s;
	transition-duration: .4s;
	visibility : visible;
	opacity: 1;
}

.dropmenu li:hover div #content1{
	transition-delay: 0.2s;
	transition-duration: .4s;
	visibility : visible;
	opacity: 1;
}
.dropmenu li:hover div #divright{
	transition-delay: 0.2s;
	transition-duration: .4s;
	visibility : visible;
	opacity: 1;
}


div #divleft {
	 background-size: cover;
     background-repeat: no-repeat;
     background-position: right;
	transition-duration: 0s;
	transition-delay: 0s;
	z-index : 9999;
	width: 30%;
	height: 340px;
	float: left;
	margin: 109px 0px 0px 0px;
	visibility : hidden;
	opacity: 0;
}
div #content1 {
	transition-duration: 0s;
	transition-delay: 0s;
	z-index : 1;
	left : 30%;
	width: 40%;
	height: 0px;
	float: left;
	margin: 109px 0px 0px 0px;
	visibility : hidden;
	opacity: 0;
	
}
div #divright {
	background-size: cover;
	background-repeat : no-repeat;
	transition-duration: 0s;
	transition-delay: 0s;
	z-index : 9999;
	left : 70%;
	width: 30%;
	height: 340px;
	text-align : right;
	float: right;
	margin: 109px 0px 0px 0px;
	visibility : hidden;
	opacity: 0;
}

div #content1 ul {
	width : 40%;
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

header.shrink div #content1 {
	margin: 48px 0px 0px 0px;
	transition-delay: 0s;
	transition-duration: 0.0s;
}
header.shrink div  {
	transition-delay: 0.0s;
	transition-duration: 0.4s;
}


header.shrink .dropmenu li:hover div   {
	transition-delay: 0.2s;
	transition-duration: .4s;
}

header.shrink .dropmenu li:hover div #content1   {
	transition-delay: 0.4s;
	transition-duration: .4s;
}


header.shrink .dropmenu li:hover div #divleft   {
	transition-delay: 0.4s;
	transition-duration: .4s;
}
header.shrink .dropmenu li:hover div #divright   {
	transition-delay: 0.4s;
	transition-duration: .4s;
}


/* 슬라이드 드롭메뉴 */
* {
	padding: 0;
	margin: 0;
}

a {
	text-decoration: none;
	color: gray;
}

#menuslide ul li {
	margin-top: 20px; padding : 5px;
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
	transition:font-size .01s, width .1s, height .1s, background-color .1s, transform .1s;
}

#menuBtn1:checked ~ .submenu {
	width: 100%;
	height: 100%; 
	transition:font-size .08s, width .2s, height .2s, background-color .1s, transform .3s;
	font-size: 10px;
	display: block;
	background-color: #333;
}

#menuBtn2:checked ~ .submenu {
	width: 100%;
	height: 100%;
	transition:font-size .08s, width .2s, height .2s, background-color .1s, transform .3s;
	font-size: 10px;
	display: block;
	background-color: #333;
}

#menuBtn3:checked ~ .submenu {
	width: 100%;
	height: 100%;
	transition:font-size .08s, width .2s, height .2s, background-color .1s, transform .3s;
	font-size: 10px;
	display: block;
	background-color: #333;
}
#menuBtn4:checked ~ .submenu {
	width: 100%;
	height: 100%;
	transition:font-size .08s, width .2s, height .2s, background-color .1s, transform .3s;
	font-size: 10px;
	display: block;
	background-color: #333;
}
#menuBtn5:checked ~ .submenu {
	width: 100%;
	height: 100%;
	transition:font-size .08s, width .2s, height .2s, background-color .1s, transform .3s;
	font-size: 10px;
	display: block;
	background-color: #333;
}
.labelBtn {
	font-size: 15px;
}
</style>
</head>
<body>
	<header id="main-header">
	<nav>
		 <div class="dropmenu">
      <a href="http://localhost/teamProject" style="float: left; top: 0;"><img src="../images/Logo.JPG" alt="Logo" id="logo"></a>
      <ul style="font-weight: bolder;" class="menuNav" id="menuNav">
        <li><a href="#">FPS/TPS</a>
        <div>
         <div id="divleft" style="background-image: url('../images/fps3.jpg'); ">
         </div>
        <div id="content1" align="center">
        <a ><img src="../images/bat.png" style="width : 100%; height: auto; max-width: 430px;"></a>
        <a><img src="../images/sud.png" style="width :100%; height: auto ;max-width: 430px;"></a>
        <a><img src="../images/over.png" style="width : 100%; height: auto;max-width: 430px;"></a>
        
        </div>
        <div id="divright" style="background-image: url('../images/fps4.jpg'); ">
        </div>       
         </div>        
        </li>
        <li><a href="#">RPG</a>
        <div>
         <div id="divleft" style="background-image: url('../images/rpg5.jpg'); ">
         </div>
        <div id="content1" align="center">
        <a ><img src="../images/wow.png" style="width : 100%; height: auto; max-width: 430px;"></a>
        <a><img src="../images/loa.png" style="width :100%; height: auto ;max-width: 430px;"></a>
        <a><img src="../images/me2.png" style="width : 100%; height: auto;max-width: 430px;"></a>
        
        </div>
        <div id="divright" style="background-image: url('../images/rpg4.jpg'); ">
        </div>       
         </div>
        </li>
        <li><a href="#">AOS</a>
        <div>
         <div id="divleft" style="background-image: url('../images/aos5.jpg'); ">
         </div>
        <div id="content1" align="center">
        <a ><img src="../images/lol.png" style="width : 100%; height: auto; max-width: 430px;"></a>
        <a><img src="../images/dota.png" style="width :100%; height: auto ;max-width: 430px;"></a>
        <a><img src="../images/hos.png" style="width : 100%; height: auto;max-width: 430px;"></a>
        
        </div>
        <div id="divright" style="background-image: url('../images/aos4.jpg'); ">
        </div>       
         </div>
        </li>
        <li><a href="#">시뮬레이션</a>
         <div>
         <div id="divleft" style="background-image: url('../images/si3.jpg'); ">
         </div>
        <div id="content1" align="center">
        <a ><img src="../images/star.png" style="width : 100%; height: auto; max-width: 430px;"></a>
        <a><img src="../images/mine.png" style="width :100%; height: auto ;max-width: 430px;"></a>
        <a><img src="../images/moon.png" style="width : 100%; height: auto;max-width: 430px;"></a>
        
        </div>
        <div id="divright" style="background-image: url('../images/si4.jpg'); ">
        </div>       
         </div>
         </li>     
        <li><a href="#">레이싱/스포츠</a>
		   <div>
         <div id="divleft" style="background-image: url('../images/spo3.jpg'); ">
         </div>
        <div id="content1" align="center">
        <a href="http://localhost/teamProject/screenshot/list.do"><img src="../images/fifa.png" style="width : 100%; height: auto; max-width: 430px;"></a>
        <a><img src="../images/need3.png" style="width :100%; height: auto ;max-width: 430px;"></a>
        <a><img src="../images/wi.png" style="width : 100%; height: auto;max-width: 430px;"></a>
        
        </div>
        <div id="divright" style="background-image: url('../images/spo4.jpg'); ">
        </div>       
         </div>
         </li>
         <li></li>
        <li style="float: right;"><a href="http://localhost/teamProject/member/login.do"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
      </div>
				<div id="slideIcon">
					<input type="checkbox" class="menuChk" id="menuicon"> <label
						for="menuicon"> <span></span> <span></span> <span></span>
					</label>
					<div class="slideNav" id="menuslide">
						<ul>
							<li><input type="checkbox" id="menuBtn1"> <label
								for="menuBtn1" class="labelBtn" onclick=""
								style="margin-top: 50px;">FPS/TPS</label>
								<ul class="submenu">
									<li><a href="#">배틀그라운드</a></li>
									<li><a href="#">서든어택</a></li>
									<li><a href="#">오버워치</a></li>
								</ul></li>
							<li><input type="checkbox" id="menuBtn2"> <label
								for="menuBtn2" class="labelBtn" onclick="">RPG</label>
								<ul class="submenu" style="color: white;">
									<li><a href="#">월드오브워크래프트</a></li>
									<li><a href="#">로스트아크</a></li>
									<li><a href="#">메이플스토리</a></li>
								</ul></li>
							<li><input type="checkbox" id="menuBtn3"> <label
								for="menuBtn3" class="labelBtn" onclick="">AOS</label>
								<ul class="submenu" style="color: white;">
									<li><a href="#">리그오브레전드</a></li>
									<li><a href="#">DOTA2</a></li>
									<li><a href="#">HOS</a></li>
								</ul></li>
							<li><input type="checkbox" id="menuBtn4"> <label
								for="menuBtn4" class="labelBtn" onclick="">시뮬레이션</label>
								<ul class="submenu" style="color: white;">
									<li><a href="#">스타크래프트</a></li>
									<li><a href="#">문명</a></li>
									<li><a href="#">마인크래프트</a></li>
								</ul></li>
							<li><input type="checkbox" id="menuBtn5"> <label
								for="menuBtn5" class="labelBtn" onclick="">레이싱/스포츠</label>
								<ul class="submenu" style="color: white;">
									<li><a href="#">위닝일레븐</a></li>
									<li><a href="#">카트라이더</a></li>
									<li><a href="#">유로트럭</a></li>
									<li><a href="#">피파온라인</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</nav>
		</header>
    	<script src="jquery-3.4.1.min.js"></script>
</body>
</html>