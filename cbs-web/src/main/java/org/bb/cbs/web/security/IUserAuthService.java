package org.bb.cbs.web.security;

import org.bb.cbs.dto.UserData;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by newton on 4/8/17.
 */
public interface IUserAuthService extends UserDetailsService {

    void save(UserData user);

    UserData findByUsername(String userName);

}
