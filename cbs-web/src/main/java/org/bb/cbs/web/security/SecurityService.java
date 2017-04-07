package org.bb.cbs.web.security;

import org.bb.cbs.dto.RoleData;
import org.bb.cbs.dto.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by newton on 4/3/17.
 */
public class SecurityService implements ISecurityService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }
        return null;
    }

    @Override
    public void autologin(String username, String password) {

        UserDetails userDetails = this.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

    }

    @Override
    public void save(UserData user) {
        // TODO: save this user in database
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println(user.toString());
    }

    @Override
    public UserData findByUsername(String userName) {
        // TODO: get a user by userName from service
        UserData user = new UserData();
        user.setUserID(1);
        user.setUserName("newton@gmail.com");
        user.setPassword("123456");
        return user;
    }

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // TODO: Get the desired user info from rest service and populate the variables
        UserData user = new UserData();
        user.setUserID(1);
        user.setUserName("newton@gmail.com");
        user.setPassword("123456");

        RoleData role = new RoleData();
        role.setRoleID(1);
        role.setRoleName("admin");

        List<RoleData> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);


        // Populate authorities if you want to implement role based ACL
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if(!CollectionUtils.isEmpty(user.getRoles())) {
            for (RoleData assignedRole : user.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(assignedRole.getRoleName()));
            }
        }

        return new User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }

}
