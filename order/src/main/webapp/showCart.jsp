<%@page isELIgnored="false" contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <c:forEach items="${sessionScope.cart}" var="val">
        ${val.value.name}<br/>
        ${val.value.price}<br/>
        ${val.value.count}<br/>
        ${val.value.totalPrice}<br/>
        <hr>
    </c:forEach>
    <a href="${pageContext.request.contextPath}/product/createOrder">添加订单</a>
</body>
</html>