/*****************************************************************
 * MContactDto.java
 * 회원의 연락처 정보 저장 DTO 클래스
 * 
 ****************************************************************/
package com.naver.contact;

import java.sql.Date;
//==MContactDto 클래스===========================================
public class MContactDto {
	
	private String 	memberid;		//회원id 
	private int 	contactid;		//연락처id
	private String	name;			//이름
	private String	phonenumber;		//전화번호
	private String	address;		//주소
	private int		moimid;		//그룹id
	private String	moimname;		//그룹이름
	private String	photo;			//이미지파일명
	private Date	regdt;			//등록날짜
//==멤버변수 memberid를 위한 getter & setter====================== 	
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
//==멤버변수 memberid를 위한 getter & setter END==================

//==멤버변수 contactid를 위한 getter & setter ====================
	public int getContactid() {
		return contactid;
	}
	public void setContactid(int contactid) {
		this.contactid = contactid;
	}
//==멤버변수 contactid를 위한 getter & setter END==================

//==멤버변수 name을 위한 getter & setter ==========================
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//==멤버변수 name을 위한 getter & setter END=======================

//==멤버변수 phonenumber를 위한 getter & setter====================
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
//==멤버변수 phonenumber를 위한 getter & setter END================

//==멤버변수 address를 위한 getter & setter========================
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
//==멤버변수 address를 위한 getter & setter END====================
	
//==멤버변수 moimid를 위한 getter & setter ========================
	public int getMoimid() {
		return moimid;
	}
	public void setMoimid(int moimid) {
		this.moimid = moimid;
	}
//==멤버변수 moimid를 위한 getter & setter END=====================

//==멤버변수 moimname을 위한 getter & setter ======================
	public String getMoimname() {
		return moimname;
	}
	public void setMoimname(String moimname) {
		this.moimname = moimname;
	}
//==멤버변수 moimname을 위한 getter & setter END===================

//==멤버변수 photo를 위한 getter & setter =========================
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
//==멤버변수 photo를 위한 getter & setter END======================
	
//==멤버변수 regdt를 위한 getter & setter =========================
	public Date getRegdt() {
		return regdt;
	}
	public void setRegdt(Date regdt) {
		this.regdt = regdt;
	}
//==멤버변수 regdt를 위한 getter & setter END======================
}
//==MContactDto 클래스 END=======================================
