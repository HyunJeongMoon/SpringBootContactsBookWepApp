/****************************************************************
 * MContactDao.java
 * 회원의 연락처 정보를 위한 DAO 클래스
 * -------------------------------------------------------------
 * Oracle DB와 연동하기 위한 정보
 * DRIVER = "oracle.jdbc.driver.OracleDriver";
 *    URL = "jdbc:oracle:thin:@localhost:1521:xe";
 * USERID = "ora_user";
 * USERPW = "1234";
 ****************************************************************/
package com.naver.contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

//==MContactDao 클래스===============================================
@Repository 				//Repository 등록
public class MContactDao {

//	DB 연동을 위해 필요한 사항: driver, url, userid, userpw	
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERID = "ora_user";
	private final String USERPW = "1234";
	
//====Connection 생성 open() method ================================
	private Connection open() {
		Connection conn=null;
		try {
			Class.forName(DRIVER);			//driver를 로딩
//			url, userid, userpw로 connection 얻기
			conn = DriverManager.getConnection(URL, USERID, USERPW);
		} catch (ClassNotFoundException e) {		//클래스 없다는 예외발생하면		
			e.printStackTrace();			//예외추적내용 출력하고 
		} catch (SQLException e) {			//SQL예외 발생하면
			e.printStackTrace();			//예외추적내용 출력하고 
		}
		return conn;					//connection을 리턴
	}	
//====Connection 생성 open() method END=============================

//====연락처 추가 추가 메소드 => addContact(MContactDto): parameter MContactDto
	public void addContact(MContactDto dto) throws Exception{ 
		Connection conn = open();	//connection 만든다
//		새로운 연락처를 DB에 추가 하기 위해 연락처id를 얻는 SQL: 현재 있는 최대값에 +1
		String sqlgetidnumber = "select nvl(max(contactid),0) + 1 as newid from MEMBERSCONTACTS";
//		MEMBERSCONTACTS 테이블에 1명 연락처 INSERT 위한 SQL
		String sqlcontact="INSERT INTO memberscontacts						"
				+"		(contactid,name,phonenumber,address,moimid,photo)	"
				+"	VALUES	(	?						"	
				+"		,	?						"
				+"		, 	?						"
				+"		,	?						" 
				+"		,	?						"
				+"		, 	?						"
				+"		)							";
//		MEMBERCONTACTMAP 테이블에 회원ID와 연락처ID를 INSERT 하기위한 SQL
		String sqlmap = "INSERT INTO MEMBERCONTACTMAP		"
				+"		(MEMBERID,CONTACTID)	"
				+"	VALUES	( 	?		"
				+"		,	?		"
				+"		)			";
//		위 3개 SQL을 실행 시키기 위한 PreparedStatement 준비		
		PreparedStatement pstmt1 = conn.prepareStatement(sqlgetidnumber);
		PreparedStatement pstmt2 = conn.prepareStatement(sqlcontact);
		PreparedStatement pstmt3 = conn.prepareStatement(sqlmap);
		try(conn;pstmt1;pstmt2;pstmt3) {			// 자동 close
//			새연락처를 위한 연락처id를 얻는다
			int newid = 0;	
			ResultSet rs = pstmt1.executeQuery();		//쿼리실행
			rs.next();
			if(!rs.getString("newid").isEmpty()) {	
				newid = rs.getInt("newid");		//newid로 alias된 결과
			}
			else {
				newid = 0;				
			}
			
//			MEMBERSCONTACTS 테이블에 INSERT 하기: 바인딩 & SQL 실행			
			pstmt2.setInt	(1,newid);			//CONTACTID
			pstmt2.setString(2,dto.getName());		//NAME
			pstmt2.setString(3,dto.getPhonenumber());	//PHONENUMBER
			pstmt2.setString(4,dto.getAddress());		//ADDRESS
			pstmt2.setInt   (5,dto.getMoimid());		//MOIMID
			pstmt2.setString(6,dto.getPhoto());		//PHOTO
			pstmt2.executeUpdate(); 			//SQL 실행		

//			MEMBERCONTACTMAP 테이블에 INSERT 하기: 바인딩 & SQL 실행			
			pstmt3.setString(1,dto.getMemberid());		//MEMBERID
			pstmt3.setInt(2,newid);				//CONTACTID
			pstmt3.executeUpdate(); 			//SQL 실행
		}
	}
//==== addContact(MContactDto) method END============================

//==== 연락처  삭제 delContact() => return없다==========================
	public void delContact(int contactid) throws Exception{
		Connection conn = open();		//connection 만든다
//		MEMBERCONTACTMAP 테이블에서 삭제하는 SQL		
		String sqlmap = "DELETE FROM MEMBERCONTACTMAP WHERE CONTACTID = ? ";
//		MEMBERSCONTACTS 테이블에서 삭제하는 SQL
		String sqlcontact = "DELETE FROM MEMBERSCONTACTS WHERE CONTACTID = ? ";
		
//		위 2개 SQL을 실행 시키기 위한 PreparedStatement 준비		
		PreparedStatement pstmt1 = conn.prepareStatement(sqlmap);
		PreparedStatement pstmt2 = conn.prepareStatement(sqlcontact);

		try(conn;pstmt1;pstmt2){		//자동 close
			pstmt1.setInt(1,contactid);	//CONTACTID 바인딩	
			pstmt1.executeUpdate();		//MEMBERCONTACTMAP 테이블에서 먼저 삭제
			
			pstmt2.setInt(1,contactid);	//CONTACTID 바인딩
			pstmt2.executeUpdate();		//MEMBERSCONTACTS 테이블에서 그다음 삭제
						
		}
	}
//==== 연락처  삭제 delContact() END======================================

//==== getPhotoPath() 연락처id로 검색한 회원photo의 파일명 리턴================
	public String getPhotoPath(int contactid) throws Exception{
	    	Connection conn = open();		//connection 만든다
//			MEMBERSCONTACTS 테이블에서 SELECT 하는 SQL		    	
	 		String sql = "SELECT photo FROM MEMBERSCONTACTS WHERE CONTACTID = ? ";
//			위 SQL을 실행 시키기 위한 PreparedStatement 준비	
	 		PreparedStatement pstmt = conn.prepareStatement(sql);
			
	 		pstmt.setInt(1,contactid);		//CONTACTID 바인딩
	 		String photo = "";			//리턴위한 String 변수
	 		ResultSet rs = pstmt.executeQuery();	//쿼리 실행
			try (conn;pstmt;rs){
				while(rs.next())	{
				photo= rs.getString("photo");	//결과값 추출
				}
			}
			return photo;				//파일명 리턴
	     }
//==== getPhotoPath() END==============================================

//==== getMemberid() 연락처id로 검색한 회원id 리턴===========================
	public String getMemberid(int contactid) throws Exception{
    	Connection conn = open();				//connection 만든다
//		MEMBERCONTACTMAP 테이블에서 SELECT 하는 SQL		 		
    	String sql = "SELECT  MEMBERID  FROM MEMBERCONTACTMAP WHERE CONTACTID =  ? ";
//		위 SQL을 실행 시키기 위한 PreparedStatement 준비	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,contactid);			//CONTACTID 바인딩
 		String memberid = "";				//리턴위한 String 변수 
 		ResultSet rs = pstmt.executeQuery();		//SQL 실행
		try (conn;pstmt;rs){
			while(rs.next())	{
			memberid= rs.getString("memberid");	//결과값 추출
			}
		}
		return memberid;				//회원id 리턴
     }
//==== getMemberid() END ==============================================

//==== updateContact() 연락처 수정 ====================================== 
	public void updateContact(MContactDto mcdto) throws Exception{
		Connection conn = open();				//connection 만든다
//		MEMBERSCONTACTS 테이블에서 UPDATE 하는 SQL	
		String sql =	"UPDATE MEMBERSCONTACTS			"
			+ 	" 	SET	NAME = 		?	"
			+	"	  ,	PHONENUMBER = 	?	"
			+ 	"	  ,	ADDRESS = 	?	"
			+ 	"	  ,	MOIMID = 	?	"
			+ 	"	  ,	PHOTO = 	?	"
			+	" 	WHERE	CONTACTID = 	?	";

//		위 SQL을 실행 시키기 위한 PreparedStatement 준비	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try(conn;pstmt){					//자동close
			pstmt.setString(1,mcdto.getName());		//NAME
			pstmt.setString(2,mcdto.getPhonenumber());	//PHONEMUNBER
			pstmt.setString(3,mcdto.getAddress());		//ADDRESS
			pstmt.setInt   (4,mcdto.getMoimid());		//MOIMID
			pstmt.setString(5,mcdto.getPhoto());		//PHOTO
			pstmt.setInt   (6,mcdto.getContactid());	//CONTACTID
			if(pstmt.executeUpdate()==0) {			//예외발생시
				throw new SQLException("DB error");	//에러메시지
			}
		}
	}
