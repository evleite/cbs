/**
 * Created by newton on 1/21/17.
 */

var empService = {

    getEmployees: function(employeeID, empName) {
        var param = {"employeeID": employeeID, "empName": empName};
        return $.ajax({url: "rest/employee", data: param, method: "GET", cache: true, dataType: "json"});
    },

    updateEmployee: function(employee) {
        return $.ajax({url: "rest/employee", data: employee, method: "POST", cache: true, dataType: "json", contentType: "application/json"});
    },

    deleteEmployee: function(employeeID) {
        var url = "rest/employee/" + employeeID;
        return $.ajax({url: url, data: {}, method: "DELETE", cache: true});
    }

};