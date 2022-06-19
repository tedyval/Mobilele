package com.example.mobilele.service.serviceImpl;

import com.example.mobilele.model.entity.User;
import com.example.mobilele.model.entity.UserRole;
import com.example.mobilele.model.entity.emumaration.RoleEnum;
import com.example.mobilele.model.serviceModel.UserServiceModel;
import com.example.mobilele.repository.RoleRepository;
import com.example.mobilele.repository.UserRepository;
import com.example.mobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper,
                           RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public boolean registerUser(UserServiceModel userServiceModel) {
        Optional<User> userOptional = userRepository.findByUsername(userServiceModel.getUsername());
         if(!userOptional.isEmpty()){
           return false;
         }

         User user = modelMapper.map(userServiceModel,User.class);
         String passwordEncoded = passwordEncoder.encode(userServiceModel.getPassword());
         user.setPassword(passwordEncoded);
         user.setActive(true);
         UserRole role = roleRepository.findByName(RoleEnum.USER);
         user.setRoles(Set.of(role));
         userRepository.save(user);
         LOGGER.info("Role ist {}",user.getRoles());
        return true;

    }
}
