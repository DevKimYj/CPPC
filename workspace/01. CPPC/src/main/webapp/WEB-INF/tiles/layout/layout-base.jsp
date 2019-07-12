<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/layout.css'/>"/>
</head>
<body class="_body">
	<div style="float:left; width:100%;">
		<tiles:insertAttribute name="header"/>
	</div>
	<div style="float:left; width:100%;">
		<div style="float:left; width:30px; height:100vh; background-color:#000000;">
			<tiles:insertAttribute name="menu"/>
		</div>
		<div style="float:left; width:*;">
			<tiles:insertAttribute name="contents"/>
		</div>
	</div>
</body>
</html>