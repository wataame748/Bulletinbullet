<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<h1>ログイン</h1>
<c:if test="${not empty logerrormsg}">
<p>${logerrormsg}</p>
</c:if>
<form action="/Bulletinbullet/Loginservlet" method="post">
ユーザーID:<input type="text"name="userid"><br>
パスワード:<input type="password"name="pass"><br>
<input type="submit" value="ログイン">
</form>
<a href="/Bulletinbullet/">TOPへ戻る</a>
</body>
</html>