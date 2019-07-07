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
    <c:forEach items="${requestScope.product.data}" var="val">
        ${val.name}<br/><br/>
        <c:forEach items="${val.foods}" var="food">
            ${food.name}<br/>
            ${food.price}<br/>
            ${food.description}<br/><br/>
            <a href="${pageContext.request.contextPath}/product/addCart?id=${food.id}&name=${food.name}&price=${food.price}">添加购物车</a><br/>
        </c:forEach>
        <hr>
    </c:forEach>

</body>
</html>