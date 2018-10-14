<%--
  Created by IntelliJ IDEA.

  User: jycs
  Date: 18. 10. 11
  Time: 오후 7:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>login 페이지만들기.</title>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapse"
                data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                aria-expanded="false">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/write">투자입력페이지</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse01">
        <ul class="nav navbar-nav">
            <li><a href="/list">투자상품 리스트</a></li>
            <li><a href="/write">나의 투자 리스트</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle"
                   data-toggle="dropdown" role="button" aria-haspopup="true"
                   aria-expanded="false">접속하기<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/login">로그인</a></li>
                    <li class="active"><a href="/join">회원가입</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="col-lg-4"></div>
    <div class="col-lg-4">
        <div class="jumbotron" style="padding-top: 20px">
            <form method="post" action="/write">
                <h3 style="text-align: center;">상품 투자</h3>
                <div class="form-group">
                    <input type="number" class="form-control" placeholder="상품코드" name="gdsCd" min="0">
                </div>
                <div class="form-group">
                    <input type="number" class="form-control" placeholder="투자금액" name="investPrice" min="1">
                </div>
                <div class="form-group">
                    <input type="number" class="form-control" placeholder="투자기간" name="investPeriod" min="1">
                </div>
                <input type="submit" class="btn btn-primary form-control" value="투자하기">
            </form>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>