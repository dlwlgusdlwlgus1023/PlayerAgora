<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Need-For-Speed</title>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/side_banner.jsp"%>
<%@ page import="com.example.teamProject.model.nfs.dto.*"%>
<%@ page import="java.util.*"%>
<script src="../include/js/common.js"></script>
<!-- ckeditor의 라이브러리 -->
<script src="../ckeditor/ckeditor.js"></script>


<style>
body {
	background-image: url("../images/nfs2.jpg");
	width: 100%;
	height: 100%;
	background-attachment: fixed;
}

#main-banner {
	max-width: 840px;
}

#writecont {
	width: 882px;
	height: 30%;
	margin-left: auto;
	margin-right: auto;
	background-color: white;
	margin-right: auto;
}

div {
	text-align: center;
}

#Notice {
	width: 800px;
	text-align: left;
	margin-left: auto;
	margin-right: auto;
	border: 1px solid #ccc;
}

#Notice tr th {
	border-bottom: 1px solid #ccc;
	background-color: #eadbc6;
}

#Notice tr td label {
	color: red;
}
</style>

</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@ include file="../include/headerBody.jsp"%>
	<%@ include file="../include/left_menu.jsp"%>
	<div id="writecont">
		<img src="${path}/images/btg_offer.JPG"
			style="width: 880px; height: 100%;"> <br> <br>
		<table id="Notice">
			<tr>
				<th>★배틀그라운드 Player Agora 듀오 / 스쿼드 모집 게시판이란? ★</th>
			</tr>
			<tr>
				<td>듀오 / 스쿼드 모집 게시판은 서로 대화하며 게임을 즐길 파티도 찾고 인맥도 쌓는 게시판 입니다.<br>
					에란겔, 미라마, 비켄디, 사녹과 같은 전장을 함께할 동료를 구해보세요.<br> <br> 그 외에도
					클랜 을 통해 함께할 인원을 모집할 수도 있으니 많은 이용 바랍니다.<br> <br> <br>
					<label>■ 배틀그라운드 Player Agora 듀오 / 스쿼드 모집 게시판 이용 시 주의사항</label><br>
					<br> - 대리 혹은 대리 듀오 관련 게시물을 작성할 시 이유여하를 막론하고 1개월 간 이용 정지 처리됩니다.<br>
					- 그 외에도 계정 대여 및 판매글에 대한 게시물과 아이템 거래 관련 게시물, 패작 파티 글 작성 역시<br>
					- 무통보 삭제 및 이용 제재 조치 되오니 불이익을 받지 않도록 유의하시기 바랍니다.<br> - '불법
					프로그램'에 동조할 팀/팀원을 구하는 글도 제재의 대상이 됩니다.
				</td>
			</tr>
		</table>
		<br>
		<form id="form1" name="form1" method="post"
			action="${path}/nfs/insert.do">
			<table>
				<tr style="height: 30px;">
					<td style="padding: 0 0 0 5px;">&nbsp; <select name="b_name"
						id="b_name">
							<option selected="selected">선택</option>
							<option value="패치노트">패치노트</option>
							<option value="공략/팁">공략/팁</option>
							<option value="파티모집">파티모집</option>
					</select>
					</td>
					<td>
						<div>
							제목 : <input name="title" id="title" size="90"
								placeholder="제목을 입력하세요">
						</div>
					</td>


				</tr>
			</table>
			<div style="float: right;">
				작성자 : [ ${sessionScope.nick} ]<input name="writer" type="hidden"
					value="${sessionScope.nick}">
			</div>
			<br>
			<div>
				<textarea style="resize: none; width: 870px; height: 400px;"
					id="posts" name="posts" rows="3" cols="80" placeholder="내용을 입력하세요"></textarea>
			</div>
			<div>
				<div><a href="https://www.ea.com/ko-kr/games/need-for-speed/need-for-speed-heat" target="_blank" id="main-banner"><img src="../images/nfs_addImg.jpg" style="max-width:840px; background-size: cover;"> </a></div>
				<div id="uploadedList"></div>
			</div>
			<div style="width: 100%; text-align: center; padding: 10px;">
				<button type="button" id="btnSave">작성완료</button>
			</div>
		</form>
		<script type="text/javascript">
			$("#btnSave")
					.click(
							function() {
								var b_name = $("#b_name").val(); // 구분 내용 
								var title = $("#title").val();// 제목 내용
								var posts = $("#posts").val();// 본문 내용
								var bno = "${dto.bno}"; //게시물 번호
								var param = {
									"b_name" : b_name,
									"bno" : bno,
									"title" : title,
									"posts" : posts
								};
								if ($("#b_name").val() == '선택') {
									alert('구분을 선택하세요.');
								} else if ($("#title").val() == '') {
									alert('제목을 입력하세요.');
								} else if ($("#posts").val() == '') {
									alert('내용을 입력하세요.')
								} else {
									var str = "";
									// F12에서 올린 파일부분살펴보면 uploadedList 내부의 .file 태그 각각 반복
									$(".uploadedList .file")
											.each(
													function(i) {
														console.log(i);
														//hidden 태그 구성
														str += "<input type='hidden' id='files["
																+ i
																+ "]' name='files["
																+ i
																+ "]'   value='"
																+ $(this).val()
																+ "'>";
													});
									//폼에 hidden 태그들을 붙임
									$("#form1").append(str);
									document.form1.submit();
								}
							});
		</script>
	</div>
</body>
</html>
