/*********************************************************
 * MemberDto.java
 * 회원 가입정보를 위한 DTO 클래스
 * 
 ********************************************************/
package com.naver.contact;
//==== MemberDto 클래스 ====================================
public class MemberDto {

	private String memberid;		//회원id
	private String memberpassword;		//회원패스워드

//==멤버변수 memberid를 위한 getter & setter======================	
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
//==멤버변수 memberid를 위한 getter & setter END===================	

//==멤버변수 memberpassword를 위한 getter & setter=================	
	public String getMemberpassword() {
		return memberpassword;
	}
	public void setMemberpassword(String memberpassword) {
		this.memberpassword = memberpassword;
	}
//==멤버변수 memberpassword를 위한 getter & setter END============	
}
//==== MemberDto 클래스 END ===================================
