<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <spring:message code="welcome" var="welcomeLabel"/>
    <title>${welcomeLabel}</title>
    <link href="<c:url value="/resources/css/styles.css"/>" type="text/css" rel="stylesheet">
</head>
<body class="bodyregister">

<c:if test="${sessionScope.get('userDTO') ne null}">
    ${pageContext.forward("/postloginpage")}
</c:if>


<span style="float: left">
    <a href="?lang=en"><font color="white">en</font></a>
    <a href="?lang=ru"><font color="white">ru</font></a>
    </span>

<br/><br/><br/><br/><br/>

<div class="registr-div" align="center">
    <h2> ${welcomeLabel}</h2>

</div>

<p></p>

<div class="registr-div" align="center">
    <c:if test="${formNotification!=''}">

        <font color="#dc143c"> ${formNotification} </font>

    </c:if>

    <p></p>

    <form:form method="POST" action="/registrationpage" commandName="userEntity">
        <table align="center" style="border-spacing: 10px;">

            <tr>
                <td>
                        <spring:message code="login" var="loginLabel"/>
                        <form:input path="login" placeholder="${loginLabel}" id="field"/>

                <td><font color=#dc143c><form:errors path="login"/></font></td>
            </tr>

            <tr>
                <td>
                        <spring:message code="email" var="emailLabel"/>
                        <form:input path="email" placeholder="${emailLabel}" id="field"/>

                <td><font color=#dc143c><form:errors path="email"/></font></td>
            </tr>

            <tr>
                <td>
                        <spring:message code="name" var="nameLabel"/>
                        <form:input path="name" placeholder="${nameLabel}" id="field"/>

                <td><font color="#dc143c"><form:errors path="name"/></font></td>
            </tr>

            <tr>
                <td>
                        <spring:message code="age" var="ageLabel"/>
                        <form:input path="age" placeholder="${ageLabel}" id="field"/>

                <td><font color=#dc143c><form:errors path="age"/></font></td>
            </tr>

            <tr>

            <tr>
                <td>
                        <spring:message code="password" var="passwordLabel"/>
                        <form:password path="password" placeholder="${passwordLabel}" id="field"/>

                <td><font color=#dc143c><form:errors path="password"/></font></td>
            </tr>
            <tr>
            </tr>
            <tr>
            </tr>
            <tr>
            </tr>
            <tr>
                <td colspan="2"  style="text-align: center;">
                    <spring:message code="complete.button" var="completeLabel"/>
                    <input class="buttonSignup" type="submit" value="${completeLabel}"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>

<p></p>

<div align="center" style="margin-top: 30px">
    <form action="/" method="get">
        <spring:message code="authorization" var="authoLabel"/>
        <input type="submit" class="buttonSignup" value="${authoLabel}"/>
    </form>
</div>

</body>
</html>
