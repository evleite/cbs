package org.bb.cbs.core.service;

import org.bb.cbs.core.dao.EmployeeDAO;
import org.bb.cbs.dto.EmployeeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by newton on 1/7/17.
 */

@Service("employeeService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EmployeeService extends BaseService implements IEmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDAO employeeDAO;

    /**
     * Get a list of employees
     * @param param
     * @return List of EmployeeData
     * @throws Exception
     */
    @Override
    public List<EmployeeData> getEmployees(Map<String, Object> param) throws Exception {
        return this.employeeDAO.getEmployees(param);
    }

    /**
     * Create or update an employee
     *
     * @param employee
     * @return true on success, false on failure
     * @throws Exception
     */
    @Override
    public void updateEmployee(EmployeeData employee) throws Exception {

        if(employee == null) {
            throw new Exception("Employee cannot be null");
        }

        if(employee.getEmployeeID() == null || employee.getEmployeeID().intValue() == 0) {
            Random generator = new Random();
            int i = generator.nextInt(10);
            employee.setEmployeeID(i);
            this.employeeDAO.createEmployee(employee);
        } else {
            this.employeeDAO.updateEmployee(employee);
        }
    }

    /**
     * Delete employee
     *
     * @param params
     * @return true on success, false on failure
     * @throws Exception
     */
    @Override
    public void deleteEmployee(Map<String, Object> params) throws Exception {
        this.employeeDAO.deleteEmployee(params);
    }

}
