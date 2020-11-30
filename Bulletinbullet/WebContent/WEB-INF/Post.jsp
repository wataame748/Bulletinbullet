<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板画面</title>
</head>
<body>
<h1>★掲示板★</h1>
<p><c:out value="${user.name }"/>ログイン中</p><br>
<p>◆投稿一覧</p>
<a href="/Bulletinbullet/Postservlet">■更新</a>
<c:forEach var="post" items="${postlist}">
<p>
<c:out value="${post.date}"></c:out>
<a href="/Bulletinbullet/Posttextservlet?userid=${post.postid}&pdate=${post.date}"><c:out value="${post.title}"/></a>
<c:out value="${post.username}"/></p>
</c:forEach>
<c:if test="${not empty posterrormsg}">
<p>${posterrormsg}</p>
</c:if>
<p>◆新規投稿</p>
<form action="/Bulletinbullet/Postservlet" method="post">
タイトル:<input type="text" name="title"><br>
<textarea name="text" placeholder="メッセージを入力"></textarea>
<input type="submit" value="投稿">
</form>
<a href="/Bulletinbullet/">■ログアウト</a>
</body>
</html>
