package pack_Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import pack_DBCP.DBConnectionMgr;

public class MemberMgr {

	Connection objConn = null;
	Statement objStmt = null;
	PreparedStatement objPstmt = null;
	ResultSet objRS = null;
	DBConnectionMgr objPool = null;

	// 아이디 중복 검사
	public boolean checkID(String id) {
		boolean chkRes = false; // 거짓이면 사용 가능

		try {

			objPool = DBConnectionMgr.getInstance();
			objConn = objPool.getConnection();

			String sql = "select count(*) from UserInfo where uId = ?";
			objPstmt = objConn.prepareStatement(sql);
			objPstmt.setString(1, id);
			objRS = objPstmt.executeQuery();

			if (objRS.next()) {
				int cnt = objRS.getInt(1);
				if (cnt == 1)
					chkRes = true;
			}

		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		} finally {
			objPool.freeConnection(objConn, objPstmt, objRS);
		}

		return chkRes;
	}

	// 회원가입
	public boolean memberJoin(MemberBean mBean) {

		boolean joinRes = false;

		try {

			objPool = DBConnectionMgr.getInstance();
			objConn = objPool.getConnection();

			String sql = "insert into UserInfo ";
			sql += "(uId, uPw, uName, uEmail, uPhone, zipcode, address, faveFood, sa, joinTM) ";
			sql += "values (?, ?, ?, ?, ?, ?, ?, ?, ?, now())";

			objPstmt = objConn.prepareStatement(sql);

			objPstmt.setString(1, mBean.getuId());
			objPstmt.setString(2, mBean.getuPw());
			objPstmt.setString(3, mBean.getuName());
			objPstmt.setString(4, mBean.getuEmail());
			objPstmt.setString(5, mBean.getuPhone());
			objPstmt.setString(6, mBean.getZipcode());
			objPstmt.setString(7, mBean.getAddress());

			String[] faveFood = mBean.getFaveFood();
			String[] foodName = { "한식", "양식", "일식", "중식", "분식" };
			char[] foodCode = { '0', '0', '0', '0', '0' };
			for (int i = 0; i < faveFood.length; i++) {
				for (int j = 0; j < foodName.length; j++) {
					if (faveFood[i].equals(foodName[j])) {
						foodCode[j] = '1';
					}
				}
			}
			objPstmt.setString(8, new String(foodCode));
			objPstmt.setInt(9, mBean.getSa());

			int rowCnt = objPstmt.executeUpdate();

			if (rowCnt == 1) {
				joinRes = true;
			}

		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		} finally {
			objPool.freeConnection(objConn, objPstmt);
		}

		return joinRes;
	}

	// 로그인
	public boolean memberLogin(String uId, String uPw) {
		boolean loginRes = false;

		try {

			objPool = DBConnectionMgr.getInstance();
			objConn = objPool.getConnection();

			String sql = "select count(*) from UserInfo where uId = ? and uPw = ?";
			objPstmt = objConn.prepareStatement(sql);

			objPstmt.setString(1, uId);
			objPstmt.setString(2, uPw);
			objRS = objPstmt.executeQuery();

			if (objRS.next()) {

				int recordCnt = objRS.getInt(1);
				if (recordCnt == 1)
					loginRes = true;

			}

		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		} finally {
			objPool.freeConnection(objConn, objPstmt, objRS);
		}

		return loginRes;
	}

}
