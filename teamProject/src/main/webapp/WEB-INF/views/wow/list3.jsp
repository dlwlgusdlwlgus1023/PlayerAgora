<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>World Of Warcraft</title>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/side_banner.jsp"%>
<%@ include file="../include/searchCss.jsp"%>
<style>
body {
	background-image: url("../images/wow2.jpg");
	width: 100%;
	height: 100%;
	background-attachment: fixed;
}

#btnWrite {
	background-image: url("../images/writeImg.jpg");
	width: 100%;
	height: 100%;
	background-size: cover;
}

#btnWriteDiv {
	width: 83px;
	height: 30px;
	float: right;
	margin: 3px;
}

table {
	width: 100%;
	border: 1px solid;
	border-collapse: collapse;
	border-color: gray;
}

th, td {
	border-bottom: 1px solid;
	padding: 10px;
	border-color: gray;
}

#form1 {
	margin-top: 20px;
}

tr th {
	background-color: gray;
	color: white;
	border-color: gray;
}

table tr {
	border-color: gray;
}

#bo_style td a:link {
	text-decoration: none;
	color: black;
}

#bo_style td a:visited {
	text-decoration: none;
	color: black;
}

#bo_style:hover {
	background-color: #e6e6f2;
	text-decoration: none;
}
</style>
<script>
	$(function() {
		$("#btnWrite").click(function() {
			location.href = "${path}/wow/write3.do";
		});
	});
	function list(page) {
		location.href = "${path}/wow/list3.do?curPage=" + page;
	}
</script>
</head>
<body>
	<div style="height: 100%; width: 100%">
		<%@ include file="../include/headerBody.jsp"%>
		<br> <br> <br>
		<div class="container-fluid text-center">
			<%@ include file="../include/left_menu.jsp"%>
			<div id="headbtn">
				<table>
					<tr>
						<td><a href="${path}/wow/list1.do">WOW</a></td>
						<td><a href="${path}/wow/list2.do">패치노트</a></td>
						<td style="background-color: gray;"><a
							href="${path}/wow/list3.do">공략/팁</a></td>
						<td><a href="${path}/wow/list4.do">파티모집</a></td>
						<td><a href="${path}/screenshot/listWow.do">스크린샷</a></td>
					</tr>
				</table>
			</div>
			<br id="headspace"><br id="headspace"><br id="headspace"><br id="headspace">
			<div class="col-md-9 text-left">

				<form id="form1" method="post" action="${path}/wow/list3.do">
					<%@ include file="../include/searchBody.jsp"%>
				</form>
				<table
					style="opacity: 0.8; background-color: white; margin-bottom: 15px;">
					<tr>
						<th>ID</th>
						<!-- 게시물번호 bno -->
						<th>구분</th>
						<!-- 세부게시판 b_name -->
						<th>제목</th>
						<!-- title -->
						<th>글쓴이</th>
						<!-- writer -->
						<th>조회</th>
						<!-- viewcnt -->
						<th>날짜</th>
						<!-- regdate -->
					</tr>
					<c:forEach var="row" items="${map.list3}">
						<tr id="bo_style">
							<c:if test="${row.b_name=='공략/팁'}">
								<td>${row.bno}</td>
								<td>${row.b_name}</td>
								<td><a href="${path}/wow/view.do?bno=${row.bno}">${row.title}</a>
									<c:if test="${row.cnt > 0}">
										<span style="color: red;">(${row.cnt})</span>
									</c:if></td>
								<td>${row.nick}</td>
								<td>${row.viewcnt}</td>
								<td><fmt:formatDate value="${row.regdate}"
										pattern="yyyy-MM-dd " /></td>
							</c:if>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6" align="center"><c:if
								test="${map.pager.curBlock > 1}">
								<a href="#" onclick="list('1')">[처음]</a>
							</c:if> <c:if test="${map.pager.curBlock > 1}">
								<a href="#" onclick="list('${map.pager.prevPage}')"> [이전]</a>
							</c:if> <c:forEach var="num" begin="${map.pager.blockBegin}"
								end="${map.pager.blockEnd}">
								<c:choose>
									<c:when test="${num == map.pager.curPage}">
										<!-- 현재 페이지인 경우 하이퍼링크 제거 -->
										<span style="color: red;">${num}</span>
									</c:when>
									<c:otherwise>
										<a href="#" onclick="list('${num}')">${num}</a>
									</c:otherwise>
								</c:choose>
							</c:forEach> <c:if test="${map.pager.curBlock < map.pager.totBlock}">
								<a href="#" onclick="list('${map.pager.nextPage}')">[다음]</a>
							</c:if> <c:if test="${map.pager.curPage < map.pager.totPage}">
								<a href="#" onclick="list('${map.pager.totPage}')">[끝]</a>
							</c:if></td>
					</tr>
				</table>

			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>

</body>
</html>