<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0090)https://acorn-html-classic-dashboard.coloredstrategies.com/Pages.Authentication.Login.html -->
<html lang="en" data-placement="horizontal" data-behaviour="pinned" data-layout="fluid" data-radius="standard" data-color="light-teal" data-navcolor="default" data-show="true"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
<title>Acorn Admin Template | Login Page</title>
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
				<h2 class="cta-1 mb-0 text-primary justify-content-center align-items-center d-flex">환영합니다!</h2>
				<h2 class="cta-1 text-primary"></h2>
			</div>
			<form id="loginForm" action="/member/authentication" method="post" class="tooltip-end-bottom" novalidate="novalidate">
				<div class="mb-3 filled form-group tooltip-end-top">
					<input class="form-control" placeholder="Userid" name="memberid">
				</div>
				<div class="mb-3 filled form-group tooltip-end-top">
					<input class="form-control pe-7" name="memberpassword" type="password" placeholder="Password">
				</div>
				<div class="justify-content-center d-flex">
				<button type="submit" class="btn btn-lg btn-primary">로그인</button>
				</div>
			</form>
			
			<div class="mb-5 justify-content-center align-items-center">
				<h2 class="cta-1 mb-5 text-primary justify-content-center align-items-center d-flex"></h2>
				<a href="/member/signup">
				<h5 class="mb-0 text-primary justify-content-center align-items-center d-flex">회원가입</h5>
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