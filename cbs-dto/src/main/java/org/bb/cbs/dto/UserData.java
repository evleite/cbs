package org.bb.cbs.dto;

import java.util.List;

/**
 * Created by newton on 4/3/17.
 */
public class UserData {

    private Integer userID;
    private String userName;
    private String password;
    private String confPassword;
    private List<RoleData> roles;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }

    public List<RoleData> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleData> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", confPassword='" + confPassword + '\'' +
                ", roles=" + roles +
                '}';
    }
}
