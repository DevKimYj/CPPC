<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" />
<title><tiles:insertAttribute name="title"/></title>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/layout.css'/>"/>
</head>
<body class="_body">
	<div class="_header">
		<tiles:insertAttribute name="header"/>
	</div>
	<div class="_contents">
		<tiles:insertAttribute name="contents"/>
	</div>
	<div class="_footer">
		<tiles:insertAttribute name="footer"/>
	</div>
</body>
</html>