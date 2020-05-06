<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
 <style>
/* html 값 변경 */
html, body {
	width: 100%;
	height: 100%;
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
</style>
<%@ include file="include/header.jsp" %>
<%@ include file="include/side_banner.jsp" %>
</head>
<body >
	<div style="height: 100%; width: 100%">
		<%@ include file="include/headerBody.jsp" %>
		<div class="container-fluid text-center" style="background-color: #ccc;">
			<div class="row content">
			<%@ include file="include/left_menu.jsp" %>
			<br><br><br><br><br>
			<!-- 작을때 슬라이드 -->
				<div class="col-sm-12 text-left" id="slide">
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
							<li data-target="#myCarousel" data-slide-to="3"></li>
							<li data-target="#myCarousel" data-slide-to="4"></li>
							<li data-target="#myCarousel" data-slide-to="5"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<img src="${path}/images/slide12.jpg" onclick="location.href='#'"
									width="100%" height="100%">
								<div class="carousel-caption">
									<h3>FPS/TPS</h3>
									<p>배틀그라운드 / 서든어택 / 오버워치</p>
								</div>
							</div>

							<div class="item">
								<img src="${path}/images/slide9.jpg" onclick="location.href='#'"
									width="100%" height="100%">
								<div class="carousel-caption">
									<h3>레이싱</h3>
									<p>카트라이더 / 유로트럭 / NEED FOR SPEED / Asphalt</p>
								</div>
							</div>

							<div class="item">
								<img src="${path}/images/slide8.jpg" onclick="location.href='#'"
									width="100%" height="100%">
								<div class="carousel-caption">
									<h3>RPG</h3>
									<p>WOW / 로스트아크 / 메이플스토리</p>
								</div>
							</div>

							<div class="item">
								<img src="${path}/images/slide10.jpg" onclick="location.href='#'"
									width="100%" height="100%">
								<div class="carousel-caption">
									<h3>시뮬레이션</h3>
									<p>스타크래프트 / 문명 / 마인크래프트</p>
								</div>
							</div>

							<div class="item">
								<img src="${path}/images/slide11.jpg" onclick="location.href='#'"
									width="100%" height="100%">
								<div class="carousel-caption">
									<h3>AOS</h3>
									<p>LOL / DOTA / HOS</p>
								</div>
							</div>

							<div class="item">
								<img src="${path}/images/slide13.jpg" onclick="location.href='#'"
									width="100%" height="100%">
								<div class="carousel-caption">
									<h3>스포츠</h3>
									<p>FIFA ONLINE / 위닝</p>
								</div>
							</div>
						</div>

						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel" role="button"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> <a class="right carousel-control" href="#myCarousel"
							role="button" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>

					<hr>
					
				</div>
			<!-- 클때 슬라이드 -->
				<div class="col-sm-10 text-left" id="slide1">
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
							<li data-target="#myCarousel" data-slide-to="3"></li>
							<li data-target="#myCarousel" data-slide-to="4"></li>
							<li data-target="#myCarousel" data-slide-to="5"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<img src="${path}/images/slide12.jpg" onclick="location.href='#'"
									width="100%" height="100%">
								<div class="carousel-caption">
									<h3>FPS/TPS</h3>
									<p>배틀그라운드 / 서든어택 / 오버워치</p>
								</div>
							</div>

							<div class="item">
								<img src="${path}/images/slide9.jpg" onclick="location.href='#'"
									width="100%" height="100%">
								<div class="carousel-caption">
									<h3>레이싱</h3>
									<p>카트라이더 / 유로트럭 / NEED FOR SPEED / Asphalt</p>
								</div>
							</div>

							<div class="item">
								<img src="${path}/images/slide8.jpg" onclick="location.href='#'"
									width="100%" height="100%">
								<div class="carousel-caption">
									<h3>RPG</h3>
									<p>WOW / 로스트아크 / 메이플스토리</p>
								</div>
							</div>

							<div class="item">
								<img src="${path}/images/slide10.jpg" onclick="location.href='#'"
									width="100%" height="100%">
								<div class="carousel-caption">
									<h3>시뮬레이션</h3>
									<p>스타크래프트 / 문명 / 마인크래프트</p>
								</div>
							</div>

							<div class="item">
								<img src="${path}/images/slide11.jpg" onclick="location.href='#'"
									width="100%" height="100%">
								<div class="carousel-caption">
									<h3>AOS</h3>
									<p>LOL / DOTA / HOS</p>
								</div>
							</div>

							<div class="item">
								<img src="${path}/images/slide13.jpg" onclick="location.href='#'"
									width="100%" height="100%">
								<div class="carousel-caption">
									<h3>스포츠</h3>
									<p>FIFA ONLINE / 위닝</p>
								</div>
							</div>
						</div>

						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel" role="button"
							data-slide1="prev"> <span
							class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> <a class="right carousel-control" href="#myCarousel"
							role="button" data-slide1="next"> <span
							class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>

					<hr>
					
				</div>
				<div class="col-sm-8 text-center">
				<iframe src="${path}/main/mainList.do" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"  width="100%" height="3500px" ></iframe>
				
			</div>
				<div class="col-sm-2 text-center" style="width: 261px; overflow-x:hidden; overflow: y:scroll; ">
				<iframe src="${path}/screenshot/list.do" frameborder="0" marginwidth="0" marginheight="0"  width="261px" height="3524px" scrolling="no"  ></iframe>
			</div>
		</div>

		<script src="include/jquery-3.4.1.min.js"></script>
		<script src="include/homescript.js"></script>
	</div>
	<%@ include file="include/footer.jsp" %>
</body>