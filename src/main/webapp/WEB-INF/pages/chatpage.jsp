
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="/WEB-INF/taglib/exittag.tld" prefix="ext" %>
<%@ taglib uri="/WEB-INF/taglib/postimagetag.tld" prefix="pit" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INSTWITT</title>
    <link href="<c:url value="/resources/css/styles.css"/>" type="text/css" rel="stylesheet">
</head>

<body class="bodyPostLogin">

<span style="float: left">
    <a href="?lang=en"><font color="white">en</font></a>
    <a href="?lang=ru"><font color="white">ru</font></a>
    </span>

<%-- Exit from sessiom --%>
<spring:message code="exit.button" var="exitbuttonLabel"/>
<spring:message code="logged.as" var="loggedasLabel"/>
<%--<spring:message code="profile.form" var="pfLabel"/>--%>
<spring:message code="own.posts" var="mypostslabel"/>
<spring:message code="all.posts" var="allstslabel"/>


<div align="right" class="postlogin-div">
    <ext:exitTag userDTO="${userDTO.login}" loggedAs="${loggedasLabel}">
        <c:if test="${ownpage == 0}">
            <a href="/mymessages"> <font color="#7fff00"> <b>${mypostslabel}</b> </font> </a>
        </c:if>
        <c:if test="${ownpage == 1}">
            <a href="/allmessages"> <font color="#7fff00"><b> ${allstslabel}</b> </font></a>
        </c:if>
        <a href="/exit"><b> ${exitbuttonLabel}</b> </a>
    </ext:exitTag>
</div>

<h1 align="center"> I N S T W I T T </h1>




<div align="center" class="postlogin-div">
    <form:form action="/makepost" method="post" commandName="newMessage" enctype="multipart/form-data">

        <spring:message code="write.any.words.here" var="wawhLabel"/>
        <p><form:textarea path="text" rows="6" cols="100" name="text" placeholder="${wawhLabel}"/></p>
        <form:input path="image" type="file" name="image" accept="image/*" data-buttonText="Your label here"/>
        <spring:message code="make.post" var="mpostLabel"/>
        <spring:message code="back.button" var="backLabel"/>

        <input type="submit" value="${mpostLabel}" class="buttonPost">
    </form:form>
</div>

<br/><br/>

<c:forEach items="${messageService.getAllMessage()}" var="messages">

    <spring:message code="posted.by" var="postedbyLabel"/>
    <spring:message code="post.time" var="posttimeLabel"/>

    <c:if test="${ownpage == 0}">

        <div align="center" class="postlogin-div"><font color="white">
                <%--tag postImageTag shows image using Base64 encoding --%>
            <a id="${messages.messageID}"></a>

            <c:if test="${messages.image ne null}">
                <img src="<pit:postImageTag imageByte="${messages.image}"/>" height="300">
            </c:if>

            <p><b> ${messages.text} </b>

            <p>    ${postedbyLabel} <b>
                    ${messages.userID.login}</b>,
                    ${posttimeLabel}:
                <b>    ${messages.postDate} </b></font>

            <c:if test="${messages.userID.getLogin()==userDTO.login}">
                <spring:message code="edit.post" var="edityLabel"/>
                <a href="/message/${messages.messageID}"> ${edityLabel} </a>
                <spring:message code="delete.post" var="deleteLabel"/>
                <a href="/delete/${messages.messageID}"> ${deleteLabel} </a>
            </c:if>
        </div>
    </c:if>

    <c:if test="${ownpage == 1}">

        <c:if test="${messages.userID.getLogin()==userDTO.login}">
            <div  align="center" class="messagelogin-div"><font color="white">
                <a id="${messages.messageID}"></a>
                <img src="<pit:postImageTag imageByte="${messages.image}"/>" height="300">
                <p><b> ${messages.text} </b> </p>
                <p>    ${postedbyLabel} <b> ${messages.userID.login} </b>, ${posttimeLabel}:
                    <b>    ${messages.postDate} </b></font>
                <spring:message code="edit.post" var="edityLabel"/>
                <spring:message code="delete.post" var="deleteLabel"/>
                <a href="/delete/${messages.messageID}"> ${deleteLabel} </a>
            </div>
        </c:if>
    </c:if>


</c:forEach>


</body>
</html>
