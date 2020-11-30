<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value= "${Post.title }"></c:out></title>
</head>
<body>
<p>
date:<c:out value="${Post.date }"></c:out><br>
title:<c:out value="${Post.title }"></c:out><br>
from:<c:out value="${Post.username }"></c:out><br>
text:<c:out value="${Post.text}"></c:out>
</p>
<a href="/Bulletinbullet/Postbreakservlet">投稿一覧へ</a>
</body>
</html>