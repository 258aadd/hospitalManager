<%--
  Created by IntelliJ IDEA.
  User: 23163
  Date: 2024/7/10
  Time: 下午8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/uploadFile" method="post" enctype="multipart/form-data">
        <input type="file" name="myfile">
        <input type="submit">
    </form>
</body>
</html>
