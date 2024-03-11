<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<!-- saved from url=(0090)https://acorn-html-classic-dashboard.coloredstrategies.com/Pages.Authentication.Login.html -->
<html lang="en" data-placement="horizontal" data-behaviour="pinned" data-layout="fluid" data-radius="standard" data-color="light-teal" data-navcolor="default" data-show="true"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
<title>연락처 이름 검색</title>
<meta name="description" content="Login Page">
<meta name="application-name" content=" ">
<meta name="msapplication-TileColor" content="#FFFFFF">
<link rel="preconnect" href="https://fonts.gstatic.com/">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/css2" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/css2(1)" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
<script src="${pageContext.request.contextPath}/resources/css/loader.js.download"></script>
</head>

<body class="h-100" data-bs-padding="0px" style="" >

<div class="col-12 col-lg-auto h-100 pb-4 px-4 pt-0 p-lg-0 justify-content-center align-items-center d-flex" >
	<div class="sw-lg-70 min-h-50 bg-foreground d-flex justify-content-center align-items-center shadow-deep py-5 full-page-content-right-border">
		<div class="sw-lg-50 px-5 justify-content-center align-items-center">
			<div class="mb-5 justify-content-center align-items-center">
				<h2 class="cta-1 mb-0 text-primary justify-content-center align-items-center d-flex">검색할 이름을 입력하세요!</h2>
				<h2 class="cta-1 text-primary"></h2>
			</div>
			<form id="loginForm" action="/member/Asearchcontact/" method="post" class="tooltip-end-bottom" novalidate="novalidate">
				<div class="mb-3 filled form-group tooltip-end-top">
					<input class="form-control" placeholder="이름" name="searchname">
				</div>
				<div class="justify-content-center d-flex">
				<button type="submit" class="btn btn-lg btn-primary">검색</button>
				</div>
			</form>
			
			<div class="mb-5 justify-content-center align-items-center">
								<h2 class="cta-1 mb-5 text-primary justify-content-center align-items-center d-flex"></h2>
				<a href="javascript:history.back();">
				<h5 class="mb-0 text-primary justify-content-center align-items-center d-flex">
			    <span><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 20 20" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="acorn-icons acorn-icons-arrow-left mb-3 d-inline-block text-primary"><path d="M9 17 2.35355 10.3536C2.15829 10.1583 2.15829 9.84171 2.35355 9.64645L9 3M18 10 3 10"></path></svg>
				취소</h5>
				</a>
				<h2 class="cta-1 text-primary"></h2>
			</div>
			
		</div>
	</div>
</div>

<script src="${pageContext.request.contextPath}/resources/css/globals.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/settings.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/scripts.js.download"></script>

</body></html>

