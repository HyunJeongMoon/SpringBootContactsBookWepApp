/*************************************************************
 * MemberDao.java
 * 회원 가입정보를 위한 DAO 클래스
 * -----------------------------------------------------------
 * Oracle DB와 연동하기 위한 정보
 * DRIVER = "oracle.jdbc.driver.OracleDriver";
 *    URL = "jdbc:oracle:thin:@localhost:1521:xe";
 * USERID = "ora_user";
 * USERPW = "1234";
 *************************************************************/
package com.naver.contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;
import com.naver.contact.MemberDto;

//==== MemberDao 클래스============================================
@Repository				//repository 등록
public class MemberDao {
	
//	DB 연동을 위해 필요한 사항: driver, url, userid, userpw	
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERID = "ora_user";
	private final String USERPW = "1234";
	
//====Connection 생성 open() method ================================
	private Connection open() {
		Connection conn=null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

//==== open() END===================================================
	
//==== addMember(MemberDto): parameter MemberDto 받아야 한다==========
	public void addMember(MemberDto dto) throws Exception{ 
		Connection conn = open();		//connection 만든다
//		새로운 회원을 DB에 추가 하기 위한 SQL
		String	sql= "insert into members(memberid,memberpassword)	"
				   + " values(									    "
				   + "	 	?										"
				   + "	,	? )										";
		
//		SQL실행 위한 PreparedStatement
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try(conn;pstmt) {	// 자동 close 
			pstmt.setString(1,dto.getMemberid());		//MEMBERID 바인딩
			pstmt.setString(2,dto.getMemberpassword());	//MEMBERPASSWORD 바인딩
			pstmt.executeUpdate(); 						//SQL 실행
		}
	}
//==== addMember() method END================================================
//==== validationMember():회원id 조회==================================
	public String validationMember(MemberDto dto) throws Exception{
//		authentication result string
		String result="";
//		DB 연결
		Connection conn =open();
//		SQL: members 테이블에서 SELECT 
		String sql = "select memberid from members where memberid = ? "; 
//		SQL실행 위한 PreparedStatement
		PreparedStatement pstmt = conn.prepareStatement(sql);
//			validation 위한 memberid 바인딩		
		pstmt.setString(1,dto.getMemberid());
//			SQL 실행 해서 ResultSet 에 저장		
		ResultSet rs = pstmt.executeQuery();
		
		try (conn;pstmt;rs){
			rs.next();
			if(rs.getString("memberid").isEmpty()) {
				result = "pass";	//MEMBERS 테이블에 등록된 ID, PASSWD 일치하면 "pass"
			}
			else {
				result = "fail";	//ID, PASSWD 일치하지 않거나 없는 회원이면 "fail"
			}
		}
		return result;				//결과 리턴
	}
	
//==== validationMemberid():회원id 조회==================================
//==== authenticationMember(): 등록 회원 인증=============================
	public String authenticationMember(MemberDto dto) throws Exception{
//		authentication result string
		String result="";
//		DB 연결
		Connection conn =open();
//		SQL: members 테이블에서 SELECT 
		String sql = "select memberid, memberpassword from members where memberid = ? and memberpassword = ?";
//		SQL실행 위한 PreparedStatement
		PreparedStatement pstmt = conn.prepareStatement(sql);
//			authentication 위한 memberid, memberpassword 바인딩		
		pstmt.setString(1,dto.getMemberid());
		pstmt.setString(2,dto.getMemberpassword());
//			SQL 실행 해서 ResultSet 에 저장		
		ResultSet rs = pstmt.executeQuery();
		
		try (conn;pstmt;rs){
			rs.next();
			if(!rs.getString("memberid").isEmpty()) {
				result = "pass";	//MEMBERS 테이블에 등록된 ID, PASSWD 일치하면 "pass"
			}
			else {
				result = "fail";	//ID, PASSWD 일치하지 않거나 없는 회원이면 "fail"
			}
		}
		return result;				//결과 리턴
	}
//==== authenticationMember() END=======================================
	
//==== delMember():  멤버 삭제 ===========================================
	public void delMember(String memberid) throws Exception{
//		DB 연결
		Connection conn = open();
//		SQL: 멤버 삭제 위한 DELETE
		String sql = "delete from members where memberid = ? ";
//		SQL 실행을 위한 PreparedStatement
		PreparedStatement pstmt = conn.prepareStatement(sql);
//		SQL 실행: pstmt.executeUpdate()
		try(conn;pstmt){
			pstmt.setString(1, memberid);
			if(pstmt.executeUpdate()==0) {
				throw new SQLException("DB error");
			}
		}
	}
//==delMember() END===================================================	
}
//==== MemberDao 클래스 END============================================
