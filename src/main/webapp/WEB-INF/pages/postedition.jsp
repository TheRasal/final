<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ext" uri="exitTag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Post ediotion</title>

</head>
<body class="bodyPostLogin">


<c:if test="${sessionScope.get('userDTO') eq null}">
    ${pageContext.forward("/")}
</c:if>



<span style="float: right">
    <a href="?lang=en">en</a>
    <a href="?lang=ru">ru</a>
    </span>

<%-- Exit from sessiom --%>
<spring:message code="exit.button" var="exitbuttonLabel"/>
<spring:message code="logged.as" var="loggedasLabel"/>

<div align="right" class="postEdition-div">
    <ext:exitTag userDTO="${userDTO.login}" loggedAs="${loggedasLabel}">
        <a href="/profile"> <b>${pfLabel}</b> </a> <a href="/exit"><b> ${exitbuttonLabel}</b> </a>
    </ext:exitTag>
</div>

<div align="center" class="postEdition-div">
    <form:form method="post" action="/postedit" enctype="multipart/form-data" modelAttribute="mes">

    <form:hidden path="postID"/>

        <spring:message code="write.any.words.here" var="wawhLabel"/>
        <p><form:textarea path="text" rows="6" cols="100" placeholder="${wawhLabel}"/></p>
        <form:input path="photo" type="file" name="photo" accept="image/*"/>

        <spring:message code="complete.button" var="completeLabel"/>
        <spring:message code="back.button" var="backLabel"/>
        <input type="submit" value="${completeLabel}" class="buttonPost">

    </form:form>
</div>

</body>
</html>
