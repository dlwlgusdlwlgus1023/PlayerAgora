<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sudden Attack</title>
<%@ include file="../include/header.jsp"%>
</head>
<body>
	<%@ include file="../include/headerBody.jsp"%>
	<%
		pageContext.setAttribute("newLineChar", "\n");
	%>
	<table id="reply_sud">
		<!-- fn: header.jsp의 jstl -->
		<c:forEach var="row" items="${list}">
			<c:set var="str" value="${fn:replace(row.replytext,'<','&lt;') }" />
			<c:set var="str" value="${fn:replace(str,'>','&gt;') }" />
			<c:set var="str" value="${fn:replace(str,'  ','&nbsp;&nbsp;')}" />
			<c:set var="str" value="${fn:replace(str,newLineChar,'<br>') }" />

			<%-- <c:set var="str" value="${fn:replace(str, '\\','<br>') }" /> --%>
			<!-- c:set 태그안에는 역슬래쉬를 쓸 수 없어서 별도로 처리해야함 -->
			<tr>
				<td>${row.nick}(<fmt:formatDate value="${row.regdate}"
						pattern="yyyy-MM-dd a HH:mm:ss" /> )
				</td>
			</tr>
			<tr>
				<td>${str}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>

