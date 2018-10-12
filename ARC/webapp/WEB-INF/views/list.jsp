<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 18. 10. 8
  Time: 오후 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>나의 투자리스트</title>
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
        <a class="navbar-brand" href="main.jsp">투자상품리스트페이지</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse01">
        <ul class="nav navbar-nav">
            <li><a href="main.jsp">투자상품 리스트</a></li>
            <li><a href="bbs.jsp">나의 투자 리스트</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle"
                   data-toggle="dropdown" role="button" aria-haspopup="true"
                   aria-expanded="false">접속하기<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="login.jsp">로그인</a></li>
                    <li><a href="join.jsp">회원가입</a></li>
                </ul>
            </li>
        </ul>
    </div>

    <div class="container">
        <div class="row">
            <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
                <thead>
                    <tr>
                        <th style="background-color: #eeeeee; text-align: center;">번호</th>
                        <th style="background-color: #eeeeee; text-align: center;">상품이름</th>
                        <th style="background-color: #eeeeee; text-align: center;">기간(개월)</th>
                        <th style="background-color: #eeeeee; text-align: center;">수익률(세전)</th>
                        <th style="background-color: #eeeeee; text-align: center;">투자금액</th>
                        <th style="background-color: #eeeeee; text-align: center;">수익금(세전)</th>
                        <th style="background-color: #eeeeee; text-align: center;">세금</th>
                        <th style="background-color: #eeeeee; text-align: center;">수수료</th>
                        <th style="background-color: #eeeeee; text-align: center;">예상총수익금</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>1</td>
                        <td>상품1</td>
                        <td>9</td>
                        <td>30.3%</td>
                        <td>만원</td>
                        <td>삼만원</td>
                        <td>10%</td>
                        <td>오천원</td>
                        <td>이만이천원</td>
                    </tr>

                    <tr>
                        <td>2</td>
                        <td>상품2</td>
                        <td>6</td>
                        <td>50.1%</td>
                        <td>만원</td>
                        <td>팔만원</td>
                        <td>10%</td>
                        <td>오천원</td>
                        <td>육만칠천원</td>
                    </tr>
                </tbody>
            </table>
            <a href="write.jsp" class="btn btn-primary pull-right">투자등록</a>
        </div>
    </div>

<h1>투자 리스트</h1>
<c:forEach items="${requestScope.myGoodsList}" var="goodslist">
    ${goodslist.goodsName}
    ${goodslist.profitRatio}<br>
</c:forEach>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>