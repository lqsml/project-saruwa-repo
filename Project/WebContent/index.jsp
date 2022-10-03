<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String uId_Session = (String)session.getAttribute("uId_Session"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<div id="wrap">
	
		<!-- 헤더 영역 시작 -->
		<jsp:include page="/Common/headerTmp.jsp"/>
		<!-- 헤더 영역 끝  -->
		<main id="main">
		
		</main>
	</div>

</body>
</html>