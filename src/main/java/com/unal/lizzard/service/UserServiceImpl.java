package com.unal.lizzard.service;
import com.unal.lizzard.model.Role;
import com.unal.lizzard.model.User;
import com.unal.lizzard.repository.UserRepository;
import com.unal.lizzard.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository=userRepository;
    }
    @Override
    public User save(UserRegistrationDto registrationdto) {
        User user = new User(registrationdto.getFirstName(),
                registrationdto.getLastName(), registrationdto.getEmail(),
                registrationdto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
}