//==== updateContact() END============================================ 

//==== getOne() 1명 연락처 가져오기=======================================
	public MContactDto getOne(int contactid) throws Exception{
		Connection conn =open();				//connection 만든다
//		MEMBERSCONTACTS,MEMBERCONTACTMAP,MOIM 테이블에서 SELECT 하는 SQL	
		String sql = "SELECT 	  mm.MEMBERID   		"
			+ "		, mc.CONTACTID			"
			+ "		, mc.NAME			"
			+ "		, mc.PHONENUMBER		"
			+ "		, mc.ADDRESS			"
			+ "		, mc.MOIMID			"	
			+ "		, m.MOIMNAME			"
			+ "		, mc.PHOTO			"
			+ "		, mc.REGDT			"
			+ "	 FROM	  MEMBERSCONTACTS mc		"	
			+ "		, MOIM m			"
			+ "		, MEMBERCONTACTMAP mm		"
			+ "	WHERE 	  mc.CONTACTID = ? 		"
			+ "	  AND 	  m.MOIMID = mc.MOIMID		"
			+ "	  AND 	  mm.CONTACTID = mc.CONTACTID	"
			+ "	ORDER BY  mc.CONTACTID ASC		";
//		위 SQL을 실행 시키기 위한 PreparedStatement 준비	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,contactid);		//CONTACTID 바인딩
//		연락처 1개 담을 MContactDto 준비		
		MContactDto mcdto = new MContactDto();
		ResultSet rs = pstmt.executeQuery();	//SQL 실행
		
		try (conn;pstmt;rs){
			while(rs.next()) {					//결과에서 연락처 정보 추출
				mcdto.setMemberid(rs.getString("memberid"));
				mcdto.setContactid(rs.getInt("contactid"));
				mcdto.setName(rs.getString("name"));
				mcdto.setPhonenumber(rs.getString("phonenumber"));
				mcdto.setAddress(rs.getString("address"));
				mcdto.setMoimid(rs.getInt("moimid"));
				mcdto.setMoimname(rs.getString("moimname"));
				mcdto.setPhoto(rs.getString("photo"));
				mcdto.setRegdt(rs.getDate("regdt"));
			}
		}
		return mcdto;			//1명 연락처 담은 MContactDto를 리턴
	}
