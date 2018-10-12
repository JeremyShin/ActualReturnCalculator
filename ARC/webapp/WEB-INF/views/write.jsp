<%--
  Created by IntelliJ IDEA.
  User: crazy
  Date: 18. 10. 11
  Time: 오후 1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ArcWrite</title>
</head>
<body>
    <h1>투자 입력</h1>

    <form method="post" action="/write">
        상품이름 : <input type="int" name="gdsCd"><br>
        <%--
        <select name="gdsCd">
            <c:forEach var="goodslist" items="${requestScope.myGoodsList}">
                <option value="">${goodslist.goodsName}</option>
            </c:forEach>
        </select><br>
    </select>
        --%>
        투자금액 : <input type="double" name="investPrice"><br>
        투자기간 : <input type="int" name="investPeriod"><br>
        <input type="submit">
    </form>
</body>
</html>
