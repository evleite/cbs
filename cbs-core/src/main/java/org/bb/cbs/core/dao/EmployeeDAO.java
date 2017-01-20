package org.bb.cbs.core.dao;


import org.bb.cbs.dto.EmployeeData;

import java.util.List;
import java.util.Map;

/**
 * Created by newton on 1/7/17.
 */
public interface EmployeeDAO {

    /**
     * Create new employee
     * @param employee
     * @throws Exception
     */
    void createEmployee(EmployeeData employee) throws Exception;

    /**
     * Update a employee
     * @param employee
     * @throws Exception
     */
    void updateEmployee(EmployeeData employee) throws Exception;

    /**
     * Delete a patient by EmployeeID
     * @param param
     * @throws Exception
     */
    void deleteEmployee(Map<String, Object> param) throws Exception;

    /**
     * Get a list of employees applying optional filters
     * @param param
     * @return List of EmployeeData
     * @throws Exception
     */
    List<EmployeeData> getEmployees(Map<String, Object> param) throws Exception;

}
