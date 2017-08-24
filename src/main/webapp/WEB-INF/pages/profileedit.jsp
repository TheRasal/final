<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ext" uri="exitTag" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <spring:message code="profile.edit.form" var="pefLabel"/>
    <title> ${pefLabel} </title>
    <link href="<c:url value="/resources/css/styles.css"/>" type="text/css" rel="stylesheet">
</head>

<body class="bodyProfile">

<span style="float: right">
    <a href="?lang=en"><font color="#fffc"> en </font></a>
    <a href="?lang=ru"><font color="#fffc"> ru</font></a>
    </span>

<br/><br/><br/><br/><br/>
<%-- Exit from sessiom --%>
<spring:message code="profile.form" var="pfLabel"/>
<spring:message code="logged.as" var="loggedasLabel"/>
<spring:message code="exit.button" var="exitLabel"/>

<a href="profile"> <b>${pfLabel}</b> </a>

<div align="right" class="profile-edit-div">
    <ext:exitTag userDTO="${userDTO.login}" loggedAs="${loggedasLabel}">
        <a href="profile"> <font color="#fffc"> <b>   ${pfLabel}   </b>   </font> </a>
        <a href="exit">   <font color="#fffc">  <b>   ${exitLabel}  </b>  </font> </a>
    </ext:exitTag>
</div>


<c:if test="${formNotification!=''}">
<font color="#dc143c"> ${formNotification}
    </c:if>
    <p></p>

    <div class="profile-edit-div">
        <form:form method="POST" action="/profileedit" commandName="profileedit">
            <h2> ${pefLabel} </h2>
            <table>

                <form:hidden path="profileID"/>

                <tr><spring:message code="firstname" var="firstnameLabel"/>
                    <td><form:input path="firstName" placeholder="${firstnameLabel}" size="30"/>

                    <td><form:errors path="firstName"/></td>
                </tr>

                <tr>
                    <td>
                            <spring:message code="lastname" var="lastnameLabel"/>
                            <form:input path="lastName" placeholder="${lastnameLabel}" size="30"/>

                    <td><form:errors path="lastName"/></td>
                </tr>

                <tr>
                    <td>
                            <form:input type="date" path="birthDate"/>

                </tr>

                <tr>
                    <td>
                            <spring:message code="email" var="emailLabel"/>
                            <form:input path="email" placeholder="${emailLabel}" size="30"/>

                    <td><form:errors path="email"/></td>
                </tr>

                <tr>
                    <td>
                            <spring:message code="age" var="ageLabel"/>
                            <form:input path="age" placeholder="${ageLabel}" size="30"/>

                    <td><form:errors path="age"/></td>
                </tr>

                <tr>
                    <td><spring:message code="sex" var="sexLabel"/>
                        <spring:message code="sex.male" var="maleLabel"/>
                        <spring:message code="sex.female" var="femaleLabel"/>
                            ${sexLabel} <form:radiobutton path="sex" value="${maleLabel}"/>${maleLabel}
                        <form:radiobutton path="sex" value="${femaleLabel}"/>${femaleLabel}
                    </td>
                </tr>

                <tr>
                    <td>
                            <spring:message code="city" var="cityLabel"/>
                            <form:input path="city" placeholder="${cityLabel}" size="30"/>

                    <td><form:errors path="city"/></td>
                </tr>

                <tr>
                    <td>
                            <spring:message code="phone" var="phoneLabel"/>
                            <form:input path="phoneNumber" placeholder="${phoneLabel}" size="30"/>

                    <td><form:errors path="phoneNumber"/></td>
                </tr>

                <tr  style="margin-top: 30px">
                    <td colspan="2">
                        <spring:message code="complete.button" var="completeLabel"/>
                        <spring:message code="back.button" var="backLabel"/>
                        <input type="submit" value="${completeLabel}" class="buttonSignup"/>
                    </td>
                </tr>
            </table>
        </form:form>

    </div>

</body>
</html>
