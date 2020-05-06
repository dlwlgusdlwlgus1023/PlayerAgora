<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
<link rel="stylesheet" href="css/noralize.css">
<link rel="stylesheet" href="css/master.css">

<link rel="manifest" href="/site.webmanifest">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<%@ include file="../include/header.jsp" %>
<script type="text/javascript">
function execPostCode() {
    new daum.Postcode({
        oncomplete: function(data) {
           // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

           // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
           // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
           var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
           var extraRoadAddr = ''; // 도로명 조합형 주소 변수

           // 법정동명이 있을 경우 추가한다. (법정리는 제외)
           // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
           if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
               extraRoadAddr += data.bname;
           }
// 건물명이 있고, 공동주택일 경우 추가한다.
           if(data.buildingName !== '' && data.apartment === 'Y'){
              extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
           }
           // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
           if(extraRoadAddr !== ''){
               extraRoadAddr = ' (' + extraRoadAddr + ')';
           }
           // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
           if(fullRoadAddr !== ''){
               fullRoadAddr += extraRoadAddr;
           }

           // 우편번호와 주소 정보를 해당 필드에 넣는다.
           console.log(data.zonecode);
           console.log(fullRoadAddr);
           
           
           $("[name=addr1]").val(data.zonecode);
           $("[name=addr2]").val(fullRoadAddr);
           
           /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
           document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
           document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
       }
    }).open();
}

function check() {
   //아이디 체크
   var userid = document.getElementById("userid");
   if (userid.value == "") {
      alert("아이디는 필수 입력입니다.");
      userid.focus();
      return;
   }

   var pwd = document.getElementById("pwd");
   if (pwd.value == "") {
      alert("비밀번호는 필수 입력입니다.");
      pwd.focus();
      return;
   }
   
   
   //이름 체크
   var name = document.getElementById("name");
   if (name.value == "") {
      alert("이름을 입력하세요.");
      name.focus();
      return;
   }
   
   //이메일 체크
   var email = document.getElementById("email");
   if (email.value == "") {
      alert("이메일을 입력하세요.");
      email.focus();
      return;
   }
   var nick = document.getElementById("nick");
   if (nick.value == "") {
      alert("닉네임을 입력하세요.");
      nick.focus();
      return;
   } 
   var phone= document.getElementById("phone");
   if (phone.value == "") {
      alert("전화번호 입력하세요.");
      phone.focus();
      return;
   }      
   var birth= document.getElementById("birth");
   if (birth.value == "") {
      alert("생년월일을 입력하세요.");
      birth.focus();
      return;
   }  
   
   //주소 체크
   var addr1 = document.getElementById("addr1");
   if (addr1.value == "") {
      alert("우편번호 찾기를 누르세요.");
      addr1.focus();
      return;
   }
   var addr3 = document.getElementById("addr3");
   if (addr3.value == "") {
      alert("상세주소를 입력하세요");
      addr3.focus();
      return;
   }   
   document.form1.submit();
   alert("회원가입에 성공하셧습니다. 로그인하세요.");
}

</script>
</head>
<body>
   <div style="height: 100%; width: 100%">   
	<%@ include file="../include/headerBody.jsp"%>
      <div class="container-fluid text-center">
          <div class="col-xs-12 col-sm-12"><br><br><br><br>
    <h2>&nbsp;</h2> 
    
    </div>        
     
         <h2  style="text-align: center;" class="text-center">회원가입</h2>
    <div class="col-xs-12 col-sm-12">
         
        <p>&nbsp;</p>
         
         <form name="form1" class="form-horizontal" method="post" action="${path}/member/insert.do" style="margin-left: auto;margin-right: auto; ">
         <div class="form-group">
            <div class="col-sm-3 control-label">
                <label >아이디</label>
            </div>
            <div class="col-sm-6 text-left">
                <input type="text" class="form-control" name="userid" id="userid" placeholder="아이디">
            </div>
         </div>
          
         <div class="form-group">
            <div class="col-sm-3 control-label">
                <label >패스워드</label>
            </div>
            <div class="col-sm-6">
                <input type="password" class="form-control" name="pwd" id="pwd"placeholder="비밀번호">
            </div>
         </div>
          
         
         <div class="form-group">
            <div class="col-sm-3 control-label">
                <label>이름</label>
            </div>
            <div class="col-sm-6">
                <input type="text" class="form-control" name="name" id="name" placeholder="이름">
            </div>
         </div>        
         
          
         <div class="form-group">
            <div class="col-sm-3 control-label">
                <label >이메일</label>
            </div>
            <div class="col-sm-6">
                <input type="email" class="form-control" name="email" id="email"placeholder="이메일">
            </div>
         </div>  
          
         <div class="form-group">
            <div class="col-sm-3 control-label">
                <label>닉네임</label>
            </div>
            <div class="col-sm-6">
                <input type="text" class="form-control" name="nick" id="nick" placeholder="닉네임">
            </div>
         </div>           
      
          <div class="form-group">
            <div class="col-sm-3 control-label">
                <label >전화번호</label>
            </div>
            <div class="col-sm-6">
                <input type="tel" class="form-control" name="phone" id="phone" placeholder="전화번호">
            </div>
		</div>   
          <div class="form-group">
            <div class="col-sm-3 control-label">
                <label >생년월일</label>
            </div>
            <div class="col-sm-6">
                <input type="date" class="form-control" name="birth" id="birth" >
            </div>
		</div> 	
		
          <div class="form-group">
            <div class="col-sm-3 control-label">
                <label >성별</label>
            </div>
            <div class="col-sm-6">
               <select name="sex" id="sex" data-role="slider" class="form-control">
               <option value="male">남자</option>
               <option value="female">여자</option>
            </select>
            </div>
		</div>		
		
            
                      
          <div class="form-group">
            <div class="col-sm-3 control-label">
                <label  >주소</label>
            </div>
            <div class="col-sm-3">
			<input class="form-control"
                placeholder="우편번호"
               name="addr1" id="addr1" type="text" readonly="readonly">
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
               name="addr2" id="addr2" type="text" readonly="readonly" />
            </div>
         </div>
           <div class="form-group">
            <div class="col-sm-3 control-label">
            </div>
            <div class="col-sm-6">
			  <input class="form-control" placeholder="상세주소" name="addr3"
               id="addr3" type="text" />
            </div>
         </div>
         <div class="form-group" >
            <div class="col-sm-12  text-center">
            <input type="button" onclick=check(); value="회원가입" class="btn btn-success">
            <input type="reset" onclick="javascript:history.back()" value="취소" class="btn btn-warning">
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