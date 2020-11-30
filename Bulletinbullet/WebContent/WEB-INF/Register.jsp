<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録画面</title>
</head>
<body>
<p>必要事項を入力してください</p>
<c:if test="${not empty regerrormsg}">
<p>${regerrormsg}</p>
</c:if>
<form action="/Bulletinbullet/Registerservlet" method="post">
ユーザーID(メールアドレス):<input type="text"name="userid"><br>
ユーザーネーム:<input type="text" name="name"><br>
パスワード:<input type="password"name="pass"><br>
<input type="submit" value="新規登録">
</form>
<a href="/Bulletinbullet/">TOPへ戻る</a>
</body>
</html>