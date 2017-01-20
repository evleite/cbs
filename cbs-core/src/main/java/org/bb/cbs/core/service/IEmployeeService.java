package org.bb.cbs.core.service;


import org.bb.cbs.dto.EmployeeData;

import java.util.List;
import java.util.Map;

/**
 * Created by newton on 1/7/17.
 */
public interface IEmployeeService {

    /**
     * Get a list of employees
     * @param param
     * @return List of EmployeeData
     * @throws Exception
     */
    List<EmployeeData> getEmployees(Map<String, Object> param) throws Exception;

    /**
     * Create or update an employee
     * @param employee
     * @throws Exception
     */
    void updateEmployee(EmployeeData employee) throws Exception;

    /**
     * Delete employee
     * @param params
     * @throws Exception
     */
    void deleteEmployee(Map<String, Object> params) throws Exception;

}