//==== getOne() END===================================================
	
//==== getSearchName() 이름 검색 결과 보기================================
	public ArrayList<MContactDto> getSearchName(String memberid, String searchname) throws Exception{
		Connection conn =open();				//connection 만든다
//		MEMBERSCONTACTS,MEMBERCONTACTMAP,MOIM 테이블에서 SELECT 하는 SQL	
		String sql = "SELECT 	  mm.MEMBERID     		"
			+ "		, mc.CONTACTID			"
			+ "		, mc.NAME			"
			+ "		, mc.PHONENUMBER		"
			+ "		, mc.ADDRESS			"
			+ "		, mc.MOIMID			"	
			+ "		, m.MOIMNAME			"
			+ "		, mc.PHOTO			"
			+ "		, mc.REGDT			"
			+ "	FROM	  MEMBERSCONTACTS mc		"	
			+ "		, MEMBERCONTACTMAP mm		"
			+ "		, MOIM m			"
			+ "	WHERE 	  mm.MEMBERID  = ? 		"
			+ "	  AND 	  m.MOIMID = mc.MOIMID		"
			+ "	  AND 	  mm.CONTACTID = mc.CONTACTID	"
			+ "	  AND	  mc.NAME LIKE '%'|| ? || '%'	"	
			+ "   ORDER BY 	  mc.CONTACTID ASC		";
//		위 SQL을 실행 시키기 위한 PreparedStatement 준비	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,memberid);			//MEMBERID 바인딩
		pstmt.setString(2,searchname);			//검색어 searchname 바인딩
//		연락처 목록 담을 ArrayList 준비		
		ArrayList<MContactDto> contactsList = new ArrayList<>();
		ResultSet rs = pstmt.executeQuery();	//SQL 실행	
		
		try (conn;pstmt;rs){
			while(rs.next()) {
				MContactDto dto = new MContactDto(); // 1개의 연락처 저장
//				결과셋에서 연락처 정보 추출
				dto.setMemberid(rs.getString("memberid"));
				dto.setContactid(rs.getInt("contactid"));
				dto.setName(rs.getString("name"));
				dto.setPhonenumber(rs.getString("phonenumber"));
				dto.setAddress(rs.getString("address"));
				dto.setMoimid(rs.getInt("moimid"));
				dto.setMoimname(rs.getString("moimname"));
				dto.setPhoto(rs.getString("photo"));
				dto.setRegdt(rs.getDate("regdt"));
				
				contactsList.add(dto);		//ArrayList에 1명 추가					
			}	
		}
		if(contactsList.isEmpty()) {			//검색 결과 없을 때
			MContactDto dto = new MContactDto(); 
			dto.setMemberid(memberid);		//MEMBERID만 담은 DTO 만들어서 
			contactsList.add(dto);			//ArrayList에 추가한다
		}
		return contactsList;				//ArrayList 리턴
	}
