<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Edit Employee</title>
    <jsp:include page="../common/common-includes.jsp" />
</head>
<body>

<div class="container">
    <h2>Employee Form</h2>
    <form method="post" action="update" >
        <div class="form-group">
            <label>Name:</label>
            <input name="name" type="text" class="form-control" placeholder="Enter Name">
        </div>
        <div class="form-group">
            <label>Email:</label>
            <input name="email" type="email" class="form-control" placeholder="Enter email">
        </div>
        <button type="submit" class="btn btn-success">Save</button>
    </form>
</div>

</body>
</html>
