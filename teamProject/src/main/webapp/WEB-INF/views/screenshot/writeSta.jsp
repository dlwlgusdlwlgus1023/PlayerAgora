<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<script src="../include/js/common.js"></script>
<script src="../include/jquery-3.4.1.min.js"></script>
<script>
	$(function() {
		$("#btnSave").click(
				function() {
					var file = $("#file").length; // 구분 내용 
                    var title = $("#title").val();// 제목 내용
                    var posts = $("#posts").val();// 본문 내용
                    var bno = "${dto.bno}"; //게시물 번호
                    var param = {
                       "file" : file,
                       "bno" : bno,
                       "title" : title,
                       "posts" : posts
                    };
                    if ($("#title").val() == '') {
                        alert('제목을 입력하세요.');
                     } else if ($("#posts").val() == '' )  {
                        alert('내용을 입력하세요.');
                     } else if ($("#file").length == 0) {
                        alert('첨부할 스크린샷을 넣어주세요.')
                     } else {
					var str = "";
					// F12에서 올린 파일부분살펴보면 uploadedList 내부의 .file 태그 각각 반복
					$(".uploadedList .file").each(
							function(i) {
								console.log(i);
								//hidden 태그 구성
								str += "<input type='hidden' id='files[" + i
										+ "]' name='files[" + i + "]'	value='"
										+ $(this).val() + "'>";
							});
								str += "<input type='hidden' id='game' name='game'	value='스타크래프트'>";
								str += "<input type='hidden' id='abb' name='abb'	value='Sta'>";
					//폼에 hidden 태그들을 붙임
					$("#form1").append(str);
					document.form1.submit();
                     }
				});

		//드래그 기본 효과를 막음 .은 클래스 class=fileDrop, #은 id
		$(".fileDrop").on("dragenter dragover", function(event) {
			event.preventDefault();
		});
		$(".fileDrop")
				.on(
						"drop",
						function(event) {
							//drop이 될 때 기본 효과를 막음
							event.preventDefault();
							//첨부파일 배열(여러개를 동시에 선택해서 드래그 할 수 도 있기때문에 한개만 처리하도록 조치)
							var files = event.originalEvent.dataTransfer.files;
							var file = files[0]; //첫번째 첨부파일
							var formData = new FormData(); //폼 객체
							formData.append("file", file); //폼에 file 변수 추가
							//서버에 파일 업로드(백그라운드에서 실행됨)
							//아래 contentType: false는  multipart/form-data로 처리되는것과 같음
							$
									.ajax({
										type : "post",
										url : "../upload/uploadAjax",
										data : formData,
										dataType : "text",
										processData : false,
										contentType : false,
										success : function(data) {
											var fileInfo = getFileInfo(data);

											var str1 = "";
											if (checkImageType(data)) {//이미지 파일
												str1 = "<div style='display: inline-block;' ><a href='${path}/upload/displayFile?fileName="
														+ getImageLink(data)
														+ "'>";
												str1 += "<img src='${path}/upload/displayFile?fileName="
														+ data + "' style='margin-bottom : 23px; z-index : 2; position: relative;' ></a>";

												str1 += "<span style='font-size : 2.0em; color : black; top:-30px; left : -34px; text-shadow : -1px 0 #fff, 0 1px #fff, 1px 0 #fff, 0 -1px #fff; z-index : 3; ' data-src="+data+" class='glyphicon glyphicon-remove'></span>";

												str1 += "<input type='hidden' id='file' name='file' class='file' value='"
														+fileInfo.fullName+"'></div>";
														

												$(".uploadedList").append(str1);
													
											} else {//이미지가 아닌 경우
												alert('스크린샷 게시판은 이미지 업로드만 가능합니다.');
											}

										}
									});
						});//fileDrop 함수

		//첨부파일 삭제 함수
		$(".uploadedList").on("click", "span", function(event) {//내부적으로 span태그가 클릭되면 삭제
			var that = $(this);//this는 현재 클릭한 태그, 즉 span태그
			$.ajax({
				url : "${path}/upload/deleteFile",
				type : "post",
				data : {//data: "fileName="+$(this).attr("data-src") 아래와 같음	
					fileName : $(this).attr("data-src")
				},
				dataType : "text",
				success : function(result) {
					if (result == "deleted") {
						that.parent("div").remove();//파일삭제되면 행전체<div>를 삭제처리
						//that은 span태그를 의미하는데 그 부모인 감싸고 있는 div태그를 지운다는 뜻
					}
				}
			});
		});

		function getOriginalName(fileName) {
			if (checkImageType(fileName)) { //이미지 파일이면 skip
				return;
			}
			var idx = fileName.indexOf("_") + 1; //uuid를 제외한 파일이름만 뽑음
			return fileName.substr(idx);
		}
		function getImageLink(fileName) {
			if (!checkImageType(fileName)) {//이미지 파일이 아니면 skip
				return;
			}
			//2018/08/25/s_f53e623b-24db-42f9-b607-9c04528056a5_apple-bg.jpg
			var front = fileName.substr(0, 12);//연월일 경로(0~11번째까지 자르고)
			var end = fileName.substr(14);// 14번째 문자열앞의 s_ 제거
			return front + end;
		}
		function checkImageType(fileName) {
			var pattern = /jpg|png|jpeg/i; //정규표현식(i는 대소문자 무시)
			return fileName.match(pattern); //규칙에 맞으면 true가 리턴
		}

	});
