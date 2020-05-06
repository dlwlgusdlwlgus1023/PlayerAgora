<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="favicon.ico" />
<title>Battle Ground</title>
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
<script src="../include/jquery-3.4.1.min.js"></script>
<script src="../include/script.js"></script>
<script>
	$(function() {
		$("#btnWrite").click(function() {
			location.href = "${path}/teamProject/btg/write.do";
		});
	});
	function list(page) {
		location.href = "${path}/teamProject/btg/list.do?curPage=" + page;
	}

	$(function() {
		$("#btnWrite").click(function() {
			location.href = "${path}/teamProject/btg/write.do";
		});
	});
	function list(page) {
		location.href = "${path}/teamProject/btg/list.do?curPage=" + page;
	}
</script>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/side_banner.jsp"%>
<%@ include file="reply_script.jsp"%>
<script>
	//수정 버튼
	$("#btnUpdate").click(
			function() {
				//첨부파일 이름들을 폼에 추가
				var str = "";
				$(".uploadedList .file").each(
						function(i) {
							//#id이름(공백).클래스이름 : id가 uploadeList인 태그의 자식태그 중에서 class가 file인 태그들
							str += "<input type='hidden' name='files[" + i
									+ "]' value='" + $(this).val() + "'>";
						});
				$("#form1").append(str);
				document.form1.action = "${path}/btg/update.do";
				document.form1.submit();
			});

	$("#uploadedList").on("click", ".file_del", function(e) {
		var that = $(this); //클릭한 태그
		//data: {fileName: $(this).attr("data-src") },		
		$.ajax({
			type : "post",
			url : "${path}/upload/deleteFile",
			data : "fileName=" + $(this).attr("data-src"),
			dataType : "text",
			success : function(result) {
				if (result == "deleted") {
					//화면에서 태그 제거
					that.parent("div").remove();
				}
			}
		});
	});
	$("#btnSave").click(
			function() {
				var str = "";
				// uploadedList 내부의 .file 태그 각각 반복
				$("#uploadedList .file").each(
						function(i) {
							console.log(i);
							//hidden 태그 구성
							str += "<input type='hidden' name='files[" + i
									+ "]'	value='" + $(this).val() + "'>";
						});
				//폼에 hidden 태그들을 붙임
				$("#form1").append(str);
				document.form1.submit();
			});
</script>

<style>
* {
	padding: 0;
	margin: 0;
}

#main-banner {
	max-width: 840px;
}

div {
	text-align: center;
}

body {
	background-image: url("../images/btg1.jpg");
	width: 100%;
	height: 100%;
	background-attachment: fixed;
}

#writecont {
	width: 882px;
	height: 30%;
	margin-left: auto;
	margin-right: auto;
	background-color: white;
}

#C_head {
	background-color: #e6e6f2;
	text-align: center;
	border-top: 2px solid #bcbada;
	border-bottom: 1px solid #bcbada;
	width: 880px;
}

table {
	margin: 5px;
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

pre {
	background-color: white;
	border: none;
	height: 100%;
}

#posts {
	height: 100%;
}
</style>