//==== getSearchName() END ================================================

//==== getAll() 회원의 연락처 전체 목록 보기 ====================================
	public ArrayList<MContactDto> getAll(String memberid) throws Exception{
		Connection conn =open();				//connection 만든다
//		MEMBERSCONTACTS,MEMBERCONTACTMAP,MOIM 테이블에서 SELECT 하는 SQL	
		String sql ="SELECT 	 mm.MEMBERID	 			"
			+ "		, mc.CONTACTID				"
			+ "	 	, mc.name				"
			+ "	 	, mc.phonenumber			"
			+ "	 	, mc.address				"
			+ "	 	, mc.moimid				"
			+ "	 	, m.moimname				"
			+ "	 	, mc.photo				"
			+ "	 	, mc.REGDT				"
			+ "  FROM	  MEMBERSCONTACTS mc	 		"
			+ "  	 	, MEMBERCONTACTMAP mm			"
			+ "  	 	, MOIM m 				"
			+ "  WHERE 	  mm.MEMBERID = 		?	"
			+ "    AND 	  mm.CONTACTID = mc.CONTACTID		"
			+ "    AND 	  m.MOIMID = mc.MOIMID 			"
			+ " ORDER BY mc.CONTACTID ASC				";
//		위 SQL을 실행 시키기 위한 PreparedStatement 준비	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,memberid);		//MEMBERID 바인딩
//		연락처 목록 담을 ArrayList 준비		
		ArrayList<MContactDto> contactsList = new ArrayList<>();
		ResultSet rs = pstmt.executeQuery();	//SQL실행
		try (conn;pstmt;rs){			//자동 close
			while(rs.next()) {
				MContactDto dto = new MContactDto(); // 1개의 연락처 저장
//				결과셋에서 연락처 정보 추출
				dto.setMemberid(rs.getString("memberid"));
				dto.setContactid(rs.getInt("contactid"));
				dto.setName(rs.getString("name"));
				dto.setPhonenumber(rs.getString("phonenumber"));
				dto.setAddress(rs.getString("address"));
				dto.setMoimid(rs.getInt("moimid"));
				dto.setMoimname(rs.getString("moimname"));
				dto.setPhoto(rs.getString("photo"));
				dto.setRegdt(rs.getDate("regdt"));

				contactsList.add(dto);		//ArrayList에 1명 추가
			}
		}
		if(contactsList.isEmpty()) {			//검색 결과 없을 때
			MContactDto dto = new MContactDto(); 
			dto.setMemberid(memberid);		//MEMBERID만 담은 DTO 만들어서
			contactsList.add(dto);			//ArrayList에 추가한다
		}
		return contactsList;				//ArrayList 리턴
	}
//==== getAll() END=====================================================
}
//==MContactDao 클래스 END===============================================
