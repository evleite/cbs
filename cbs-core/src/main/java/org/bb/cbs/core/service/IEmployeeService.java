package org.bb.cbs.core.service;

import org.bb.cbs.core.vo.EmployeeData;

import java.util.List;

/**
 * Created by newton on 1/7/17.
 */
public interface IEmployeeService {

    /**
     * Get a list of employees
     * @return list of EmployeeData
     * @throws Exception
     */
    List<EmployeeData> getEmployees() throws Exception;

    /**
     * Create or update an employee
     * @param employee
     * @return true on success, false on failure
     * @throws Exception
     */
    EmployeeData updateEmployee(EmployeeData employee) throws Exception;
}
