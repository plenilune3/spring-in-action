package com.plenilune.tacosecurity;

import com.plenilune.tacodata.UserService;
import com.plenilune.tacodomain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public UserRepositoryUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user != null) {
            return user;
        }

        throw new UsernameNotFoundException(
                "User '" + username + "' not found."
        );
    }
}
