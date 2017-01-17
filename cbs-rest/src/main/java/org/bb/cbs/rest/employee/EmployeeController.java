package org.bb.cbs.rest.employee;

import org.apache.commons.collections.CollectionUtils;
import org.bb.cbs.core.service.IEmployeeService;
import org.bb.cbs.dto.EmployeeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
    public List<EmployeeData> getEmployees() {
        List<EmployeeData> employees = null;

        try {
            employees = this.employeeService.getEmployees();
        } catch (Exception e) {
            log.error("Error on retrieving employees", e);
        }

        if(CollectionUtils.isEmpty(employees)) {
            employees = Collections.EMPTY_LIST;
        }

        return employees;
    }

    @ResponseBody
    @RequestMapping(value = "/rest/employee", method = RequestMethod.POST)
    public EmployeeData updateEmployee(@RequestBody EmployeeData employee) {
        try {
            return this.employeeService.updateEmployee(employee);
        } catch (Exception e) {
            log.error("Error on updating employees", e);
        }
        return null;
    }

}
