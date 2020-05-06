<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-md-2 sidenav" id="side1" >
	<br> <br> <br> <br> <br>
	<div style="background-color: rgba(255,255,255,.8); padding: 15px;">
	<form name="formLog" method="post" id="loginform"style="margin-left: auto;margin-right: auto; ">
		<c:if test="${sessionScope.userid != null }">
		<legend style="text-align: left;">Profile</legend>
		<div style="text-align: left;">
		<p style="font-size: 1.5em; font-weight: bold;">${sessionScope.nick} 님</p>
		<p>${sessionScope.userid}(${sessionScope.name})</p>
		<a href="${path}/member/view.do?userid=${sessionScope.userid}">정보수정</a>
		</div>
		    <input type="button" onclick="location.href = '${path}/member/logout.do'" class="btn btn-default btn-block" value="로그아웃" >
	
		</c:if>
		<c:if test="${sessionScope.userid == null }">
 		<legend >로그인</legend>
              <div class="input-group">
             <span class="input-group-addon"><i class="fa fa-user"></i></span>
              <input type="text" name="userid" id="userid" value='' placeholder="아이디" class="form-control" />
              <input type="button" id="btnLogin" class="btn btn-default btn-block" value="로그인" >
              </div>
		 <div class="input-group">
		    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
		    <input type="password" name="pwd" id="pwd"" value='' placeholder="Password" class="form-control" />
		    <input type="button" id="btnJoin" class="btn btn-default btn-block" value="회원가입" >
		 </div>		
			<c:if test="${message == 'error' }">
				<script type="text/javascript">
					alert('아이디 혹은 비밀번호가 일치하지않습니다.')
					location.href = 'http://localhost/teamProject/'
				</script>
			</c:if>
			<div id="fulllogin">
		 	<input type="button" id="btnLogin1" class="btn btn-default btn-block" value="로그인" >
		 	<input type="button" id="btnJoin1" class="btn btn-default btn-block" value="회원가입" >
		 	</div>
		 	<br>
		</c:if>
	</form>
	</div>
	<div>
		<a target="_blank" href="http://www.danawa.com/"> <img
			id="banner_danawa" src="${path}/images/danawa1.jpg"
			style="margin-top: 20px; width: 100%; height: 100%; max-width: 270px;">
		</a>
	</div>
	<div id="sidebtn">
		<ul>
			<li
				style="font-weight: bold; background-color: black; opacity: 0.8; padding-left: 28px; line-height: 37px;"><a
				href="${path}/btg/list1.do">배틀그라운드</a></li>
			<li><a href="${path}/btg/list2.do">패치노트</a></li>
			<li><a href="${path}/btg/list3.do">공략/팁</a></li>
			<li><a href="${path}/btg/list4.do">파티모집</a></li>
			<li><a href="${path}/screenshot/listBtg.do">스크린샷</a></li>
		</ul>
		<ul>
			<li
				style="font-weight: bold; background-color: black; opacity: 0.8; padding-left: 28px; line-height: 37px;"><a
				href="${path}/sud/list1.do">서든어택</a></li>
			<li><a href="${path}/sud/list2.do">패치노트</a></li>
			<li><a href="${path}/sud/list3.do">공략/팁</a></li>
			<li><a href="${path}/sud/list4.do">파티모집</a></li>
			<li><a href="${path}/screenshot/listSud.do">스크린샷</a></li>
		</ul>
		<ul>
			<li
				style="font-weight: bold; background-color: black; opacity: 0.8; padding-left: 28px; line-height: 37px;"><a
				href="${path}/ovw/list1.do">오버워치</a></li>
			<li><a href="${path}/ovw/list2.do">패치노트</a></li>
			<li><a href="${path}/ovw/list3.do">공략/팁</a></li>
			<li><a href="${path}/ovw/list4.do">파티모집</a></li>
			<li><a href="${path}/screenshot/listOve.do">스크린샷</a></li>
		</ul>
		<ul>
			<li
				style="font-weight: bold; background-color: black; opacity: 0.8; padding-left: 28px; line-height: 37px;"><a
				href="${path}/wow/list1.do">월드오브워크래프트</a></li>
			<li><a href="${path}/wow/list2.do">패치노트</a></li>
			<li><a href="${path}/wow/list3.do">공략/팁</a></li>
			<li><a href="${path}/wow/list4.do">파티모집</a></li>
			<li><a href="${path}/screenshot/listWow.do">스크린샷</a></li>
		</ul>
		<ul>
			<li
				style="font-weight: bold; background-color: black; opacity: 0.8; padding-left: 28px; line-height: 37px;"><a
				href="${path}/loa/list1.do">로스트아크</a></li>
			<li><a href="${path}/loa/list2.do">패치노트</a></li>
			<li><a href="${path}/loa/list3.do">공략/팁</a></li>
			<li><a href="${path}/loa/list4.do">파티모집</a></li>
			<li><a href="${path}/screenshot/listLoa.do">스크린샷</a></li>
		</ul>
		<ul>
			<li
				style="font-weight: bold; background-color: black; opacity: 0.8; padding-left: 28px; line-height: 37px;"><a
				href="${path}/mps/list1.do">메이플스토리</a></li>
			<li><a href="${path}/mps/list2.do">패치노트</a></li>
			<li><a href="${path}/mps/list3.do">공략/팁</a></li>
			<li><a href="${path}/mps/list4.do">파티모집</a></li>
			<li><a href="${path}/screenshot/listMps.do">스크린샷</a></li>
		</ul>
		<ul>
			<li
				style="font-weight: bold; background-color: black; opacity: 0.8; padding-left: 28px; line-height: 37px;"><a
				href="${path}/lol/list1.do">리그오브레전드</a></li>
			<li><a href="${path}/lol/list2.do">패치노트</a></li>
			<li><a href="${path}/lol/list3.do">공략/팁</a></li>
			<li><a href="${path}/lol/list4.do">파티모집</a></li>
			<li><a href="${path}/screenshot/listLol.do">스크린샷</a></li>
		</ul>
		<ul>
			<li
				style="font-weight: bold; background-color: black; opacity: 0.8; padding-left: 28px; line-height: 37px;"><a
				href="${path}/dot/list1.do">DOTA2</a></li>
			<li><a href="${path}/dot/list2.do">패치노트</a></li>
			<li><a href="${path}/dot/list3.do">공략/팁</a></li>
			<li><a href="${path}/dot/list4.do">파티모집</a></li>
			<li><a href="${path}/screenshot/listDot.do">스크린샷</a></li>
		</ul>
		<ul>
			<li
				style="font-weight: bold; background-color: black; opacity: 0.8; padding-left: 28px; line-height: 37px;"><a
				href="${path}/hos/list1.do">시공의폭풍</a></li>
			<li><a href="${path}/hos/list2.do">패치노트</a></li>
			<li><a href="${path}/hos/list3.do">공략/팁</a></li>
			<li><a href="${path}/hos/list4.do">파티모집</a></li>
			<li><a href="${path}/screenshot/listHos.do">스크린샷</a></li>
		</ul>
		<ul>
			<li
				style="font-weight: bold; background-color: black; opacity: 0.8; padding-left: 28px; line-height: 37px;"><a
				href="${path}/sta/list1.do">스타크래프트</a></li>
			<li><a href="${path}/sta/list2.do">패치노트</a></li>
			<li><a href="${path}/sta/list3.do">공략/팁</a></li>
			<li><a href="${path}/sta/list4.do">파티모집</a></li>
			<li><a href="${path}/screenshot/listSta.do">스크린샷</a></li>
		</ul>
		<ul>
			<li
				style="font-weight: bold; background-color: black; opacity: 0.8; padding-left: 28px; line-height: 37px;"><a
				href="${path}/civ/list1.do">문명</a></li>
			<li><a href="${path}/civ/list2.do">패치노트</a></li>
			<li><a href="${path}/civ/list3.do">공략/팁</a></li>
			<li><a href="${path}/civ/list4.do">파티모집</a></li>
			<li><a href="${path}/screenshot/listCiv.do">스크린샷</a></li>
		</ul>
		<ul>
			<li
				style="font-weight: bold; background-color: black; opacity: 0.8; padding-left: 28px; line-height: 37px;"><a
				href="${path}/mic/list1.do">마인크래프트</a></li>
			<li><a href="${path}/mic/list2.do">패치노트</a></li>
			<li><a href="${path}/mic/list3.do">공략/팁</a></li>
			<li><a href="${path}/mic/list4.do">파티모집</a></li>
			<li><a href="${path}/screenshot/listMic.do">스크린샷</a></li>
		</ul>
		<ul>
			<li
				style="font-weight: bold; background-color: black; opacity: 0.8; padding-left: 28px; line-height: 37px;"><a
				href="${path}/win/list1.do">위닝일레븐</a></li>
			<li><a href="${path}/win/list2.do">패치노트</a></li>
			<li><a href="${path}/win/list3.do">공략/팁</a></li>
			<li><a href="${path}/win/list4.do">파티모집</a></li>
			<li><a href="${path}/screenshot/listWin.do">스크린샷</a></li>
		</ul>
		<ul>
			<li
				style="font-weight: bold; background-color: black; opacity: 0.8; padding-left: 28px; line-height: 37px;"><a
				href="${path}/nfs/list1.do">니드포스피드</a></li>
			<li><a href="${path}/nfs/list2.do">패치노트</a></li>
			<li><a href="${path}/nfs/list3.do">공략/팁</a></li>
			<li><a href="${path}/nfs/list4.do">파티모집</a></li>
			<li><a href="${path}/screenshot/listNfs.do">스크린샷</a></li>
		</ul>
		<ul>
			<li
				style="font-weight: bold; background-color: black; opacity: 0.8; padding-left: 28px; line-height: 37px;"><a
				href="${path}/fif/list1.do">피파온라인</a></li>
			<li><a href="${path}/fif/list2.do">패치노트</a></li>
			<li><a href="${path}/fif/list3.do">공략/팁</a></li>
			<li><a href="${path}/fif/list4.do">파티모집</a></li>
			<li><a href="${path}/screenshot/listFif.do">스크린샷</a></li>
		</ul>
		
	</div>
		<div>
		<a target="_blank" href="http://www.compuzone.co.kr/"><img
			id="banner_compuzone" src="${path}/images/compuzone1.jpg"
			style="width: 100%; height: 100%; max-width: 270px;"></a>
	</div>
</div>
