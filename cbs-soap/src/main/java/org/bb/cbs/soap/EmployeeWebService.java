package org.bb.cbs.soap;

import org.bb.cbs.core.service.IEmployeeService;
import org.bb.cbs.dto.EmployeeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by newton on 1/7/17.
 */

@Service("employeeWSService")
@WebService(serviceName = "employeeWebService")
public class EmployeeWebService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeWebService.class);

    @Autowired
    private IEmployeeService employeeService;

    @WebMethod(operationName = "listEmployees")
    public List<EmployeeData> getEmployeeList() {
        List<EmployeeData> employees = Collections.EMPTY_LIST;
        try {
            Map<String, Object> param = new HashMap();
            employees =  this.employeeService.getEmployees(param);
        } catch (Exception e) {
            log.error("Error on getting the list of employees", e);
        }
        return employees;
    }

    @WebMethod(operationName = "updateEmployee")
    public EmployeeData updateEmployee(@WebParam EmployeeData employee) {
        try {
            this.employeeService.updateEmployee(employee);
        } catch (Exception e) {
            log.error("Error on creating employee record", e);
        }
        return employee;
    }

}
