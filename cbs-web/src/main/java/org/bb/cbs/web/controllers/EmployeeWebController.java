package org.bb.cbs.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.bb.cbs.soap.EmployeeData;
import org.bb.cbs.soap.ListEmployeesResponse;
import org.bb.cbs.web.soapclient.SoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by newton on 1/4/17.
 */

@Controller
public class EmployeeWebController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeWebController.class);

    @Autowired
    private SoapClient soapClient;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getEmployees(ModelMap model) {
        ListEmployeesResponse response = this.soapClient.getEmployees();
        model.put("employees", response.getReturn());
        return "employee/list";
    }

    @RequestMapping(value = "/employee/add", method = RequestMethod.GET)
    public String getNewEmployeeForm(ModelMap model) {
        EmployeeData employee = new EmployeeData();
        model.put("employee", employee);
        return "employee/edit";
    }

    @RequestMapping(value = "/employee/update", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute("employee")EmployeeData employee, ModelMap model) {
        String returnPath = "employee/edit";
        try {
            employee = this.soapClient.updateEmployee(employee);
            model.put("employee", employee);
            returnPath = "redirect:/employee";
        } catch (Exception e) {
            log.error("Error on updating employee", e);
        }
        return returnPath;
    }

}
