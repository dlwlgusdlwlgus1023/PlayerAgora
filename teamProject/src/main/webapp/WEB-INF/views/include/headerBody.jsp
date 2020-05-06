<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 맨위로 버튼 -->
<a id="MOVE_TOP_BTN" href="#"></a>
<!-- 여기까지 -->
<header id="main-header">
   <nav>
      <div class="dropmenu">
         <a href="${path}" style="float: left; top: 0;"><img
            src="${path}/images/Logo.JPG" alt="Logo" id="logo"></a>
         <ul style="font-weight: bolder;" class="menuNav" id="menuNav">
            <li><a href="#">FPS/TPS</a>
               <div>
                  <div id="divleft"
                     style="background-image: url('${path}/images/fps3.jpg');"></div>
                  <div id="content" align="center">
                     <a href="${path}/btg/list1.do"><img
                        src="${path}/images/bat.png"
                        style="width: 100%; height: auto; max-width: 430px;"></a> <a
                        href="${path}/sud/list1.do"><img
                        src="${path}/images/sud.png"
                        style="width: 100%; height: auto; max-width: 430px;"></a> <a
                        href="${path}/ovw/list1.do"><img
                        src="${path}/images/over.png"
                        style="width: 100%; height: auto; max-width: 430px;"></a>

                  </div>
                  <div id="divright"
                     style="background-image: url('${path}/images/fps4.jpg');"></div>
               </div></li>
            <li><a href="#">RPG</a>
               <div>
                  <div id="divleft"
                     style="background-image: url('${path}/images/rpg5.jpg');"></div>
                  <div id="content" align="center">
                     <a href="${path}/wow/list1.do"><img
                        src="${path}/images/wow.png"
                        style="width: 100%; height: auto; max-width: 430px;"></a> <a
                        href="${path}/loa/list1.do"><img
                        src="${path}/images/loa.png"
                        style="width: 100%; height: auto; max-width: 430px;"></a> <a
                        href="${path}/mps/list1.do"><img
                        src="${path}/images/me2.png"
                        style="width: 100%; height: auto; max-width: 430px;"></a>

                  </div>
                  <div id="divright"
                     style="background-image: url('${path}/images/rpg4.jpg');"></div>
               </div></li>
            <li><a href="#">AOS</a>
               <div>
                  <div id="divleft"
                     style="background-image: url('${path}/images/aos5.jpg');"></div>
                  <div id="content" align="center">
                     <a href="${path}/lol/list1.do"><img
                        src="${path}/images/lol.png"
                        style="width: 100%; height: auto; max-width: 430px;"></a> <a
                        href="${path}/dot/list1.do"><img
                        src="${path}/images/dota.png"
                        style="width: 100%; height: auto; max-width: 430px;"></a> <a
                        href="${path}/hos/list1.do"><img
                        src="${path}/images/hos.png"
                        style="width: 100%; height: auto; max-width: 430px;"></a>

                  </div>
                  <div id="divright"
                     style="background-image: url('${path}/images/aos4.jpg');"></div>
               </div></li>
            <li><a href="#">시뮬레이션</a>
               <div>
                  <div id="divleft"
                     style="background-image: url('${path}/images/si3.jpg');"></div>
                  <div id="content" align="center">
                     <a href="${path}/sta/list1.do"><img
                        src="${path}/images/star.png"
                        style="width: 100%; height: auto; max-width: 430px;"></a> <a
                        href="${path}/mic/list1.do"><img
                        src="${path}/images/mine.png"
                        style="width: 100%; height: auto; max-width: 430px;"></a> <a
                        href="${path}/civ/list1.do"><img
                        src="${path}/images/moon.png"
                        style="width: 100%; height: auto; max-width: 430px;"></a>

                  </div>
                  <div id="divright"
                     style="background-image: url('${path}/images/si4.jpg');"></div>
               </div></li>
            <li><a href="#">레이싱/스포츠</a>
               <div>
                  <div id="divleft"
                     style="background-image: url('${path}/images/spo3.jpg');"></div>
                  <div id="content" align="center">
                     <a href="${path}/fif/list1.do"><img
                        src="${path}/images/fifa.png"
                        style="width: 100%; height: auto; max-width: 430px;"></a> <a
                        href="${path}/nfs/list1.do"><img
                        src="${path}/images/need3.png"
                        style="width: 100%; height: auto; max-width: 430px;"></a> <a
                        href="${path}/win/list1.do"><img src="${path}/images/wi.png"
                        style="width: 100%; height: auto; max-width: 430px;"></a>

                  </div>
                  <div id="divright"
                     style="background-image: url('${path}/images/spo4.jpg');"></div>
               </div></li>
            <li></li>
            <li style="float: right;"><c:if
                  test="${sessionScope.userid != null }">
                  <a href="${path}/member/logout.do"><span
                     class="glyphicon glyphicon-log-out"></span> Logout</a>
               </c:if> <c:if test="${sessionScope.userid == null }">
                  <a href="${path}/member/login.do"><span
                     class="glyphicon glyphicon-log-in"></span> Login</a>
               </c:if></li>
         </ul>
      </div>
      <div id="slideIcon">
         <input type="checkbox" class="menuChk" id="menuicon"> <label
            for="menuicon"> <span></span> <span></span> <span></span>
         </label>
         <div class="slideNav" id="menuslide">
            <a href="http://localhost/teamProject/member/login.do" id="logIcon">
               <img alt="${path}/images/login.png" src="${path}/images/login.png">
            </a>
            <ul>
               <li><input type="checkbox" id="menuBtn1"> <label
                  for="menuBtn1" class="labelBtn" onclick=""
                  style="margin-top: 50px;">FPS/TPS</label>
                  <ul class="submenu">
                     <li><a href="${path}/btg/list1.do">배틀그라운드</a></li>
                     <li><a href="${path}/sud/list1.do">서든어택</a></li>
                     <li><a href="${path}/ovw/list1.do">오버워치</a></li>
                  </ul></li>
               <li><input type="checkbox" id="menuBtn2"> <label
                  for="menuBtn2" class="labelBtn" onclick="">RPG</label>
                  <ul class="submenu" style="color: white;">
                     <li><a href="${path}/wow/list1.do">월드오브워크래프트</a></li>
                     <li><a href="${path}/loa/list1.do">로스트아크</a></li>
                     <li><a href="${path}/mps/list1.do">메이플스토리</a></li>
                  </ul></li>
               <li><input type="checkbox" id="menuBtn3"> <label
                  for="menuBtn3" class="labelBtn" onclick="">AOS</label>
                  <ul class="submenu" style="color: white;">
                     <li><a href="${path}/lol/list1.do">리그오브레전드</a></li>
                     <li><a href="${path}/dot/list1.do">DOTA2</a></li>
                     <li><a href="${path}/hos/list1.do">HOS</a></li>
                  </ul></li>
               <li><input type="checkbox" id="menuBtn4"> <label
                  for="menuBtn4" class="labelBtn" onclick="">시뮬레이션</label>
                  <ul class="submenu" style="color: white;">
                     <li><a href="${path}/sta/list1.do">스타크래프트</a></li>
                     <li><a href="${path}/civ/list1.do">문명</a></li>
                     <li><a href="${path}/mic/list1.do">마인크래프트</a></li>
                  </ul></li>
               <li><input type="checkbox" id="menuBtn5"> <label
                  for="menuBtn5" class="labelBtn" onclick="">레이싱/스포츠</label>
                  <ul class="submenu" style="color: white;">
                     <li><a href="${path}/win/list1.do">위닝일레븐</a></li>
                     <li><a href="${path}/nfs/list1.do">니드포스피드</a></li>
                     <li><a href="${path}/fif/list1.do">피파온라인</a></li>
                  </ul></li>
            </ul>
         </div>
      </div>
   </nav>
</header>

<script src="../include/jquery-3.4.1.min.js"></script>
<script src="../include/script.js"></script>