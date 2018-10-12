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
    <title>Title</title>
</head>
<body>
<h1>투자 리스트</h1>
<c:forEach items="${requestScope.myGoodsList}" var="goodslist">
    ${goodslist.goodsName}<br>
    ${goodslist.profitRatio}<br>
</c:forEach>

</body>
</html>