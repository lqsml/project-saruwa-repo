package pack_Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import pack_DBCP.DBConnectionMgr;

public class AdminMgr {
	
	private Connection objConn = null;
	private Statement objStmt = null;
	private PreparedStatement objPstmt = null;
	private ResultSet objRS = null;
	private DBConnectionMgr objPool = null;

	// 로그인
		public boolean memberLogin(String uId, String uPw) {
			boolean loginRes = false;

			try {

				objPool = DBConnectionMgr.getInstance();
				objConn = objPool.getConnection();

				String sql = "select count(*) from manager where mgrID = ? and mgrPW = ?";
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
