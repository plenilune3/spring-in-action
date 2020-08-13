package com.plenilune.practice.service;

import com.plenilune.practice.dao.UserRepository;
import com.plenilune.practice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user != null) {
            return user;
        }

        throw new UsernameNotFoundException(
                "User '" + username + "' not fount");
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User userRegistration(User user) {
        return userRepository.save(user);
    }
}
