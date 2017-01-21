package org.bb.cbs.web.controllers;

import org.bb.cbs.dto.EmployeeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getEmployees(ModelMap model) {
        return "employee/list";
    }

}
