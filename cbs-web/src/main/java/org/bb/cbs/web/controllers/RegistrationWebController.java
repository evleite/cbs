package org.bb.cbs.web.controllers;

import org.bb.cbs.dto.UserData;
import org.bb.cbs.web.security.ISecurityService;
import org.bb.cbs.web.security.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by newton on 4/3/17.
 */
@Controller
public class RegistrationWebController {

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new UserData());
        return "registration/new";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserData userForm, BindingResult bindingResult, Model model) {
        // userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration/new";
        }

        this.securityService.save(userForm);

        this.securityService.autologin(userForm.getUserName(), userForm.getConfPassword());

        return "redirect:/employee";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "registration/login";
    }

    @RequestMapping(value = "/app/test", method = RequestMethod.GET)
    public String test(Model model, String error, String logout) {

        return "test";
    }

}
