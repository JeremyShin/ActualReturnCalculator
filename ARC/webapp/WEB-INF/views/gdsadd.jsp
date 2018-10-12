<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ArcAdd</title>
</head>
<body>
<h1>상품 등록</h1>

<form method="post" action="/add">
    상품 이름 : <input type="String" name="gdsCd"><br>
    수익률 : <input type="Long" name="prfRto"><br>
    수수료 : <input type="float" name="cms"><br>
    <input type="submit">
</form>
</body>
</html>