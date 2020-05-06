<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
fieldset {
	position: relative;
	display: inline-block;
	padding: 0 0 0 40px;
	background: #666;
	border: none;
	border-radius: 5px;
}

.search1, .search2 {
	position: relative;
	width: 200px;
	height: 50px;
	padding: 0;
	display: inline-block;
	float: left;
}

.search1 {
	color: #fff;
	background-color: #666;
	z-index: 2;
	border-radius: 5px 0 0 5px;
	border: 0 none;
}

.search1:focus {
	outline: 0 none;
}

.search1:focus+.search2 {
	-webkit-transform: translate(0, 0);
	-ms-transform: translate(0, 0);
	transform: translate(0, 0);
	-webkit-transition-duration: 0.3s;
	transition-duration: 0.3s;
}

.search1:focus+.search2 .fa {
	-webkit-transform: translate(0px, 0);
	-ms-transform: translate(0px, 0);
	transform: translate(0px, 0);
	-webkit-transition-duration: 0.3s;
	transition-duration: 0.3s;
	color: #666;
	background-color: #ccc;
}

.search2 {
	z-index: 1;
	width: 50px;
	border: 0 none;
	background: #ccc;
	cursor: pointer;
	border-radius: 0 5px 5px 0;
	-webkit-transform: translate(-50px, 0);
	-ms-transform: translate(-50px, 0);
	transform: translate(-50px, 0);
	-webkit-transition-duration: 0.3s;
	transition-duration: 0.3s;
}

.fa-search {
	font-size: 1.4rem;
	color: #fff;
	z-index: 3;
	top: 25%;
	-webkit-transform: translate(-190px, 0);
	-ms-transform: translate(-190px, 0);
	transform: translate(-190px, 0);
	-webkit-transition-duration: 0.3s;
	transition-duration: 0.3s;
	-webkit-transition: all 0.1s ease-in-out;
	transition: all 0.1s ease-in-out;
}
</style>