</script>
<style>
.glyphicon-remove:before {
    cursor: pointer;
}
body {
	background-image: url("../images/sta2.jpg");
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
.fileDrop {
	border: 2px solid #000;
	color: #000;
	position: relative;
	height: 150px;
	margin: 10px;
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
	left: 0;
	right: 0;
	text-align: center;
	width: 40%;
	top: 50px;
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

</head>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/side_banner.jsp"%>
<body>
<div style="height: 100%; width: 100%">
	<%@ include file="../include/headerBody.jsp"%>
	<div class="container-fluid text-center">
			<div class="row content"><br>
			<%@ include file="../include/left_menu.jsp" %>

				<br> <br> <br> <br> <br>
				<div class="col-md-9 text-left" id="screen">

				<form id="form1" name="form1" method="post" action="${path}/screenshot/insertSta.do">
			<div id="writecont">
			<img src="${path}/images/scboard.jpg"
			style="width: 880px; height: 100%;"> <br> <br>
			<table id="Notice" style="width: 100%; max-width: 880px;">
				<tr>
					<th>★ 스타크래프트 스크린샷 게시판이란? ★</th>
				</tr>
				<tr>
					<td>게시판에 링크하고 싶은 이미지가 많은데 한 게시물에 업로드 가능한 개수를 초과할 경우,
						또는 인장 꾸미기용 이미지를 업로드하고 싶을 때,
						이 게시판에 이미지를 업로드 한 후 복사해 해당 게시물에 붙여넣을 수 있습니다.<br> <br> <br>
						<label>▶ 스타크래프트 스크린샷 게시판 이용안내</label><br> <br> -
						해당 게임과 관련사항이 없는 스크린샷을 업로드시 불이익을 당할수 있습니다.<br>
						- 인장용 사진, 게시물에 링크하고 싶은 이미지 외의 게시물은 자제해주세요.<br>
						- Player Agora에 업로드한 이미지는 외부 사이트로의 링크가 허용되지 않으니 참고해주세요.
					</td>
				</tr>
			</table>
			<br>
			<div>
				제목 <input name="title" id="title" size="90" placeholder="제목을 입력하세요">
			</div>
			<div style="float: right;">작성자 : [ ${sessionScope.nick} ]</div>
			<br>
			<div>
				<textarea style="resize: none; width: 870px; height: 400px;"
					id="posts" name="posts" rows="3" cols="80" placeholder="내용을 입력하세요"></textarea>

			</div>
			<div>
			
				<div class="fileDrop" style="overflow:auto;">
					<div class="uploadedList" style="padding-top: 23px; "></div>
					<div class="fileDrop-desc">
						<i class="glyphicon glyphicon-download-alt" style="color: #000"></i>
						<p>업로드할 이미지를 드래그 해주세요!</p>
					</div>
				</div>

			</div>
						<div style="margin: 10px;">
						<div class="col three" style="width: 100%;">
						<button type="button" id="btnSave" class="btn btn-dark">게시물 작성 <i class="fa fa-pencil"></i></button>		
						</div>
						</div>	
						<div style="margin: 10px;">
						<div class="col three" style="width: 100%;">
						<a onclick="location.href='listSta.do'" class="btn btn-dark" >목록으로</a>		
						</div>
						</div>	
						<br><br>
		
			</div>
			</form>
			</div>
			</div>
			</div>
			</div>
				<%@ include file="../include/footer.jsp" %>
</body>
</html>
