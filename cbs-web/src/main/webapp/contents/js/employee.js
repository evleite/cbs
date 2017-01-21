/**
 * Created by newton on 1/21/17.
 */

var emp = {

    init: function() {

        $("#employeeForm").dialog({modal: true, autoOpen: false, height: 400, width:600,
            buttons: [
                {text: "Update", click: function() { emp.updateEmployee(); }},
                {text: "Cancel", click: function() { emp.closeForm(); }}
            ]
        });

        $(document).on("click", "#btnAddNew", function(event) {
            emp.handleAddNewEvent(event);
            return false;
        });

        $(document).on("click", ".btnEdit", function(event) {
            emp.handleEditEvent(event);
            return false;
        });

        $(document).on("click", ".btnDelete", function(event) {
            emp.handleDeleteEvent(event);
            return false;
        });

        emp.populateEmployees();

    },

    handleAddNewEvent: function(event) {
        event.preventDefault();
        var formData = {};
        formData.employeeID = "";
        formData.name = "";
        formData.email = "";
        emp.setFormData(formData);
        $("#employeeForm").dialog("open");
        return false;
    },

    handleEditEvent: function(event) {
        event.preventDefault();
        var employeeID = $(event.currentTarget).attr("employeeID");
        empService.getEmployees(employeeID, '').done(function(employees, textStatus, jqXHR){
            if(employees) {
                emp.setFormData(employees[0]);
                $("#employeeForm").dialog("open");
            }
        });
        return false;
    },

    handleDeleteEvent: function(event) {
        event.preventDefault();
        var employeeID = $(event.currentTarget).attr("employeeID");
        empService.deleteEmployee(employeeID).done(function(response, textStatus, jqXHR) {
            emp.populateEmployees();
        });
        return false;
    },

    populateEmployees: function() {
        empService.getEmployees("", "").done(function(employees, textStatus, jqXHR){
            $("#tbdEmployee").empty();
            if(employees) {
                $.each(employees, function(i, employee) {
                    var row = "<tr>";
                    row += "<td><a href='#' class='btn btn-warning btnEdit' employeeID='" + employee.employeeID + "' > Edit </a><a href='#' class='btn btn-danger btnDelete' employeeID='" + employee.employeeID + "' > Delete </a></td>";
                    row += "<td>" + employee.employeeID + "</td>";
                    row += "<td>" + employee.name + "</td>";
                    row += "<td>" + employee.email + "</td>";
                    row += "</tr>";
                    $("#tbdEmployee").append(row);
                });
            }
        });
    },

    getFormData: function() {
        var formData = {};
        formData.employeeID = $("#txtEmpID").val();
        formData.name = $("#txtEmpName").val();
        formData.email = $("#txtEmpEmail").val();
        return formData;
    },

    setFormData: function(formData) {
        $("#txtEmpID").val(formData.employeeID);
        $("#txtEmpName").val(formData.name);
        $("#txtEmpEmail").val(formData.email);
    },

    updateEmployee: function() {
        empService.updateEmployee(JSON.stringify(emp.getFormData())).done(function(employee, textStatus, jqXHR){
            emp.populateEmployees();
            emp.closeForm();
        });
    },

    closeForm: function() {
        $("#employeeForm").dialog("close");
    }

};

$(document).ready(function() {
    emp.init();
});