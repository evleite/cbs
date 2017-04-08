package org.bb.cbs.web.security;

import org.bb.cbs.dto.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by newton on 4/3/17.
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private IUserAuthService userAuthService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserData.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        UserData user = (UserData) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
        if (user.getUserName().length() < 6 || user.getUserName().length() > 32) {
            errors.rejectValue("userName", "Size.userForm.username");
        }
        if (this.userAuthService.findByUsername(user.getUserName()) != null) {
            errors.rejectValue("userName", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getConfPassword().equals(user.getPassword())) {
            errors.rejectValue("confPassword", "Diff.userForm.passwordConfirm");
        }

    }

}
