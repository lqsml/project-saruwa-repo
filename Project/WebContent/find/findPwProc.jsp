<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="mMgr" class="pack_Member.MemberMgr"/>

<%
request.setCharacterEncoding("UTF-8");
String uName = request.getParameter("uName");
String uId = request.getParameter("uId");
String uEmail = request.getParameter("uEmail");

%>

<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
 	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta charset="UTF-8">
		<title>비밀번호 찾기</title>
		<link rel="shortcut icon" href="#">
		<link rel="stylesheet" href="/style/style.css">
		<script src="/source/jquery-3.6.0.min.js"></script>
		<script src="/script/find_script.js"></script>	
</head>
<body>
	<div id="wrap_Popup">
		<span>
		<%
		String uPw = mMgr.PWFind(uName, uId, uEmail);
		
		if(uPw != null){
			out.print("고객님의 비밀번호는 <b>" + uPw + "</b> 입니다.");
		} else{
			out.print("일치하는 정보가 없습니다. 다시 입력해주세요.");
		}
		%>
		</span>
		<hr>
		<div id="popUpBtnArea">
			<button type="button" id="closeBtn" class="findPopupBtn">닫기</button>
		</div>
	
	</div>
</body>
</html>

