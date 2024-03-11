<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<!-- saved from url=(0077)https://acorn-html-classic-dashboard.coloredstrategies.com/Apps.Contacts.html -->
<html lang="en" data-footer="true" data-placement="horizontal" data-behaviour="pinned" data-layout="fluid" data-radius="standard" data-color="light-teal" data-navcolor="default" data-show="true" data-dimension="desktop"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
<title>Acorn Admin Template | Contacts Application</title>
<meta name="description" content="User directory application that built with the help of List.js. Can be searched, paged and sorted.">
<meta name="application-name" content=" ">
<meta name="msapplication-TileColor" content="#FFFFFF">
<link rel="preconnect" href="https://fonts.gstatic.com/">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/css2" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/css2(1)" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/OverlayScrollbars.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/quill.bubble.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/select2.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/select2-bootstrap4.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<script src="${pageContext.request.contextPath}/resources/css/loader.js.download"></script>
</head>
<body class="" data-bs-padding="0px" style=""><div id="paddingModal" class="modal" aria-hidden="true" style="display: none;"> <div class="modal-dialog d-none"><div class="modal-content"></div></div> </div>
	<div id="root">
		<div id="nav" class="nav-container d-flex">
			<div class="nav-content d-flex" style="padding-right: 0px;">
				<div class="logo position-relative">
					<a href=""> 
					<div class="img"></div>
					</a>
				</div>
			<div class="language-switch-container">
				<div class="dropdown-menu">
				</div>
			</div>
			<div class="user-container d-flex">
				<div class="name">
		<!--  
				 <H2><c:if test="true"> ${contactList[0].memberid}</c:if> 님의 연락처 목록</H2>
		-->		 
				 <H2><c:if test="true"> ${memberid}</c:if> 님의 연락처 목록</H2>
				 </div>
			</div>
			<div class="menu-container flex-grow-1">
 			</div>
			
<div class="mobile-buttons-container">
<a href="" id="scrollSpyButton" class="spy-button" data-bs-toggle="dropdown">
<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 20 20" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="acorn-icons acorn-icons-menu-dropdown undefined"><path d="M2 3 18 3M2 10 18 10M13 15 10.3536 17.6464C10.1583 17.8417 9.84171 17.8417 9.64645 17.6464L7 15"></path></svg>
</a>
<div class="dropdown-menu dropdown-menu-end" id="scrollSpyDropdown"></div>
<a href="" id="mobileMenuButton" class="menu-button">
<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 20 20" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="acorn-icons acorn-icons-menu undefined"><path d="M2 3 18 3M2 10 18 10M2 17 18 17"></path></svg>
</a>
</div>
</div>

<div class="nav-shadow"></div>
</div>

<main>
	<div class="container" id="contacts">
	<div class="page-title-container">
	<div class="row g-0">
	<div class="col-auto mb-2 mb-md-0 me-auto">
	<div class="w-auto sw-md-30">
		<div class="mb-0 pb-0 name text-alternate"></div>
		</div>
		</div>
	<div class="w-100 d-md-none"></div>
	<div class="col-12 col-sm-6 col-md d-flex align-items-start justify-content-end order-3 order-sm-2">
<!--검색창 시작-->	
		<div class="col-12 col-sm-6 col-md-auto d-flex align-items-start justify-content-end mb-2 mb-sm-0 order-sm-3">
			<a href = "/member/Aname/"><!--  data-bs-toggle="modal" data-bs-target=""> -->
			<button type="submit" class="btn btn-outline-primary btn-icon btn-icon-start ms-0 ms-sm-1 w-100 w-md-auto" id="newContactButton">
			<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 20 20" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="acorn-icons acorn-icons-search undefined"><circle cx="9" cy="9" r="7"></circle><path d="M14 14L17.5 17.5"></path></svg>
			<span>검색</span>
		</button>
			</a>
		</div>
		<div class="w-100 w-lg-auto search-input-container border border-separator">
			
		</div>
<!--검색창 끝-->							
		
<!--연락처 추가 버튼 시작-->

		<div class="col-12 col-sm-6 col-md-auto d-flex align-items-start justify-content-end mb-2 mb-sm-0 order-sm-3">
			<a href = "/member/addcontact/"><!--  data-bs-toggle="modal" data-bs-target=""> -->
			<button type="submit" class="btn btn-outline-primary btn-icon btn-icon-start ms-0 ms-sm-1 w-100 w-md-auto" id="newContactButton">
			<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 20 20" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="acorn-icons acorn-icons-plus undefined"><path d="M10 17 10 3M3 10 17 10"></path></svg>
			<span>연락처 추가</span>
		</button>
			</a>
		</div>
		<div class="col-12 col-sm-6 col-md-auto d-flex align-items-start justify-content-end mb-2 mb-sm-0 order-sm-3">
			<a href = "/member/login"><!--  data-bs-toggle="modal" data-bs-target=""> -->
			<button type="submit" class="btn btn-outline-primary btn-icon btn-icon-start ms-0 ms-sm-1 w-100 w-md-auto" id="newContactButton">
			<svg xmlns="http://www.w3.org/2000/svg" width="17" height="17" viewBox="0 0 20 20" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="acorn-icons acorn-icons-logout me-2"><path d="M7 15 2.35355 10.3536C2.15829 10.1583 2.15829 9.84171 2.35355 9.64645L7 5M3 10H13M12 18 14.5 18C15.9045 18 16.6067 18 17.1111 17.6629 17.3295 17.517 17.517 17.3295 17.6629 17.1111 18 16.6067 18 15.9045 18 14.5L18 5.5C18 4.09554 18 3.39331 17.6629 2.88886 17.517 2.67048 17.3295 2.48298 17.1111 2.33706 16.6067 2 15.9045 2 14.5 2L12 2"></path></svg>
			<span>Logout</span>
		</button>
			</a>
		</div>
		
