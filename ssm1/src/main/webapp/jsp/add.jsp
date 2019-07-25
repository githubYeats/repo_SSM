<%--
  Author: Feiyue
  Date: 2019/7/24 21:09
  Desc: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增账户</title>
</head>
<body>

<h1>保存账户信息表单</h1>
<form action="${pageContext.request.contextPath}/account/add" method="post">
    用户名称<input type="text" name="name"><br/>
    账户金额<input type="text" name="money"><br/>
    <input type="submit" value="提交"><br/>
</form>

</body>
</html>
