  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" 
value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %> 
<%@ include file="../include/header.jsp" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="favicon.ico" />
<title>Player Agora</title>
<meta charset="utf-8">
<link rel="canonical" href="https://getbootstrap.com/docs/4.4/examples/sign-in/">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
 integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="apple-touch-icon" sizes="180x180"
   href="images/favicon/favicon_io/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32"
   href="images/favicon/favicon_io/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16"
   href="images/favicon/favicon_io/favicon-16x16.png">
<link rel="manifest" href="/site.webmanifest">
<style>
.bd-placeholder-img {
font-size: 1.125rem;
text-anchor: middle;
-webkit-user-select: none;
-moz-user-select: none;
-ms-user-select: none;
user-select: none;
}

@media (min-width: 768px) {
.bd-placeholder-img-lg {
font-size: 3.5rem;
        }
      }
      html,
body {
  height: 100%;
}

body {
  display: -ms-flexbox;
  display: flex;
  -ms-flex-align: center;
  align-items: center;
  padding-bottom: 40px;
  background-color: #f5f5f5;
}

.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}
.form-signin .checkbox {
  font-weight: 400;
}
.form-signin .form-control {
  position: relative;
  box-sizing: border-box;
  height: auto;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="text"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>

</head>
   <body class="text-center">
     <%@ include file="../include/headerBody.jsp" %>
    <form class="form-signin" name="formLog" method="post">
  <a href="http://localhost/teamProject/"><img class="mb-4" src="../images/Logo-shrink.JPG" alt="" width="72" height="72"></a>
  <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
  <label for="inputEmail" class="sr-only">Userid</label>
  <input id="userid" class="form-control" name="userid" placeholder="아이디" required autofocus>
  <label for="inputPassword" class="sr-only">Password</label>
  <input type="password" id="pwd" class="form-control" name="pwd" placeholder="비밀번호" required>

           <c:if test="${message == 'error' }">
            <script type="text/javascript">
            alert('아이디 혹은 비밀번호가 일치하지않습니다.')
            </script>
         </c:if>
  <button class="btn btn-lg btn-primary btn-block" id="homeLogin" type="button">로그인</button>
  <button class="btn btn-lg btn-primary btn-block" id="btnJoin" type="button">회원가입</button>
  <p class="mt-5 mb-3 text-muted">&copy; 2019-2020</p>
</form>
<script src="include/jquery-3.4.1.min.js"></script>
      <script src="include/script.js"></script>
</body>
</html>