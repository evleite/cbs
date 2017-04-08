package org.bb.cbs.web.services;

import org.bb.cbs.dto.EmployeeData;
import org.bb.cbs.restclient.EmployeeRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by newton on 1/4/17.
 */
@RestController
public class EmployeeRestController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeRestController.class);

    @ResponseBody
    @RequestMapping(value = "/rest/employee", method = RequestMethod.GET)
    public List<EmployeeData> getEmployees(@RequestParam(name="employeeID", required = false) Integer employeeID, @RequestParam(name="empName", required = false) String empName) {
        return EmployeeRestClient.getEmployees(employeeID, empName);
    }

    @ResponseBody
    @RequestMapping(value = "/rest/employee", method = RequestMethod.POST)
    public EmployeeData updateEmployee(@RequestBody EmployeeData employee) {
        return EmployeeRestClient.updateEmployee(employee);
    }

    @ResponseBody
    @RequestMapping(value = "/rest/employee/{employeeID}", method = RequestMethod.DELETE)
    public int deleteEmployees(@PathVariable("employeeID") Integer employeeID) {
        EmployeeRestClient.deleteEmployee(employeeID);
        return 1;
    }

}
