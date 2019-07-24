<%--
  Author: Feiyue
  Date: 2019/7/24 21:29
  Desc: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--JSTL标签--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>账户信息展示</title>
</head>
<body>
<tr>
    <th>账户id</th>
    <th>账户名称</th>
    <th>账户金额</th>
</tr>
<c:forEach items="${accounts}" var="account">
    <tr>
        <td>${account.id}</td>
        <td>${account.name}</td>
        <td>${account.money}</td>
    </tr>
</c:forEach>
</body>
</html>
