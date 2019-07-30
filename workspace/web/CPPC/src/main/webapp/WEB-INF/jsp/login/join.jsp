<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/common.css'/>"/>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.4.1.min.js"/>"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#userPw, #userPwChk").keyup(function(event){
		if($("#userPw").val() != null
				&& $("#userPw").val() != ""
				&& $("#userPwChk").val() != null
				&& $("#userPwChk").val() != ""
				&& $("#userPw").val() == $("#userPwChk").val()){
			$("#pwCheckOk").attr('class','btn btn-sm btn-block btn-success');
		}else{
			$("#pwCheckOk").attr('class','btn btn-sm btn-block btn-danger');
		}
	});
	
	$("#submit").click(function(){
		submit();
	});
});

function submit(){
	
	if($("#userId").val() == null || $("#userId").val() == ""){
		alert("아이디를 입력해주세요.");
		$("#userId").focus();
		return true;
	}

	if($("#userPw").val() == null || $("#userPw").val() == ""){
		alert("비밀번호를 입력해주세요.");
		$("#userPw").focus();
		return true;
	}

	if($("#userPwChk").val() == null || $("#userPwChk").val() == ""){
		alert("비밀번호 확인을 입력해주세요.");
		$("#userPwChk").focus();
		return true;
	}
	
	if($('#pwCheckOk').attr('class').indexOf('success') < 0){
		alert("비밀번호가 일치하지 않습니다.");
		$("#userPw").val("");
		$("#userPwChk").val("");
		
		$("#userPw").focus();
		return true;
	}

	if($("#userEmail").val() == null || $("#userEmail").val() == ""){
		alert("이메일 주소를 입력해주세요.");
		$("#userEmail").focus();
		return true;
	}
}
</script>
</head>
<body style="background-color:#22272d;">
<form action="<c:url value='/login/loginCheck.cpp'/>" method="post" style="width:300px; height:400px; margin:auto; text-align:center; color:#676c71;">
	<div class="page-header">
		<h1 style="color:#ffffff;">회원가입</h1>
	</div>
	<div class="form-group" style="text-align:left;">
		<label class="_label_title" for="userId">UserID</label>
		<input type="text" class="form-control" name="userId" id="userId" placeholder="아이디를 입력하세요." autocomplete="off">
		<button type="button" class="btn btn-sm btn-block" id="idCheckOk">중복확인</button>
		<label class="_label_title" for="userPw">Password</label>
		<input type="password" class="form-control" name="userPw" id="userPw" placeholder="비밀번호를 입력하세요." autocomplete="off">
		<label class="_label_title" for="userPwChk">Password Check</label>
		<input type="password" class="form-control" name="userPwChk" id="userPwChk" placeholder="비밀번호를 입력하세요." autocomplete="off">
		<button type="button" class="btn btn-sm btn-block" disabled="disabled" id="pwCheckOk">비밀번호 일치여부</button>
		<label class="_label_title" for="userEmail">Email</label>
		<input type="email" class="form-control" name="userEmail" id="userEmail" placeholder="e-mail주소를 입력하세요." autocomplete="off">
	</div>
	<button type="button" class="btn btn-primary btn-lg btn-block" id="submit">제출</button>
</form>
</body>
</html>