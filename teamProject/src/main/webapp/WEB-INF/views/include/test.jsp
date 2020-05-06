<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<script>
$("#btnSave")
      .click(
            function() {
               var b_name = $("#b_name").val(); //구분 내용 #replytext
               var bno = "${dto.bno}"; //게시물 번호
               var param = {
                  "b_name" : b_name,
                  "bno" : bno
               };
               if ($("#b_name").val() == '선택') {
                  alert('구분을 선택하세요.');
               } else {
                  var str = "";
                  // F12에서 올린 파일부분살펴보면 uploadedList 내부의 .file 태그 각각 반복
                  $(".uploadedList .file")
                        .each(
                              function(i) {
                                 console.log(i);
                                 //hidden 태그 구성
                                 str += "<input type='hidden' id='files["
                                       + i
                                       + "]' name='files["
                                       + i
                                       + "]'   value='"
                                       + $(this).val() + "'>";
                              });
                  //폼에 hidden 태그들을 붙임
                  $("#form1").append(str);
                  document.form1.submit();
               }
            });


   //드래그 기본 효과를 막음 .은 클래스 class=fileDrop, #은 id
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
         url: "../upload/uploadAjax",
         data: formData,
         dataType: "text",
         processData: false,
         contentType: false, 
         success: function(data){
            var fileInfo=getFileInfo(data);
            
            var str1="";
            if(checkImageType(data)){//이미지 파일
               str1="<div style='display: inline;'><a href='${path}/upload/displayFile?fileName="
                  +getImageLink(data)+"'>";
            str1+="<img src='${path}/upload/displayFile?fileName="
                  +data+"'></a>"; 
               }else{//이미지가 아닌 경우
                  str1="<div>";
                  str1+="<a href='${path}/upload/displayFile?fileName="
                        +data+"'>"+getOriginalName(data)+"</a>";
                  }
            str1+="<span data-src="+data+">[ ? ]</span></div>";

            str1 += "<input type='hidden' class='file' value='"
               +fileInfo.fullName+"'>";

            $(".uploadedList").append(str1);


         }
      });
   });//fileDrop 함수
   //첨부파일 삭제 함수
   $(".uploadedList").on("click","span",function(event){//내부적으로 span태그가 클릭되면 삭제
      var that=$(this);//this는 현재 클릭한 태그, 즉 span태그
      $.ajax({
         url: "${path}/upload/deleteFile",
         type: "post",
         data: {//data: "fileName="+$(this).attr("data-src") 아래와 같음   
            fileName: $(this).attr("data-src")
         },
         dataType: "text",
         success: function(result){
            if(result=="deleted"){
               that.parent("div").remove();//파일삭제되면 행전체<div>를 삭제처리
               //that은 span태그를 의미하는데 그 부모인 감싸고 있는 div태그를 지운다는 뜻
            }
         }
      });
   });
   


   
   function getOriginalName(fileName){
      if(checkImageType(fileName)){ //이미지 파일이면 skip
         return;
      }
      var idx=fileName.indexOf("_")+1; //uuid를 제외한 파일이름만 뽑음
      return fileName.substr(idx);
   }
   function getImageLink(fileName){
      if(!checkImageType(fileName)){//이미지 파일이 아니면 skip
         return;
      }
      //2018/08/25/s_f53e623b-24db-42f9-b607-9c04528056a5_apple-bg.jpg
      var front=fileName.substr(0,12);//연월일 경로(0~11번째까지 자르고)
      var end=fileName.substr(14);// 14번째 문자열앞의 s_ 제거
      return front+end;
   }
   function checkImageType(fileName){
      var pattern=/jpg|png|jpeg/i; //정규표현식(i는 대소문자 무시)
      return fileName.match(pattern); //규칙에 맞으면 true가 리턴
   }


   
});

   

</script>