<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Employees</title>
    <jsp:include page="../common/common-includes.jsp" />
</head>
<body>

    <h1>Employees</h1>

    <a href="employee/add" class="btn btn-success" > Add New Employee </a>
    <table class="table table-bordered table-hover" >
        <thead>
            <tr>
                <th>Action</th>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="emp" items="${employees}">
                <tr>
                    <td>
                        <a href="#" class="btn btn-warning" > Edit </a>
                        <a href="#" class="btn btn-danger" > Delete </a>
                    </td>
                    <td>${emp.employeeID}</td>
                    <td>${emp.name}</td>
                    <td>${emp.email}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
