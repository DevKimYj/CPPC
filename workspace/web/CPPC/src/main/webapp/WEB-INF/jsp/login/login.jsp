<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>"/>
<title>로그인</title>
<script type="text/javascript">
function check(){
	if('${result}' == 'S'){
		window.location.href = "<c:url value='/main.cpp'/>";
	}
}
</script>
</head>
<body onload="check();" style="background-color:#22272d;">
<form action="<c:url value='/login/loginCheck.cpp'/>" method="post" style="width:300px; height:400px; margin:auto; text-align:center; color:#676c71;">
	<div class="page-header">
		<h1 style="color:#ffffff;">Log in</h1>
	</div>
	<div class="form-group" style="text-align:left;">
		<label for="userId">UserID</label>
		<input type="text" class="form-control" name="userId" id="userId" placeholder="아이디를 입력하세요." autocomplete="off">
	</div>
	<div class="form-group" style="text-align:left;">
		<label for="userPw">Password</label>
		<input type="password" class="form-control" name="userPw" id="userPw" placeholder="비밀번호를 입력하세요." autocomplete="off">
	</div>
	<button type="submit" class="btn btn-primary btn-lg btn-block">Log in</button>
	<div style="text-align:center; margin-top:10px;">
		<span><a href="#" class="alert-link" style="text-decoration:none">비밀번호 찾기</a> | <a href="#" class="alert-link" style="text-decoration:none">회원가입</a></span>
	</div>
</form>
</body>
</html>