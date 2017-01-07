package org.bb.cbs.core.dao;

import org.bb.cbs.core.vo.EmployeeData;

import java.util.List;

/**
 * Created by newton on 1/7/17.
 */
public interface IEmployeeDAO {

    /**
     * Get a list of employees
     * @return list of EmployeeData
     * @throws Exception
     */
    List<EmployeeData> getEmployees() throws Exception;

}
