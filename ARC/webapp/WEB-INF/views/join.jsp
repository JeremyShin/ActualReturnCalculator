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
    <title>회원가입 페이지만들기.</title>
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
            <a class="navbar-brand" href="main.jsp">회원가입 페이지</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse01">
            <ul class="nav navbar-nav">
                <li><a href="/list">투자상품 리스트</a></li>
                <li><a href="bbs.jsp">나의 투자 리스트</a></li>
            </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle"
                   data-toggle="dropdown" role="button" aria-haspopup="true"
                   aria-expanded="false">접속하기<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/login">로그인</a></li>
                    <li class="active"><a href="join.jsp">회원가입</a></li>
                </ul>
            </li>
        </ul>
        </div>
    </nav>

    <div class="container">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <div class="jumbotron" style="padding-top: 20px;">
                <from method="post" action="/joinAction">
                    <h3 style="text-align:center;">회원가입화면</h3>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="아이디" name="id" maxlength="20">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="비밀번호" name="password">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="이름" name="name" maxlength="20">
                    </div>
                    <div class="form-group">
                        <input type="email" class="form-control" placeholder="이메일" name="email" maxlength="50">
                    </div>
                    <input type="submit" class="btn btn-primary form-control" value="회원가입">
                </from>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>