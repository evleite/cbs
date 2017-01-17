package org.bb.cbs.core.service;

import org.bb.cbs.dto.EmployeeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by newton on 1/7/17.
 */

@Service("employeeService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EmployeeService extends BaseService implements IEmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    /**
     * Get a list of employees
     *
     * @return list of EmployeeData
     * @throws Exception
     */
    @Override
    public List<EmployeeData> getEmployees() throws Exception {
        List<EmployeeData> employees = new ArrayList<>();

        for (int i=0; i<5; i++) {
            EmployeeData emp = new EmployeeData();
            emp.setEmployeeID(i+1);
            emp.setName("Name" + i);
            emp.setEmail("eamail" + i + "@gmail.com");
            employees.add(emp);
        }

        return employees;
    }

    /**
     * Create or update an employee
     *
     * @param employee
     * @return true on success, false on failure
     * @throws Exception
     */
    @Override
    public EmployeeData updateEmployee(EmployeeData employee) throws Exception {
        System.out.print(employee.toString());
        return employee;
    }

    /**
     * Delete employee
     *
     * @param params
     * @return true on success, false on failure
     * @throws Exception
     */
    @Override
    public boolean deleteEmployee(Map<String, Object> params) throws Exception {
        System.out.print(params);
        return true;
    }

}
