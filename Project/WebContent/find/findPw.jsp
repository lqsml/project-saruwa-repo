<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
 	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta charset="UTF-8">
		<title>Document</title>
		<link rel="shortcut icon" href="#">
		<link rel="stylesheet" href="/style/style.css">
		<script src="/source/jquery-3.6.0.min.js"></script>
		<script src="/script/find_script.js"></script>		
		<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="wrap">
	
		<jsp:include page="/Common/headerTmp.jsp"/>
	
		<main id="main">
			
			<h1>아이디 찾기</h1>
			<hr>
			<form name="findPwFrm" id="findPwFrm">
				<div id="findArea" >
					<div id="infoInput" class="d-flex">
						<div id="uNameInput">
							이름 <input type="text" name="uName" id="uName">						
						</div>
						<div id="uIdInput">
							아이디 <input type="text" name="uId" id="uId">						
						</div>
						<div id="uEmailInput">
							이메일 <input type="text" name="uEmail" id="uEmail">						
						</div>
					</div> 
					<div  id="btnArea">
						<button type="button" id="findPwBtn">비밀번호 찾기</button>
					</div>
				</div>
			</form>


		</main>
		
	</div>
</body>
</html>