<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>ArcBBS</title>
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
        <a class="navbar-brand" href="/bbs">게시판</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse01">
        <ul class="nav navbar-nav">
            <li><a href="/list">투자상품 리스트</a></li>
            <li><a href="/write">나의 투자 리스트</a></li>
            <li class="active"><a href="/bbs">게시판</a></li>
        </ul>

        <c:if test="${sessionScope.id == null}">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle"
                       data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">접속하기<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/login">로그인</a></li>
                        <li><a href="/join">회원가입</a></li>
                    </ul>
                </li>
            </ul>
        </c:if>
        <c:if test="${sessionScope.id != null}">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle"
                       data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">접속하기<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/logout">로그아웃</a></li>
                    </ul>
                </li>
            </ul>
        </c:if>

    </div>
</nav>

<div class="container">
    <div class="row">
      <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
          <thead>
          <tr>
              <th style="background-color: #eeeeee; text-align: center;">번호</th>
              <th style="background-color: #eeeeee; text-align: center;">제목</th>
              <th style="background-color: #eeeeee; text-align: center;">작성자</th>
          </tr>
          </thead>
          <tbody>
            <tr>
                <td>1</td>
                <td>안녕하세요</td>
                <td>홍길동</td>
            </tr>
          </tbody>
      </table>
        <a href="/bbswrite" class="btn btn-primary pull-right">글쓰기</a>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>