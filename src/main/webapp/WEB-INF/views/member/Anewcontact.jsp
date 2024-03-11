<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<!-- saved from url=(0090)https://acorn-html-classic-dashboard.coloredstrategies.com/Pages.Authentication.Login.html -->
<html lang="en" data-placement="horizontal" data-behaviour="pinned" data-layout="fluid" data-radius="standard" data-color="light-teal" data-navcolor="default" data-show="true"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
<title>Acorn Admin Template | Login Page</title>
<meta name="description" content="Login Page">
<meta name="application-name" content=" ">
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
				<h2 class="cta-1 mb-0 text-primary justify-content-center align-items-center d-flex">연락처 추가</h2>
				<h2 class="cta-1 text-primary"></h2>
			</div>
			<form action="/member/addMemberContact/" method="post" enctype="multipart/form-data" class="card mb-5 tooltip-end-top" id="contactForm" novalidate="novalidate" data-select2-id="contactForm">
<div class="card-body" data-select2-id="17">
<p class="text-alternate mb-4"> 새 연락처 정보를 입력하세요.</p>
<p hidden> ${MContactDto.memberid} </p>





<div class="mb-3 filled">
<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 20 20" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="acorn-icons acorn-icons-user undefined"><path d="M10.0179 8C10.9661 8 11.4402 8 11.8802 7.76629C12.1434 7.62648 12.4736 7.32023 12.6328 7.06826C12.8989 6.64708 12.9256 6.29324 12.9789 5.58557C13.0082 5.19763 13.0071 4.81594 12.9751 4.42106C12.9175 3.70801 12.8887 3.35148 12.6289 2.93726C12.4653 2.67644 12.1305 2.36765 11.8573 2.2256C11.4235 2 10.9533 2 10.0129 2V2C9.03627 2 8.54794 2 8.1082 2.23338C7.82774 2.38223 7.49696 2.6954 7.33302 2.96731C7.07596 3.39365 7.05506 3.77571 7.01326 4.53982C6.99635 4.84898 6.99567 5.15116 7.01092 5.45586C7.04931 6.22283 7.06851 6.60631 7.33198 7.03942C7.4922 7.30281 7.8169 7.61166 8.08797 7.75851C8.53371 8 9.02845 8 10.0179 8V8Z"></path><path d="M16.5 17.5L16.583 16.6152C16.7267 15.082 16.7986 14.3154 16.2254 13.2504C16.0456 12.9164 15.5292 12.2901 15.2356 12.0499C14.2994 11.2842 13.7598 11.231 12.6805 11.1245C11.9049 11.048 11.0142 11 10 11C8.98584 11 8.09511 11.048 7.31945 11.1245C6.24021 11.231 5.70059 11.2842 4.76443 12.0499C4.47077 12.2901 3.95441 12.9164 3.77462 13.2504C3.20144 14.3154 3.27331 15.082 3.41705 16.6152L3.5 17.5"></path></svg>
<input class="form-control" placeholder="Name" name="name">
</div>
<div class="mb-3 filled">
<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 20 20" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="acorn-icons acorn-icons-phone undefined"><path d="M2.36839 7.02416C2.12354 6.39146 2.25595 5.68011 2.67976 5.15035L4.20321 3.24603C5.07388 2.1577 6.76286 2.27131 7.47994 3.46644L8.71763 5.52926C8.89353 5.82244 8.90746 6.18516 8.75456 6.49097L8.10563 7.78883C8.0362 7.92769 7.99726 8.08102 8.00921 8.2358C8.15129 10.0757 9.92438 11.8487 11.7642 11.9908C11.919 12.0028 12.0723 11.9638 12.2112 11.8944L13.5091 11.2455C13.8149 11.0926 14.1776 11.1065 14.4708 11.2824L16.5336 12.5201C17.7287 13.2372 17.8423 14.9262 16.754 15.7968L14.8497 17.3203C14.3199 17.7441 13.6086 17.8765 12.9759 17.6317C7.87729 15.6586 4.34147 12.1228 2.36839 7.02416Z"></path></svg>
<input class="form-control" placeholder="Phone" name="phonenumber">
</div>
<div class="mb-3 filled">
<textarea placeholder="address"  class="form-control" name="address" rows="2"></textarea>
<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 20 20" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="acorn-icons acorn-icons-email undefined"><path d="M18 7L11.5652 10.2174C10.9086 10.5457 10.5802 10.7099 10.2313 10.7505C10.0776 10.7684 9.92238 10.7684 9.76869 10.7505C9.41977 10.7099 9.09143 10.5457 8.43475 10.2174L2 7"></path><path d="M14.5 4C15.9045 4 16.6067 4 17.1111 4.33706C17.3295 4.48298 17.517 4.67048 17.6629 4.88886C18 5.39331 18 6.09554 18 7.5L18 12.5C18 13.9045 18 14.6067 17.6629 15.1111C17.517 15.3295 17.3295 15.517 17.1111 15.6629C16.6067 16 15.9045 16 14.5 16L5.5 16C4.09554 16 3.39331 16 2.88886 15.6629C2.67048 15.517 2.48298 15.3295 2.33706 15.1111C2 14.6067 2 13.9045 2 12.5L2 7.5C2 6.09554 2 5.39331 2.33706 4.88886C2.48298 4.67048 2.67048 4.48298 2.88886 4.33706C3.39331 4 4.09554 4 5.5 4L14.5 4Z"></path></svg>
</div>

<div class="mb-3 filled top-label" data-select2-id="16">
<select class="form-control select2-hidden-accessible" name="moimid" id="moimid" data-select2-id="Group" tabindex="-1" aria-hidden="true">
<option label="&nbsp;" data-select2-id="4"></option>
<option value="1" data-select2-id="28" selected>가족</option>
<option value="2" data-select2-id="29">친구</option>
<option value="3" data-select2-id="30">회사</option>
<option value="4" data-select2-id="30">기타</option>
</select>
<span>
<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 20 20" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="acorn-icons acorn-icons-category undefined"><path d="M10 4 10 14C10 15.1046 10.8954 16 12 16L14 16M14 4 10 4 6 4"></path><path d="M18 16C18 17.1046 17.1046 18 16 18V18C14.8954 18 14 17.1046 14 16V16C14 14.8954 14.8954 14 16 14V14C17.1046 14 18 14.8954 18 16V16zM18 4C18 5.10457 17.1046 6 16 6V6C14.8954 6 14 5.10457 14 4V4C14 2.89543 14.8954 2 16 2V2C17.1046 2 18 2.89543 18 4V4zM6 4C6 5.10457 5.10457 6 4 6V6C2.89543 6 2 5.10457 2 4V4C2 2.89543 2.89543 2 4 2V2C5.10457 2 6 2.89543 6 4V4z"></path></svg>
그룹</span>
</div>
<div class="mb-3 top-label"> 
<label class="form-label">Photo</label>
<input type="file" name="file" placeholder="Photo" class="form-control">
</div>             
<div class="card-footer border-0 pt-0 d-flex justify-content-center align-items-center">
<div>
<!-- 
<a href = "/member/addcontact">
 -->
<button class="btn btn-icon btn-icon-end btn-primary" type="submit">
<span>확인</span>
<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 20 20" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="acorn-icons acorn-icons-check undefined"><path d="M16 5L7.7051 14.2166C7.32183 14.6424 6.65982 14.6598 6.2547 14.2547L3 11"></path></svg>
</button>
<!-- 
</a>
 -->
</form>
</div>
</div>
<div class="mb-5 justify-content-center align-items-center">

<a href="/member/Acontacts/">
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