<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ext" uri="exitTag" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile page</title>
    <link href="<c:url value="/resources/css/styles.css"/>" type="text/css" rel="stylesheet">
</head>

<body class="bodyProfile">

<span style="float: right">
    <a href="?lang=en"><font color="#fffc"> en </font></a>
    <a href="?lang=ru"><font color="#fffc"> ru</font></a>
    </span>

<br/><br/><br/><br/><br/><br/>
<%-- Exit from sessiom --%>
<spring:message code="exit.button" var="exitbuttonLabel"/>
<spring:message code="logged.as" var="loggedasLabel"/>

<div align="right" class="profile-div">
    <ext:exitTag userDTO="${userDTO.login}" loggedAs="${loggedasLabel}"> <a href="/exit"><b> <font color="#fffc"> ${exitbuttonLabel} </font></b> </a>
    </ext:exitTag>
</div>

<div class="profile-div">
    <spring:message code="profile.form" var="profileformLabel"/>
    <h2> ${profileformLabel} </h2>

    <spring:message code="firstname" var="firstnameLabel"/>
    <spring:message code="lastname" var="lastnameLabel"/>
    <spring:message code="email" var="emailLabel"/>
    <spring:message code="birthdate" var="birthdateLabel"/>
    <spring:message code="age" var="ageLabel"/>
    <spring:message code="sex" var="sexLabel"/>
    <spring:message code="city" var="cityLabel"/>
    <spring:message code="phone" var="phoneLabel"/>

    <p><font color="white">
        <b> ${firstnameLabel}:</b> ${profile.firstName} <br/>
        <b> ${lastnameLabel}:</b> ${profile.lastName}<br/>
        <b> ${emailLabel}:</b> ${profile.email}<br/>
        <b> ${birthdateLabel}:</b> ${profile.birthDate}<br/>
        <b> ${ageLabel}:
        <c:if test="${profile.age gt 0}">
        </b> ${profile.age}
        </c:if> <br/>
        <b> ${sexLabel}:</b> ${profile.sex}<br/>
        <b> ${cityLabel}:</b> ${profile.city}<br/>
        <b> ${phoneLabel}:</b> ${profile.phoneNumber}<br/>
    </font>
    </p>

    <form action="/profileedit" method="get">
        <spring:message code="back.button" var="backLabel"/>
        <spring:message code="profile.edit" var="profileeditLabel"/>
        <input type="submit" value="${profileeditLabel}" class="buttonSignup"/>
    </form>
</div>


<div style="margin-left: 71.5%;" >
    <form action="/postloginpage" method="get">
        <spring:message code="main.page" var="mainpageLabel"/>
        <input type="submit" value="${mainpageLabel}" class="buttonMainPage"/>
    </form>
</div>

</body>
</html>
