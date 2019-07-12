<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div style="width:25%;">
		<tiles:insertAttribute name="menu"/>
	</div>
	<div style="width:75%;">
		<tiles:insertAttribute name="header"/>
		<tiles:insertAttribute name="content"/>
	</div>
</body>
</html>