/*
 * MemberWebController.java : 컨트롤러 클래스
 * 회원 연락처 관리 웹 프로그램
 * URL://http://localhost:9988/member/login 
 */
package com.naver.contact;

import java.io.File;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller 						//spring 시작 될때 BEAN으로 등록 된다
@RequestMapping("/member")				//http://localhost:9988/member : URL 주소 매핑
//====MemberWebController.java class =======================================
public class MemberWebController {			//컨트롤러 클래스
	
	@Autowired					//어노테이션 Autowired 지정- 다음줄에
	MemberDao dao;					//회원정보를 위한 DAO
	
	@Autowired					//어노테이션 Autowired 지정- 다음줄에
	MContactDao mcdao;				//연락처정보를 위한 DAO
//====MemberWebController.java class END ====================================
	
//====회원 로그인 화면 접근을 위한 welcome() ======================================= 
	@GetMapping("/login")     			//localhost:9988/member/login : URL 주소 매핑- 바로 아래 메소드 
	public String welcome(HttpSession session,Model model) { 
		session.invalidate();			//login 페이지에서 session 초기화
		return "/member/Alogin"; 		//Alogin(.jsp)로 포워드, 로그인 화면 가기
	}
//====회원 로그인 화면 접근을 위한 welcome() END: ====================================
	
//====회원가입하기 signUp() ======================================================= 
	@GetMapping("/signup")     			//localhost:9988/member/signup : URL 주소 매핑- 바로 아래 메소드
	public String signUp(@ModelAttribute MemberDto dto, Model model) { 

		return "/member/Asignup"; 		// Asignup(.jsp)로 포워드, 회원가입 화면 가기
	}
//====회원가입하기 signUp() END==================================================== 

//====회원추가하기 addMember() ====================================================
	@PostMapping("/add")     			//localhost:9988/member/add : URL 주소 매핑- 바로 아래 메소드
	public String addMember(@ModelAttribute MemberDto dto, Model model) { 
		try {
//			회원id, 비밀번호 공백이 아닌 경우에 DB 추가 
			if ((!dto.getMemberid().isEmpty())&&(!dto.getMemberpassword().isEmpty())){
//				이미 존재하는 회원id가 아닌 경우에 DB 추가 
				if(dao.validationMember(dto).equals("pass")) {
					dao.addMember(dto);		//회원정보를 DB에 추가
				}
				else {
					return "redirect:/member/login"; //localhost:9988/member/login으로 redirect
				}
			}
			else {
				return "redirect:/member/login"; //localhost:9988/member/login으로 redirect
			}
		} catch (Exception e) { 		//에러 발생 한 경우
			e.printStackTrace();		//에러 메세지 넣기
			model.addAttribute("error","회원 가입 에러");
		} 
		return "redirect:/member/login"; //localhost:9988/member/login 으로 redirect
	}
//====회원추가하기 addMember() END==================================================

//====회원인증하기 authMember(), pass하면 -> 연락처 목록 보기화면 | fail하면-> 로그인 화면 == 
	@PostMapping("/authentication")
	public String authMember(HttpSession session,@ModelAttribute MemberDto dto, Model model) { 
		try {
			if (dao.authenticationMember(dto).equals("pass")) {		//인증 성공하면 연락처 목록보기로 넘기기
				session.setAttribute("memberid", dto.getMemberid()); 	//로그인한 멤버 session 추가
				return "redirect:/member/Acontacts/"; 
			}
			else {					
				return "/member/login";	//실패하면 로그인 화면으로 넘기기
			}
		} catch (Exception e) { 		// 에러 발생 한 경우
			e.printStackTrace();		// 예외추적내용 출력하고 
			model.addAttribute("error","인증 에러");
		} 
		
		return "redirect:/member/login"; //문제발생한 경우 로그인 화면으로 넘기기
	}
//====회원인증하기 authMember() END================================================= 
	
//====회원의 연락처 목록보기 contactlist() =========================================== 		
	@GetMapping ("/listAcontacts")		//localhost:9988/member/listAcontacts : URL 주소 매핑- 바로 아래 메소드  
	public String contactlist(@PathVariable String memberid, Model model) {
		ArrayList<MContactDto> list;	//여러명 연락처를 담은 ArrayList list 선언 
		try {
			list = mcdao.getAll(memberid);			//로그인 성공한 회원의 memberid로 검색한 연락처 목록 받는다
			model.addAttribute("Acontacts", list);		// 에러 없으면 model에 연락처 목록 넣는다
		} catch (Exception e) { 				// 에러 상태면 
			e.printStackTrace(); 				// 예외추적내용 출력하고 
			model.addAttribute("error", "뉴스 상세 에러");	// model 에 error메시지 넣는다
		}
		return "member/Acontacts";		//Acontacts(.jsp)로 포워드
}
//====로그인 회원의 연락처 목록보기 END================================================
	
//====로그인 회원의 연락처 목록보기: getAllContacts() =================================
	@GetMapping("/Acontacts/")//localhost:9988/member/Acontacts/ : URL 주소 매핑- 바로 아래 메소드
 	public String getAllContacts(HttpSession session, Model model) { 
 		ArrayList<MContactDto> list;	//연락처 목록을 받을 ArrayList
		try {
//			현재 session에서 로그인한 회원id 추출
			String memberid = (String)session.getAttribute("memberid");
			list = mcdao.getAll(memberid);			//로그인 멤버의 연락처 목록만 검색해서 ArrayList로 받는다
			model.addAttribute("memberid", memberid);	// model에 회원id 넣기
			model.addAttribute("contactList", list); 	// 에러 없으면 model에 연락처 목록 넣는다, key가 "contactList"
		} catch (Exception e) { 
			e.printStackTrace();
			model.addAttribute("error", "목록보기 에러");	// 에러 상태면 model 에 error메시지가 들어간다
		}
	return "member/Acontacts";			//Acontacts(.jsp)로 포워드
 	}
//====로그인 회원의 연락처 목록보기: getAllContacts() END==============================

//====연락처 수정을 위한 1명 연락처 가져오기: getContact() =============================
	@GetMapping("/update/{contactid}")	//localhost:9988/member/update/: URL 주소 매핑- 바로 아래 메소드
	public String getContact(@PathVariable int contactid, Model model) { 
		try {
		MContactDto mcdto = mcdao.getOne(contactid);	//1명 연락처 담을 MContactDto 준비
		model.addAttribute("MContactDto",mcdto); 	//연락처 추가 화면으로 보낼 준비
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error","연락처 추가 에러");//에러 발생시 에러 내용 넣어서 준비
		}
	return "member/Aeditcontact"; 		//Aeditcontact(.jsp)로 포워드, 연락처 수정 화면 
	}
//====연락처 수정을 위한 1명 연락처 가져오기: getContact() END=============================

//====연락처 이름으로 검색하기 위한 검색화면으로 가기 : memberSearch()=====================
	@GetMapping("/Aname/")
	public String memberSearch(HttpSession session, Model model) {
	try {
		String memberid = (String)session.getAttribute("memberid");
		model.addAttribute("memberid", memberid); 	// 회원의 memberid를 model에 넣는다
	} catch (Exception e) { 
		e.printStackTrace();
		model.addAttribute("error", "검색 목록보기 에러");// 에러 상태면 model 에 error메시지가 들어간다
	}
	return "/member/Aname";				//Aname(.jsp)로 포워드, 이름 검색화면으로 넘기기	
	}
//====연락처 이름으로 검색하기 위한 검색화면으로 가기 : memberSearch() END=================

//====이름으로 검색해서 검색 결과 화면으로 넘기기: searchName() ===========================	
	@RequestMapping("/Asearchcontact/")	//localhost:9988/member/Asearchcontact/ : URL 주소 매핑- 바로 아래 메소드
	public String seacrchName(HttpSession session,HttpServletRequest request, Model model) { 
		ArrayList<MContactDto> list;	//이름 검색결과로 나온 회원목록을 담기 위한 ArrayList list 선언 
		String memberid = (String)session.getAttribute("memberid");
		String searchname = request.getParameter("searchname"); //검색어 꺼내서 searchname에 저장 
		try {
			list = mcdao.getSearchName(memberid, searchname);//로그인 멤버의 연락처에서 검색해서 ArrayList로 받는다
			model.addAttribute("contactList", list); 	// 에러 없으면 model에 연락처 목록 넣는다, key가 "contactList"
		} catch (Exception e) { 
			e.printStackTrace();				//예외추적내용 출력하고 
			model.addAttribute("error", "검색 목록보기 에러");//에러 상태면 model 에 error메시지가 들어간다
		}
		return "/member/Asearchcontact"; //Asearchcontact(.jsp)로 포워드, 이름 검색결과 목록보기 화면
	}
//====이름으로 검색해서 검색 결과 화면으로 넘기기: searchName() END===========================	

//====연락처 추가하기: addContact() ====================================================
	@GetMapping("/addcontact/")	//localhost:9988/member/addcontact/ : URL 주소 매핑- 바로 아래 메소드
	public String addContact(HttpSession session, Model model) { 
		try {
		String memberid= (String)session.getAttribute("memberid");
		MContactDto mcdto = new MContactDto();		//1명 연락처 담을 MContactDto 준비
		mcdto.setMemberid(memberid);		  	//로그인 멤버의 memberid 담기
		model.addAttribute("MContactDto",mcdto);	//연락처 추가 화면으로 보낼 준비
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error","연락처 추가 에러");//에러 발생시 에러 내용 넣어서 준비
		}
	return "member/Anewcontact"; 		//Anewcontact(.jsp)로 포워드, 연락처 추가 입력 화면 
	}
//====연락처 추가하기: addContact() END=================================================

//====새 연락처 정보 입력 받아 추가하기 준비=================================================

//----사진 파일 업로드 받기 위한 파일 경로 설정----------------------------------------------
	String fdir = "C:/education/spring_boot_dev/workspace/contact/src/main/resources/static/img/"; //연락처 이미지 파일 디렉토리
//----------------------------------------------------------------------------------
	
//====연락처 추가하기(새로 입력 받은 정보 DB넣기) addMemberContact(), multipart로 이미지 파일 받기==
@PostMapping("/addMemberContact/")	//localhost:9988/member/addcMemberContact/ : URL 주소 매핑- 바로 아래 메소드
public String addMemberContact(HttpSession session,@ModelAttribute MContactDto mcdto, Model model,@RequestParam("file") MultipartFile file) { 
	String memberid = (String)session.getAttribute("memberid");

//----이미지파일 저장 경로----------------		
	File dest = new File(fdir+"/"+file.getOriginalFilename()); // 넘어오는 파일의 이름을 꺼내서 이름만 일단 저장한다
//----이미지파일 저장 경로 END------------		
	try {
//----이미지파일 저장 ----------------------------		
		if(!file.isEmpty()) {			//이미지 파일이 업로드 되었으면 
			file.transferTo(dest);		//지정된 경로에 저장하고
			mcdto.setPhoto("/img/"+dest.getName()); //파일 이름을 DTO에 set한다
		}
		else {
			mcdto.setPhoto("/img/default.jpeg"); //디폴트 사진 이미지
		}
//----이미지파일 저장 END---------------------------		
		if(!mcdto.getName().isEmpty()) {	//이름 입력이 있는 경우만 DB에 추가 
			mcdto.setMemberid(memberid);
			mcdao.addContact(mcdto);	//DB에 넣기 위해 입력 정보 담은 mcdto를 mcdao로 보내기 
			//여기까지 실행되는 연락처 추가
		}
	} catch (Exception e) { 			// 에러 발생 한 경우
		e.printStackTrace();			//예외추적내용 출력하고
		model.addAttribute("error","연락처 추가 에러"); // 에러 넣기
	} 
	// 멤버의 연락처 목록보기 화면으로 넘기기
	return "redirect:/member/Acontacts/";//+mcdto.getMemberid(); //연락처 추가 후 redirect
}
//====연락처 추가하기(새로 입력 받은 정보 DB넣기) addMemberContact() END========================

//====연락처 수정하기 updateContact() =====================================================
	@PostMapping("/updatecontact/{contactid}")	//localhost:9988/member/updatecontact/{contactid} : URL 주소 매핑- 바로 아래 메소드
	public String updateContact(@PathVariable int contactid,@ModelAttribute MContactDto mcdto, Model model,@RequestParam("file") MultipartFile file) { 
		String memberid = "";
//----이미지파일 저장 경로------------------------
		File dest = new File(fdir+"/"+file.getOriginalFilename()); // 넘어오는 파일의 이름을 꺼내서 이름만 일단 저장한다
//----이미지파일 저장 경로 END--------------------		
		try {
//----이미지파일 저장 ---------------------------		
			if(!file.isEmpty()) {		//이미지 파일이 업로드 되었으면
				file.transferTo(dest);	//지정된 경로에 저장하고
				mcdto.setPhoto("/img/"+dest.getName()); //파일 이름을 DTO에 set한다
			}
			else {					//이미지 파일이 업로드 안되었으면 	
				String photopathfromdb = mcdao.getPhotoPath(contactid); // 기존 DB에 있는 파일 이름 가져와서
				mcdto.setPhoto(photopathfromdb); //파일 이름을 DTO에 set한다 
			}
//----이미지파일 저장 경로 END --------------------		
			memberid = mcdao.getMemberid(contactid); //회원의 memberid를 가져온다 
			mcdao.updateContact(mcdto);	//DB에 넣기 위해 입력 정보 담은 mcdto를 mcdao로 보내기 
			//여기까지 실행되는 연락처 추가
		} catch (Exception e) { 		// 에러 발생 한 경우
			e.printStackTrace();		//예외추적내용 출력하고
			model.addAttribute("error","연락처 수정 에러"); // 에러 넣기
		} 

		return "redirect:/member/Acontacts/";//+ memberid; //회원의 연락처 목록보기 화면으로 넘기기
	}
//====연락처 수정하기 updateContact() END==================================================
	
//====연락처 삭제하기 deleteContact() =====================================================	
	@GetMapping("/delete/{contactid}")	//localhost:9988/member/delete/{contactid} : URL 주소 매핑- 바로 아래 메소드	
	public String deleteContact(@PathVariable int contactid, Model model) { 
		String memberid = "";
		try {
			memberid = mcdao.getMemberid(contactid);	//해당 연락처의 contactid를 얻는다
			mcdao.delContact(contactid); 			//DB에서 삭제
		} catch (Exception e) {					//에러 발생한 경우
			e.printStackTrace(); 				//예외추적내용 출력하고
			model.addAttribute("error", "연락처 삭제 에러");	//에러 넣기
			// return 필요하긴 하다
		}
		return "redirect:/member/Acontacts/";//+memberid; 	//회원의 연락처 목록보기 화면으로 넘기기
	}
//====연락처 삭제하기 deleteContact() END=====================================================	
}
//====MemberWebController.java class END==================================================
