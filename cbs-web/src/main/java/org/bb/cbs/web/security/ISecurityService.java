package org.bb.cbs.web.security;

import org.bb.cbs.dto.UserData;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by newton on 4/3/17.
 */
public interface ISecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);

    void save(UserData user);
}
