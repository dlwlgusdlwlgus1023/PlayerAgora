<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainBody</title>
<style>

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
</head>
<body>
<hr>
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
		<c:forEach var="row" items="${map.list}">
			<tr id="bo_style">
				<td>${row.bno}</td>
				<td>${row.bord}</td>
				<td><a style="cursor: pointer;"
					onclick="parent.location.href='${path}/teamProject/${row.t_name}/view.do?bno=${row.bno}';">${row.title}</a>
					<c:if test="${row.cnt > 0}">
						<span style="color: red;">(${row.cnt})</span>
					</c:if></td>
				<td>${row.nick}</td>
				<td>${row.viewcnt}</td>
				<td><fmt:formatDate value="${row.regdate}"
						pattern="yyyy-MM-dd " /></td>
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
</body>
</html>