</head>
<body>

	<div style="height: 100%; width: 100%">
		<%@ include file="../include/headerBody.jsp"%>
		<%@ include file="../include/left_menu.jsp"%>
		<div id="headbtn">
			<table>
				<tr>
					<td><a href="${path}/btg/list1.do">배틀그라운드</a></td>
					<td><a href="${path}/btg/list2.do">패치노트</a></td>
					<td><a href="${path}/btg/list3.do">공략/팁</a></td>
					<td><a href="${path}/btg/list4.do">파티모집</a></td>
					<td><a href="${path}/screenshot/listBtg.do">스크린샷</a></td>
				</tr>
			</table>
		</div>
		<script src="../include/script.js"></script>
		<div class="col-md-8 text-left">
			<form id="form1" name="form1" method="post"
				action="${path}/btg/insert.do">
				<br id="headspace"> <br id="headspace"> <br id="headspace">
				<br id="headspace"> <br id="headspace"> <br id="headspace">
				<div id="writecont">
					<c:if test="${dto.b_name=='패치노트'}">
						<img src="${path}/images/btg_offer2.JPG"
							style="width: 880px; height: 100%;">
					</c:if>
					<c:if test="${dto.b_name=='공략/팁'}">
						<img src="${path}/images/btg_offer3.JPG"
							style="width: 880px; height: 100%;">
						<table id="Notice">
							<tr>
								<th>★배틀그라운드 Player Agora 공략 / 팁 게시판이란? ★</th>
							</tr>
							<tr>
								<td>공략 / 팁 게시판은 서로 알고있는 정보를 공유하는 게시판 입니다.<br> 에란겔,
									미라마, 비켄디, 사녹과 같은 전장에서 살아남는 방법을 공유해보세요.<br> <br> 클랜 을
									통해 함께할 인원을 모집할 수도 있으니 많은 이용 바랍니다.<br> <br> <br>
									<label>■ 배틀그라운드 Player Agora 공략 / 팁 게시판 이용 시 주의사항</label><br>
									<br> - 대리 혹은 대리 듀오 관련 게시물을 작성할 시 이유여하를 막론하고 1개월 간 이용 정지
									처리됩니다.<br> - 그 외에도 계정 대여 및 판매글에 대한 게시물과 아이템 거래 관련 게시물, 패작
									파티 글 작성 역시<br> - 무통보 삭제 및 이용 제재 조치 되오니 불이익을 받지 않도록 유의하시기
									바랍니다.<br> - '불법 프로그램'에 대한 정보, 설명의 글 역시 제재의 대상이 됩니다.
								</td>
							</tr>
						</table>
					</c:if>
					<c:if test="${dto.b_name=='파티모집' }">
						<img src="${path}/images/btg_offer.JPG"
							style="width: 880px; height: 100%;">
						<table id="Notice">
							<tr>
								<th>★배틀그라운드 Player Agora 듀오 / 스쿼드 모집 게시판이란? ★</th>
							</tr>
							<tr>
								<td>듀오 / 스쿼드 모집 게시판은 서로 대화하며 게임을 즐길 파티도 찾고 인맥도 쌓는 게시판 입니다.<br>
									에란겔, 미라마, 비켄디, 사녹과 같은 전장을 함께할 동료를 구해보세요.<br> <br> 그
									외에도 클랜 을 통해 함께할 인원을 모집할 수도 있으니 많은 이용 바랍니다.<br> <br> <br>
									<label>■ 배틀그라운드 Player Agora 듀오 / 스쿼드 모집 게시판 이용 시 주의사항</label><br>
									<br> - 대리 혹은 대리 듀오 관련 게시물을 작성할 시 이유여하를 막론하고 1개월 간 이용 정지
									처리됩니다.<br> - 그 외에도 계정 대여 및 판매글에 대한 게시물과 아이템 거래 관련 게시물, 패작
									파티 글 작성 역시<br> - 무통보 삭제 및 이용 제재 조치 되오니 불이익을 받지 않도록 유의하시기
									바랍니다.<br> - '불법 프로그램'에 동조할 팀/팀원을 구하는 글도 제재의 대상이 됩니다.
								</td>
							</tr>
						</table>
					</c:if>
					<table>
						<tr id="C_head">
							<th style="">[ ${dto.nick} ]</th>
							<th>${dto.title}</th>
							<th style="float: right; margin-right: 15px;">조회수 :
								${dto.viewcnt}</th>
						</tr>
						<tr>
							<td colspan="3">
								<div
									style="width: 850px; min-height: 400px; padding: 20px; text-align: left;"
									id="posts">
									<pre>${dto.posts}</pre>
								</div>
							</td>
						<tr>
						<tr>

							<td colspan="3">
								<div>
									<div>
										<a href="https://pubg.game.daum.net/pubg/index.daum"
											target="_blank" id="main-banner"><img
											src="../images/btg_addImg.jpg"
											style="max-width: 840px; background-size: cover;"> </a>
									</div>
									<div id="uploadedList"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<div style="width: 700px; text-align: center;">
									<!-- 수정,삭제에 필요한 글번호를 hidden 태그에 저장 -->
									<input type="hidden" name="bno" value="${dto.bno}">
									<!-- 본인만 수정,삭제 버튼 표시 -->
									<c:if test="${sessionScope.userid == dto.writer}">
										<button type="button" id="btnDelete">삭제</button>
									</c:if>
									<a onclick="location.href='list1.do'"><button type="button">목록</button></a>
								</div>
							</td>
						</tr>
					</table>
					<script>
						//삭제 버튼
						$("#btnDelete")
								.click(
										function() {
											if (confirm("삭제하시겠습니까?")) {
												document.form1.action = "${path}/btg/delete.do";
												document.form1.submit();
											}
										});
					</script>
					<!-- 댓글 작성 -->
					<div>
						<c:if test="${sessionScope.userid != null }">
							<textarea rows="5" cols="80" id="replytext"
								placeholder="댓글을 작성하세요"
								style="width: 100%; max-width: 1000px; margin-left: auto; margin-right: auto;"></textarea>
							<br>
							<button type="button" id="btnReply">댓글쓰기</button>
						</c:if>
					</div>
					<!-- 댓글 목록 -->
					<div id="listReply"
						style="width: 100%; max-width: 850px; margin-left: 15px; margin-right: auto; text-align: left;"></div>
				</div>
			</form>
		</div>
		<%@ include file="../include/test.jsp"%>

	</div>
</body>
</html>


