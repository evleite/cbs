<%--
  Created by IntelliJ IDEA.
  User: newton
  Date: 4/3/17
  Time: 6:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Log-In</title>
    <jsp:include page="../common/common-includes.jsp" />
</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="userName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="userName" class="form-control" placeholder="Username" autofocus="true"></form:input>
                <form:errors path="userName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="confPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="confPassword" class="form-control" placeholder="Confirm your password"></form:input>
                <form:errors path="confPassword"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>

</body>
</html>
