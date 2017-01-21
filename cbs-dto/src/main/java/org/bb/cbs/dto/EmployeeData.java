package org.bb.cbs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by newton on 1/17/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeData extends BaseData {

    private Integer employeeID;
    private String name;
    private String email;

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "EmployeeData{" +
                "employeeID=" + employeeID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
