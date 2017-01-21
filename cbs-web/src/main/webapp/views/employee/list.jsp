<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>

<html>
<head>
    <title>Employees</title>
    <jsp:include page="../common/common-includes.jsp" />
    <script type="text/javascript" src="<spring:url value='/contents/js/service/employeeService.js'/>"></script>
    <script type="text/javascript" src="<spring:url value='/contents/js/employee.js'/>"></script>
</head>
<body>

    <h1>Employees</h1>

    <a href="#" id="btnAddNew" class="btn btn-success" > Add New Employee </a>
    <table class="table table-bordered table-hover" >
        <thead>
            <tr>
                <th>Action</th>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody id="tbdEmployee">
        </tbody>
    </table>

    <div id="employeeForm" title="Employee Details">
        <div class="row" >
            <div class="col-sm-12">
                <div class="form-group">
                    <label>Employee ID</label>
                    <input type="text" id="txtEmpID" class="form-control" placeholder="Employee ID" />
                </div>
            </div>
        </div>
        <br />
        <div class="row" >
            <div class="col-sm-12">
                <div class="form-group">
                    <label>Employee Name</label>
                    <input type="text" id="txtEmpName" class="form-control" placeholder="Employee Name" />
                </div>
            </div>
        </div>
        <br />
        <div class="row" >
            <div class="col-sm-12">
                <div class="form-group">
                    <label>Employee Email</label>
                    <input type="text" id="txtEmpEmail" class="form-control" placeholder="Employee Email" />
                </div>
            </div>
        </div>
    </div>

</body>
</html>
