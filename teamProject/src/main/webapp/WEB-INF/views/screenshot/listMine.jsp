<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script type="text/javascript">
    $(function(){
		var str1="";
			str1="<div><a href='${path}/upload/displayFile?fileName="
				+getImageLink(data)+"'>";
		str1+="<img src='${path}/upload/displayFile?fileName="
				+data+"'></a>"; 
		str1+="<span data-src="+data+">[ ✘ ]</span></div>";
		$(".uploadedList").append(str1);
    });

    </script>
<style type="text/css">

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


body{
	background-image: url("../images/fifa.jpg");
	width: 100%;
	height: 100%;
	background-attachment: fixed;
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

tr th {
	background-color: gray;
	color: white;
	border-color: gray;
}

table tr {
	border-color: gray;
}

/* 페이징 */
.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  border: 1px solid #CCC;
}



.pagination a:hover:not(.active) {background-color: #ddd;}

.pagination a:first-child {
  border-top-left-radius: 10Px;
  border-bottom-left-radius: 10px;
}

.pagination a:last-child {
  border-top-right-radius: 10px;
  border-bottom-right-radius: 10px;
}

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
  border-radius: 5px 0 0 5px ;  
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




        
</style>
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
<script src="../include/jquery-3.4.1.min.js"></script>
<script>
$(function(){
	$("#btnWrite").click(function(){
		if(${sessionScope.userid != null }){
		location.href="${path}/teamProject/screenshot/write.do";
		} else {
		alert('글쓰기는 로그인 후 가능합니다.');
		}
	});
});
function list(page){
	location.href="${path}/teamProject/screenshot/list.do?curPage="+page;
	
} 

function listUpload(){
	$.ajax({
		type: "post",
		url: "${path}/screenshot/getUpload/${row.bno}",
		success: function(list){
// Controller에서 List<String>타입으로 넘어온 값을 처리하기 위해 json으로 처리
			// list : json
			//console.log(list);
			$(list).each(function(){
				var fileInfo=getFileInfo(this);
				//console.log(fileInfo);
				var str1 = "<img src='"+fileInfo.getLink+"'><br>";
				var br = "<br>";
				var html="<div><a href='"+fileInfo.getLink+"'>"
					+fileInfo.fileName+"</a></div>&nbsp;&nbsp;";
			$(".uploadedList").append(str1);
		});
	}
});
}

</script>
<%@ include file="../include/header.jsp" %>
<%@ include file="../include/side_banner.jsp"%>

<body>
	
	<div style="height: 100%; width: 100%">
	<%@ include file="../include/headerBody.jsp" %>
		<div class="container-fluid text-center">
			<div class="row content"><br>
				<%@ include file="../include/left_menu.jsp" %>		

				<br> <br> <br> <br> <br>
				<div class="col-md-10 text-left">

				
<!-- 검색폼 -->
<table style="background-color: rgba( 255, 255, 255, 0.9 ); width: 100%; max-width: 1054px; margin-left: auto;margin-right: auto;">



	<tr>
	
	<td style="text-align: center; padding-bottom: 20px; "colspan="3">
	
	<c:forEach var="row" items="${map.list}" >
		<div  style="width: 210px;  height: 210px; display : inline-block; background-size : 100% auto;  cursor:pointer; 
		background-color : rgba(0,0,0,0.5);  
		margin: 25px; ">
		<div style="position : relative; vertical-align : middle; line-height : 200px;" onclick="location.href='${path}/screenshot/view.do?bno=${row.bno}';">
		<img alt="오류" src="${path}/file${row.uploaddate}${row.fullname}" style="width: 100%; max-height: 200px; padding: 1px; padding-bottom: 0px;">
		<div style="top: -87px; width: 329px; height:0px; text-shadow : -1px 0 #000, 0 1px #000, 1px 0 #000, 0 -1px #000; color:white; position: absolute;">
		 <span class="glyphicon glyphicon-eye-open">  </span>&nbsp${row.viewcnt}&nbsp&nbsp
		 <span class="glyphicon glyphicon-comment"></span>&nbsp${row.cnt}
		 </div>
		 <div style="top: -87px; width: 70px; height:0px; text-shadow : -1px 0 #000, 0 1px #000, 1px 0 #000, 0 -1px #000; color:white; position: absolute;">
		NO.${row.bno}
		 </div>
		</div><div style="width: 210px; height: 40px; cursor:pointer;  middle;  background-color: white;
		border: 1px solid gray; overflow: hidden;" onclick="location.href='${path}/screenshot/view.do?bno=${row.bno}';">
		${row.title}  |<span class="glyphicon glyphicon-user">${row.nick}</span>
		</div>
		</div>
	</c:forEach>
		

	</td>
	</tr>
	<tr><td colspan="3" style="text-align: center;">
		<div class="pagination"style="text-align: center;">
			<c:if test="${map.pager.curBlock > 1}">
				<a href="#" onclick="list('1')">&laquo;</a>
			</c:if>
			<c:if test="${map.pager.curBlock > 1}">
				<a href="#" onclick="list('${map.pager.prevPage}')">
				[이전]</a>
			</c:if>
			<c:forEach var="num" 
				begin="${map.pager.blockBegin}"
				end="${map.pager.blockEnd}">
				<c:choose>
					<c:when test="${num == map.pager.curPage}">
					<!-- 현재 페이지인 경우 하이퍼링크 제거 -->
						<a style="color:red; text-decoration: none;">${num}</a>
					</c:when>
					<c:otherwise>
						<a href="#" onclick="list('${num}')">${num}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<c:if test="${map.pager.curBlock < map.pager.totBlock}">
				<a href="#" 
				onclick="list('${map.pager.nextPage}')">[다음]</a>
			</c:if>
			<c:if test="${map.pager.curPage < map.pager.totPage}">
				<a href="#" 
				onclick="list('${map.pager.totPage}')">&raquo;</a>
			</c:if>
			</div>
	
</td></tr>
</table>

</div>	
			</div>
		</div>
<br><br><br><br>
<%@ include file="../include/footer.jsp" %>
		
	</div>
</body>
</head>

</html>
