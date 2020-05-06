<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<script>
$(function(){
	$("#btnUpdate").click(function(){
		var pwd1 = prompt("정보수정을 원하시면 비밀번호를 입력해주세요."+"(영문으로 입력)");
		if(pwd1== "${dto.pwd}"){
		alert('정보가 변경되었습니다, 다시 로그인해주세요');	
		document.form1.action="${path}/member/update.do";
		document.form1.submit();
		}else{
		alert('비밀번호를 다시 확인해주세요.');
			
		}
	});
	$("#btnDelete").click(function(){
		var pwd1 = prompt("회원탈퇴를 원하시면 비밀번호를 입력해주세요."+"(영문으로 입력)");
		if(pwd1== "${dto.pwd}"){
			alert('회원탈퇴가 완료되었습니다.');
			document.form1.action="${path}/member/delete.do";
			document.form1.submit();
		} else {
			alert('비밀번호를 다시 확인해주세요.');
			
		}
	});
});
</script>
</head>
<body>
   <div style="height: 100%; width: 100%">   
	<%@ include file="../include/headerBody.jsp"%>
      <div class="container-fluid text-center">
          <div class="col-xs-10 col-sm-10">
    <h2>&nbsp;</h2> <br><br><br><br>
    </div>        
     
    <div class="col-xs-12 col-sm-12">
    <h2 class="text-center">회원정보수정</h2>
         
        <p>&nbsp;</p>
         
         <form name="form1" class="form-horizontal" method="post" action="${path}/member/insert.do" style="margin-left: auto;margin-right: auto; ">
         <div class="form-group">
            <div class="col-sm-3 control-label">
                <label >아이디</label>
            </div>
            <div class="col-sm-6 text-left">
                <input type="text" class="form-control" name="userid" id="userid" placeholder="아이디" value="${dto.userid }" readonly="readonly">
            </div>
         </div>
          
         <div class="form-group">
            <div class="col-sm-6">
                <input type="hidden" class="form-control" name="pwd" id="pwd" value="${dto.pwd }" >
            </div>
         </div>
         
          
         
         <div class="form-group">
            <div class="col-sm-3 control-label">
                <label>이름</label>
            </div>
            <div class="col-sm-6">
                <input type="text" class="form-control" name="name" id="name" placeholder="이름"value="${dto.name }"  >
            </div>
         </div>        
         
          
         <div class="form-group">
            <div class="col-sm-3 control-label">
                <label >이메일</label>
            </div>
            <div class="col-sm-6">
                <input type="email" class="form-control" name="email" id="email"placeholder="이메일" value="${dto.email }" >
            </div>
         </div>  
          
         <div class="form-group">
            <div class="col-sm-3 control-label">
                <label>닉네임</label>
            </div>
            <div class="col-sm-6">
                <input type="text" class="form-control" name="nick" id="nick" placeholder="닉네임" value="${dto.nick }" >
            </div>
         </div>           
      
          <div class="form-group">
            <div class="col-sm-3 control-label">
                <label >전화번호</label>
            </div>
            <div class="col-sm-6">
                <input type="tel" class="form-control" name="phone" id="phone" placeholder="전화번호" value="${dto.phone }" >
            </div>
		</div>   
          <div class="form-group">
            <div class="col-sm-3 control-label">
                <label >생년월일</label>
            </div>
            <div class="col-sm-6">
                <input type="date" class="form-control" name="birth" id="birth" value="${dto.birth }"  >
            </div>
		</div> 	
		
                      
          <div class="form-group">
            <div class="col-sm-3 control-label">
                <label  >주소</label>
            </div>
            <div class="col-sm-3">
			<input class="form-control"
                placeholder="우편번호"
               name="addr1" id="addr1" type="text" readonly="readonly" value="${dto.addr1 }" >
            </div>
            <div class="col-sm-4">
                        <button type="button" class="btn btn-default"
               onclick="execPostCode();">
               <i class="fa fa-search"></i> 우편번호 찾기
            </button>
         </div>
         </div>
            <div class="form-group">
            <div class="col-sm-3 control-label">
            </div>
            <div class="col-sm-6">
			 <input class="form-control" style="top: 5px;" placeholder="도로명 주소"
               name="addr2" id="addr2" type="text" readonly="readonly" value="${dto.addr2 }" />
            </div>
         </div>
           <div class="form-group">
            <div class="col-sm-3 control-label">
            </div>
            <div class="col-sm-6">
			  <input class="form-control" placeholder="상세주소" name="addr3"
               id="addr3" type="text" value="${dto.addr3 }" />
            </div>
         </div>
         <div class="form-group">
         <c:if test="${join_date != null }">
			<fmt:formatDate value="${join_date}" 
				pattern="yyyy-MM-dd HH:mm:ss" />
		</c:if>
		
		<fmt:formatDate value="${dto.join_date}" 
			pattern="yyyy-MM-dd HH:mm:ss" />
			</div>
         <div class="form-group" >
            <div class="col-sm-12  text-center">
            <input type="button" id="btnUpdate" value="정보수정" class="btn btn-success">
            <input type="reset" id="btnDelete" value="회원탈퇴" class="btn btn-warning">
            <input type="reset" onclick="javascript:history.back()" value="뒤로가기" class="btn btn-default">
            			<div style="color: red;">${message}</div>	
            </div>
         </div>      
      
   </form>

         </div>
      </div>
    </div>
 

 

      <br><br><br><br><br>

<%@ include file="../include/footer.jsp" %>
      <script src="../include/jquery-3.4.1.min.js"></script>
      <script src="../include/script.js"></script>
   
</body>
</html>
	