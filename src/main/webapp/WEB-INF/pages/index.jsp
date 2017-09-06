<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>

</head>


<body class="bodyindex">

<c:if test="${sessionScope.get('userDTO') ne null}">
    ${pageContext.forward("/postloginpage")}
</c:if>

<span style="float: left">
    <a href="?lang=en"><font color="black">en</font></a>
    <a href="?lang=ru"><font color="black">ru</font></a>
    </span>

<h3 align="center">
    <c:if test="${formNotification!=''}">
        <b>${formNotification} </b>
    </c:if>
</h3>

<p></p>

<div align="center" class="index-div">
<spring:message code="authorization" var="authorizationLabel"/>
<p><font class="index-fontB" size="5"> ${authorizationLabel}</font></p>

<form:form method="POST" action="login" commandName="userDTO">
    <table align="center" style="border-spacing: 15px;">
        <tr>
            <td>
                    <spring:message code="login" var="loginLabel"/>
                    <form:input path="login" placeholder="${loginLabel}" id="field" />
            <td><font color="#dc143c"><form:errors path="login"/></font></td>
        </tr>

        <tr>
            <td>
                    <spring:message code="password" var="passwordLabel"/>
                    <form:password path="password" placeholder="${passwordLabel}" id="field"/>

            <td><font color=#dc143c><form:errors path="password"/></font></td>
        </tr>

        <td align="center">
            <spring:message code="login.button" var="loginbuttonLabel"/>
            <input type="submit" class="buttonLogin" value="${loginbuttonLabel}"/>
        </td>

    </table>
</form:form>

</div>

<p></p>

<div style="margin-left: 39.6%;">
    <form action="registrationpage" method="get">
        <spring:message code="signup.button" var="signupLabel"/>
        <input type="submit" class="buttonAuth" value="${signupLabel}"/>
    </form>
</div>

</body>
</html>
