package org.bb.cbs.core.vo;

/**
 * Created by newton on 1/7/17.
 */
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