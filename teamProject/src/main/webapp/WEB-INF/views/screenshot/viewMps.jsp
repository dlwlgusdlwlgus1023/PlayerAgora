<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="shortcut icon" href="favicon.ico" />
<script src="../include/js/common.js"></script>
<style>
img {
	max-width: 100%;
	width: 80%;
}
.fileDrop {
	border: 2px solid #000;
	color: #000;
	position: relative;
	height: 150px;
}
.fileDrop:focus {
	border: 2px solid #000;
	color: #000;
	position: relative;
	height: 150px;
}

.fileDrop-desc {
	position: absolute;
	margin: 0 auto;
	left: 0px;
	top : 43px;
	right: 0;
	text-align: center;
	font-size: 20px;
}
.dropzone, .dropzone:focus {
	position: absolute;
	outline: none !important;
	width: 100px;
	height: 150px;
	cursor: pointer;
	opacity: 1;
}

.fileDrop:hover {
	background-color: rgba(0,0,0,0.2);
}

.dropzone.dragover {
	background-color: #ecf0f5;
}

#down {
	margin : 10px;
	color: white;
	text-shadow : -1px 0 #000, 0 1px #000, 1px 0 #000, 0 -1px #000; color:white;

}


/*CSS for a really simple responsive grid*/
body{font-family:Open Sans; color:#555555;}
h1{font-size:24px; font-weight:normal; margin:0.4em 0;}

.container { width: 100%; margin: 0 auto; }
.container .row { float: left; clear: both; width: 100%; }
.container .col { float: left; margin: 0 0 1.2em; padding-right: 1.2em; padding-left: 1.2em; }
.container .col.three { width: 100%; }
@media screen and (min-width: 767px) {
  .container{width: 100%; max-width: 1000px; margin: 0 auto;}
  .container .row{width:100%; float:left; clear:both;}
  .container .col{float: left; margin: 0 0 1em; padding-right: .5em; padding-left: .5em;}
  .container .col.three { width: 24.99%; }
}

a{text-decoration:none;}

.btn {font-size: 18px; white-space:nowrap; width:100%; padding:.8em 1.5em; font-family: Open Sans, Helvetica,Arial,sans-serif; line-height:18px; display: inline-block;zoom: 1; color: #fff; text-align: center; position:relative; -webkit-transition: border .25s linear, color .25s linear, background-color .25s linear; transition: border .25s linear, color .25s linear, background-color .25s linear;}

/*DARK BUTTON STYLES*/		
.btn.btn-dark{background-color: #2c3d51; border-color: #2c3d51; -webkit-box-shadow: 0 3px 0 #080c0f; box-shadow: 0 3px 0 #080c0f;}
.btn.btn-dark:hover{background-color:#202d3d; color: #aaa;}
.btn.btn-dark:active{top: 3px; outline: none; -webkit-box-shadow: none; box-shadow: none;}

.btn i {padding-right:0.8em; line-height:22px;}
.icon-only{padding: 1em;}
.icon-only i{padding-right:0; font-size:22px; line-height:22px; }

		
</style>

<script src="../include/jquery-3.4.1.min.js"></script>
<style type="text/css">
body{
	background-image: url("../images/mps2.jpg");
	width: 100%;
	height: 100%;
	background-attachment: fixed;
}
table {
	
	border: 1px solid;
	border-collapse: collapse;
	border-color: gray;
}
th, td {
	border-bottom: 0px solid;
	padding: 10px;
	border-color: gray;
}

tr th {
	background-color: gray;
	color: white;
	border-color: gray;
}

table tr {
	background-color : rgba(255,255,255,0.9);
	border-color: gray;
}

</style>

</head>
<%@ include file="../include/header.jsp" %>
<%@ include file="reply_script.jsp" %>
<%@ include file="../include/side_banner.jsp" %>
<body>

	<div style="height: 100%; width: 100%">
	<%@ include file="../include/headerBody.jsp" %>
		<div class="container-fluid text-center">
			<div class="row content"><br>
				<%@ include file="../include/left_menu.jsp" %>

				<br> <br> <br> <br> <br>
				<div class="col-md-9 text-left"id="screen">
			<form id="form1" name="form1" method="post">
				                           
<table style="width: 100%; max-width: 1000px; margin-left: auto;margin-right: auto; background-color: white;" >
<tr style="height: 50px;"><th style="width: 70%; min-width : 201px; border: 1px solid black;" >[<span class="fa fa-gamepad"></span>&nbsp;${dto.game}]&nbsp;${dto.title} </th>
<th style="width: 15%; min-width : 91px; border: 1px solid black; text-align: center;"><span class="glyphicon glyphicon-user"></span>작성자 &nbsp; &nbsp;${dto.nick}</th>
<th style="width: 15%; min-width : 91px; border: 1px solid black; text-align: center;"><span class="glyphicon glyphicon-eye-open"></span>조회수 &nbsp; &nbsp; ${dto.viewcnt}</th></tr>
<tr ><td class="uploadedList" colspan="3" style="width: 80%; text-align: center; border-bottom: none;">
</td ></tr>
<tr ><td style="text-align: left; padding: 5%;" colspan="3">&nbsp;&nbsp;${dto.posts}</td></tr>

		
		<!-- 본인만 수정,삭제 버튼 표시 -->
<tr><td colspan="3">
<div>
<input type="hidden" name="bno" value="${dto.bno}">
		<c:if test="${sessionScope.userid == dto.writer}">
		
			<button type="button" id="btnDelete" class="btn btn-dark">게시글 삭제</button>
		</c:if>
		</div>
		</td></tr>		
		<tr><td colspan="3">
		<div style="width: 100%; max-width: 1000px; margin-left: auto; margin-right: auto; ">
		<div class="fileDrop" style="overflow: auto;">
		<div class="filelist" id="down"></div>
		<div class="fileDrop-desc">
			<i class="glyphicon glyphicon-download-alt" style="color: #000"></i>
			<p>첨부파일 리스트</p>
		</div>
		</div>
		</div></td></tr>
	</table>

		<div style="width: 100%; max-width: 1000px; margin-left: auto; margin-right: auto;">
		<div class="col three">
		<a onclick="location.href='listMps.do'"  class="btn btn-dark" >목록</a>		
		</div>
		</div>
		<br>
		
	
<!-- 댓글 작성 -->
<div style="width: 100%; max-width: 1000px; margin-left: auto; margin-right: auto;"> 
	 <c:if test="${sessionScope.userid != null }">
	 	<textarea rows="5" cols="80" id="replytext" placeholder="댓글을 작성하세요"
	 	 style="width: 100%; max-width: 1000px; margin-left: auto; margin-right: auto; margin-bottom: 0px;"></textarea>
			<a id="btnReply" class="btn btn-dark" >댓글작성<i class="fa fa-pencil"></i></a>			
	 </c:if>
	 
	 <c:if test="${sessionScope.userid == null }">
	 <textarea rows="2" cols="80" id="replytext" placeholder="댓글입력은 로그인 후 가능합니다." disabled="disabled"
	 	 style="width: 80%; max-width: 1000px; height : 51.75px; margin-left: auto; margin-right: auto; margin-bottom: 0px; float: left;"></textarea>
	 <a class="btn btn-dark" href="http://localhost/teamProject/member/login.do" style="width: 20%;  float:right; text-align: center;">로그인<span class="glyphicon glyphicon-log-in" ></span></a>	
	 	
	 </c:if>
</div>
<!-- 댓글 목록 -->
<div style="width: 100%; max-width: 1000px; margin-left: auto; margin-right: auto;"> 
<div id="listReply"></div>
</div>
</form>
</div>
				</div>
			</div>
			<%@ include file="../include/footer.jsp" %>
		</div>

							

</body>
<script>

$(".fileDrop").on("dragenter dragover", function(event){
	event.preventDefault();
});
$(".fileDrop").on("drop",function(event){
	//drop이 될 때 기본 효과를 막음
	event.preventDefault();
	//첨부파일 배열(여러개를 동시에 선택해서 드래그 할 수 도 있기때문에 한개만 처리하도록 조치)
	var files=event.originalEvent.dataTransfer.files;
	var file=files[0]; //첫번째 첨부파일
	var formData=new FormData(); //폼 객체
	formData.append("file",file); //폼에 file 변수 추가
	//서버에 파일 업로드(백그라운드에서 실행됨)
	//아래 contentType: false는  multipart/form-data로 처리되는것과 같음
	$.ajax({
		type: "post",
		url: "${path}/upload/uploadAjax",
		data: formData,
		dataType: "text",
		processData: false,
		contentType: false, 
		success: function(data,status,req){
			console.log("data:"+data); //업로드된 파일 이름
			console.log("status:"+status); //성공,실패 여부
			console.log("req:"+req.status);//요청코드값

			var str1="";
			if(checkImageType(data)){//이미지 파일
				str1="<div><a href='${path}/upload/displayFile?fileName="
					+getImageLink(data)+"'>";
			str1+="<img src='${path}/upload/displayFile?fileName="
					+data+"'></a>"; 
				}else{//이미지가 아닌 경우
					str1="<div>";
					str1+="<a href='${path}/upload/displayFile?fileName="
							+data+"'>"+getOriginalName(data)+"</a>";
					}
			str1+="<span data-src="+data+">[ ✘ ]</span></div>";
			$(".uploadedList").append(str1);
		}
	});
});//fileDrop 함수



listUpload();

//첨부파일 리스트를 출력하는 함수
function listUpload(){
$.ajax({
	type: "post",
	url: "${path}/screenshot/getUpload/${dto.bno}",
	success: function(list){
//Controller에서 List<String>타입으로 넘어온 값을 처리하기 위해 json으로 처리
		// list : json
		//console.log(list);
		$(list).each(function(){
			var fileInfo=getFileInfo(this);
			//console.log(fileInfo);
			var str1 = "<img src='"+fileInfo.getLink+"'><br>";
			var br = "<br>";
			var html="<div><a href='"+fileInfo.getLink+"' style='color : white; '>"
			+fileInfo.fileName+"</a></div>&nbsp;&nbsp;";
		$(".uploadedList").append(br+str1);
		$(".filelist").append(html);
	});
}
});
}



$("#btnDelete").click(function(){
	if(confirm("삭제하시겠습니까?")){
		document.form1.action="${path}/screenshot/deleteMps.do";
		document.form1.submit();
	}
});
</script>
</html>


	