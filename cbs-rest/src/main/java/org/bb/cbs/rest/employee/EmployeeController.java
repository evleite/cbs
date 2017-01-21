package org.bb.cbs.rest.employee;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bb.cbs.core.service.IEmployeeService;
import org.bb.cbs.dto.EmployeeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by newton on 1/17/17.
 */

@RestController
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private IEmployeeService employeeService;

    @ResponseBody
    @RequestMapping(value = "/rest/employee", method = RequestMethod.GET)
    public List<EmployeeData> getEmployees(@RequestParam(name="employeeID", required = false) Integer employeeID, @RequestParam(name="empName", required = false) String empName) {
        List<EmployeeData> employees = null;

        // Map the request parameters
        Map<String, Object> param = new HashMap();
        if(employeeID != null) {
            param.put("employeeID", employeeID);
        }
        if(StringUtils.isNotBlank(empName)) {
            param.put("name", empName);
        }

        // Try fetching employees
        try {
            employees = this.employeeService.getEmployees(param);
        } catch (Exception e) {
            log.error("Error on retrieving employees", e);
        }

        // Return empty list in case of null
        if(CollectionUtils.isEmpty(employees)) {
            employees = Collections.EMPTY_LIST;
        }

        return employees;
    }

    @ResponseBody
    @RequestMapping(value = "/rest/employee", method = RequestMethod.POST)
    public EmployeeData updateEmployee(@RequestBody EmployeeData employee) {
        try {
            this.employeeService.updateEmployee(employee);
        } catch (Exception e) {
            log.error("Error on updating employees", e);
        }
        return employee;
    }

    @ResponseBody
    @RequestMapping(value = "/rest/employee/{employeeID}", method = RequestMethod.DELETE)
    public int deleteEmployees(@PathVariable("employeeID") Integer employeeID) {
        int flag = 0;

        // Map the request parameters
        Map<String, Object> param = new HashMap();
        param.put("employeeID", employeeID);
        try {
            this.employeeService.deleteEmployee(param);
            flag = 1;
        } catch (Exception e) {
            log.error("Error on deleting employee", e);
        }

        return flag;
    }

}