<!--연락처 추가 버튼 끝-->
		</div>
	</div>
	<div class="row g-0">
	<div class="col">
	<div id="checkboxTable">
	<div class="mb-4 mb-lg-3 bg-transparent no-shadow d-none d-lg-block">
	<div class="row g-0">
<!--리스트 제목 시작-->								
		<div class="col-auto sw-11 d-none d-lg-flex"></div>
		<div class="col">
		<div class="ps-0 ps-5 pe-4 pt-0 pb-0 h-100">
		<div class="row g-0 h-100 align-content-center custom-sort">
		<div class="col-3 col-lg-4 d-flex flex-column mb-lg-0 pe-3 d-flex">
		<div class="text-muted " data-sort="name">이름</div>
		</div>
		<div class="col-3 col-lg-3 d-flex flex-column pe-1 justify-content-center">
		<div class="text-muted " data-sort="phone">전화번호</div>
		</div>
		<div class="col-3 col-lg-3 d-flex flex-column pe-1 justify-content-center">
		<div class="text-muted " data-sort="address">주소</div>
		</div>
		<div class="col-3 col-lg-1 d-flex flex-column pe-1 justify-content-center">
		<div class="text-muted " data-sort="group">그룹</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
<!--리스트 제목 끝-->								
<!--1. 연락처 표시===============-->
<c:if test="${contactList[0].contactid!=''}" >
       <c:forEach items="${contactList }" var="contact" varStatus="status">
		<div class="list mb-5">
		<div class="card mb-2">
		<div class="d-none id"></div>
		<div class="row g-0 h-100 sh-lg-9 position-relative">
<!-- 		
 		<img src="${pageContext.request.contextPath}/resources/css/smiley.jpeg" alt="alternate text" class="card-img card-img-horizontal sw-11 h-100 h-100 sh-lg-9 thumb" id="contactThumb">
-->		
 		<img src="${pageContext.request.contextPath}${contact.photo}" alt="" class="card-img card-img-horizontal sw-11 h-100 h-100 sh-lg-9 thumb" id="contactThumb">
		<div class="col py-3 py-sm-3">
		<div class="card-body ps-5 pe-4 pt-0 pb-0 h-100">
		
		<div class="row g-0 h-100 align-content-center">
		<div class="col-11 col-lg-4 d-flex flex-column mb-lg-0 mb-3 mb-lg-0 pe-3 d-flex order-1 view-click">
		<div class="name" id="name">    ${contact.name}</div>
		</div>
		
		<div class="col-12 col-lg-3 d-flex flex-column pe-1 mb-2 mb-lg-0 justify-content-center order-3">
		<div class="lh-1 text-alternate email" id="pnohenumber">${contact.phonenumber}</div>
		</div>
		<div class="col-12 col-lg-3 d-flex flex-column pe-1 mb-2 mb-lg-0 justify-content-center order-4">
		<div class="lh-1 text-alternate phone" id="address">${contact.address}</div>
		</div>
		<div class="col-12 col-lg-1 d-flex flex-column pe-1 mb-2 mb-lg-0 align-items-start justify-content-center order-5">
		<span class="1h-1 text-alternate" id="Group">${contact.moimname}</span>
		</div>
		<div class="col-1 col-lg-1 d-flex flex-column mb-2 mb-lg-0 align-items-end order-2 justify-content-center order-lg-last">
		<div class = "text-primary">
		<a href="/member/update/${contact.contactid}">
		<span class="badge bg-outline-primary group" id="contactGroup">수정</span>
		</a>
		<a href="/member/delete/${contact.contactid}">
		<span class="badge bg-outline-primary group" id="contactGroup">삭제</span>
		</a>
		</div>		
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
       </c:forEach>
</c:if>
<!--1. 연락처 표시 끝=============-->

<!--2. 연락처 표시 시작 ===========-->

