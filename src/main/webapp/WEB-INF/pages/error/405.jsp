<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZheynovVV
  Date: 15.09.2016
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>405 Error page</title>
    <link href="<c:url value="/resources/css/styles.css"/>" type="text/css" rel="stylesheet">
</head>

<body class="bodyException">

<div class="error-div">
    <font size="6" style="font-family: sans-serif" > 405 Error page...</font> <br/><br/><br/>
    <button style="margin-left: 38%" type="button" name="back" class="buttonAuth" onclick="history.back()">back</button>
</div>

</body>
</html>
