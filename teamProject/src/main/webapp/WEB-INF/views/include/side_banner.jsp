<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	$(document).ready(function(){
		var danawa=1;
		setInterval(function() {
			danawa++;
			if(danawa>3){
				danawa=1;
			}
			$("#banner_danawa").attr("src","${path}/images/danawa"+danawa+".jpg");
		},3000);
	});
</script>
<script>
	$(document).ready(function(){
		var compuzone=1;
		setInterval(function() {
			compuzone++;
			if(compuzone>3){
				compuzone=1;
			}
			$("#banner_compuzone").attr("src","${path}/images/compuzone"+compuzone+".jpg");
		},3000);
	});
</script>
<style>
#sidebtn{
	text-align: left;
}
#sidebtn ul, #sidebtn ul li{
	list-style: none;
}
#sidebtn ul li a:link {
	color: white; text-decoration: none;
}
#sidebtn ul li a:visited {
	color: white;
}
#sidebtn ul li a:hover {
	text-decoration: none;
}
#sidebtn ul li a{
color: white;
}
#sidebtn ul li{
	padding-top: 8px;
	padding-bottom: 8px;
	line-height: 17px;
	padding-left: 30px;
}
#sidebtn ul{
	background-color: gray;
	opacity: 0.8;
}
#sidebtn{
	background-color: gray;
	opacity: 0.8;
}
#headbtn table tr td {
   background-color: black;
}

#headbtn table tr td a:link {
   color: white;
   text-decoration: none;
}

#headbtn table tr td a:visited {
   color: white;
}

#headbtn table tr td a:hover {
   text-decoration: none;
   background-color: gray;
}

#headbtn table tr td:hover {
   background-color: gray;
}

#headbtn table tr td a {
   color: black;
}
#headbtn table {
   width: 100%;
   border: 1px solid;
   border-collapse: collapse;
   border-color: gray;
}
#headbtn table th, td {
   padding: 10px;
   border-color: gray;
}
.col-md-9{
}

</style>