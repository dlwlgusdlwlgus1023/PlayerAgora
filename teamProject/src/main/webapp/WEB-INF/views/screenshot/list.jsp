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
table {
	width: 100%;
	border: 1px solid white;
	border-collapse: collapse;
	border-color: #eee;
}

th, td {
	border-bottom: 1px solid;
	padding: 10px;
	
	border-color: gray;
}

tr th {
	color: white;
	border-color: gray;
}

table tr {
	border-color: gray;
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

<body style="width: 100%; b">
	
	<div style="height: 100%; width: 100%;">
						<form name="form1" method="post" action="${path}/screenshot/list.do">
						
<table style=" width: 100%; max-width: 1054px; margin-left: auto;margin-right: auto;">

	<tr>
	
	<td style="text-align: center; padding-bottom: 20px; border-color : white;  background-color: #ccc;"colspan="3">
	
	<c:forEach var="row" items="${map.list}" >
		<div  style="width: 210px;  height: 210px; display : inline-block; background-size : 100% auto;  cursor:pointer; 
		background-color : rgba(0,0,0,0.5);  
		margin: 25px; ">
		<div style="position : relative; vertical-align : middle; line-height : 200px;" onclick="parent.location.href='${path}/screenshot/view${row.abb}.do?bno=${row.bno}';">
		<img alt="오류" src="${path}/file${row.uploaddate}${row.fullname}" style="width: 100%; max-height: 200px; padding: 1px; padding-bottom: 0px;">
		<div style="top: -87px; width: 329px; height:0px; text-shadow : -1px 0 #000, 0 1px #000, 1px 0 #000, 0 -1px #000; color:white; position: absolute;">
		 <span class="glyphicon glyphicon-eye-open">  </span>&nbsp${row.viewcnt}&nbsp&nbsp
		 <span class="glyphicon glyphicon-comment"></span>&nbsp${row.cnt}
		 </div>
		 <div style="text-align:left; margin-left:5px; top: -87px; width: 120px; height:0px; text-shadow : -1px 0 #000, 0 1px #000, 1px 0 #000, 0 -1px #000; color:white; position: absolute;">
		[${row.game}]
		 </div>
		</div><div style="width: 210px; height: 40px; cursor:pointer;  middle;  background-color: white;
		border: 1px solid gray; overflow: hidden;" onclick="parent.location.href='${path}/screenshot/view${row.abb}.do?bno=${row.bno}';">
		${row.title}  |<span class="glyphicon glyphicon-user">${row.nick}</span>
		</div>
		</div>
	</c:forEach>
		

	</td>
	</tr>

	
</table>

		</form>

			</div>
		
</body>
</head>

</html>