<!--5 연락처 끝==============-->		
<!--페이지 번호 표시 시작-->		
<!--
		<div class="w-100 d-flex justify-content-center">
		<div class="pagination"><li class="page-item prev disabled"><a class="page page-link shadow" href="javascript:function Z(){Z=&quot;&quot;}Z()"><i class="cs-chevron-left"></i></a></li><li class="page-item active"><a class="page page-link shadow" href="javascript:function Z(){Z=&quot;&quot;}Z()">1</a></li><li class="page-item"><a class="page page-link shadow" href="javascript:function Z(){Z=&quot;&quot;}Z()">2</a></li><li class="page-item next"><a class="page page-link shadow" href="javascript:function Z(){Z=&quot;&quot;}Z()"><i class="cs-chevron-right"></i></a></li></div>
		</div>
-->
<!--페이지 번호 표시 끝-->		
		<div class="d-none">
		<div class="card mb-2" id="contactItemTemplate">
		<div class="d-none id"></div>
		<div class="row g-0 h-100 sh-lg-9 position-relative">
		<a href="https://acorn-html-classic-dashboard.coloredstrategies.com/Apps.Contacts.html#" class="col-auto position-relative view-click">
		<img src="https://acorn-html-classic-dashboard.coloredstrategies.com/Apps.Contacts.html" alt="alternate text" class="card-img card-img-horizontal sw-11 h-100 h-100 sh-lg-9 thumb" id="contactThumb">
		</a>
		<div class="col py-3 py-sm-3">
		<div class="card-body ps-5 pe-4 pt-0 pb-0 h-100">
		<div class="row g-0 h-100 align-content-center">
		<a href="https://acorn-html-classic-dashboard.coloredstrategies.com/Apps.Contacts.html#" class="col-11 col-lg-4 d-flex flex-column mb-lg-0 mb-3 mb-lg-0 pe-3 d-flex order-1 view-click">
		<div class="name" id="contactName"></div>
		<div class="text-small text-muted text-truncate position" id="contactPosition"></div>
		</a>
		<div class="col-12 col-lg-3 d-flex flex-column pe-1 mb-2 mb-lg-0 justify-content-center order-3">
		<div class="lh-1 text-alternate email" id="contactEmail"></div>
		</div>
		<div class="col-12 col-lg-3 d-flex flex-column pe-1 mb-2 mb-lg-0 justify-content-center order-4">
		<div class="lh-1 text-alternate phone" id="contactPhone">2</div>
		</div>
		<div class="col-12 col-lg-1 d-flex flex-column pe-1 mb-2 mb-lg-0 align-items-start justify-content-center order-5">
		<span class="badge bg-outline-primary group" id="contactGroup"></span>
		</div>
		<div class="col-1 col-lg-1 d-flex flex-column mb-2 mb-lg-0 align-items-end order-2 order-lg-last">
		<label class="form-check mt-2">
		<input type="checkbox" class="form-check-input pe-none">
		</label>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
<!--연락처 추가 메뉴-->		
</div>
</main>
<!--footer 페이지-->
<footer>
<div class="footer-content">
	<div class="container">
		<div class="row">
			<div class="col-12 col-sm-6">
				<p class="mb-0 text-muted text-medium">Contacts Management System 2023</p>
			</div>
			<div class="col-sm-6 d-none d-sm-block">
				<ul class="breadcrumb pt-0 pe-0 mb-0 float-end">
					<li class="breadcrumb-item mb-0 text-medium">
							Moon,Hyun Jeong
			</li>
				</ul>
			</div>
		</div>
	</div>
</div>
</footer>
<!--footer 페이지 끝-->


</div>

<!--검색 팝업 시작-->
<div class="modal fade modal-under-nav modal-search modal-close-out" id="searchPagesModal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header border-0 p-0">
				<button type="button" class="btn-close btn btn-icon btn-icon-only btn-foreground" data-bs-dismiss="modal" aria-label="Close">x</button>
			</div>
			<div class="modal-body ps-5 pe-5 pb-0 border-0">
				<input id="searchPagesInput" class="form-control form-control-xl borderless ps-0 pe-0 mb-1 auto-complete" type="text" autocomplete="off" placeholder="Search"><ul id="searchPagesResults" class="auto-complete-result"></ul>
			</div>
			<div class="modal-footer border-top justify-content-start ps-5 pe-5 pb-3 pt-3 border-0">
				<span class="text-alternate d-inline-block m-0 me-3">
					<a onclick="alert('Hello World!')">
					<svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" viewBox="0 0 20 20" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="acorn-icons acorn-icons-arrow-bottom text-alternate align-middle me-1"><path d="M17 11 10.3536 17.6464C10.1583 17.8417 9.84171 17.8417 9.64645 17.6464L3 11M10 2 10 17"></path></svg>
					<span class="align-middle text-medium">검색</span>
					</a>
				</span>
			</div>
		</div>
	</div>
</div>

<script src="${pageContext.request.contextPath}/resources/css/jquery-3.5.1.min.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/bootstrap.bundle.min.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/OverlayScrollbars.min.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/autoComplete.min.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/clamp.min.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/acorn-icons.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/acorn-icons-interface.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/select2.full.min.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/singleimageupload.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/list.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/helpers.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/globals.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/nav.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/search.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/settings.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/checkall.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/contacts.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/common.js.download"></script>
<script src="${pageContext.request.contextPath}/resources/css/scripts.js.download"></script>


</body></html>