package dev.senaleevisal.library.service.IMPL;

import dev.senaleevisal.library.dao.User;
import dev.senaleevisal.library.dto.UserEntity;
import dev.senaleevisal.library.repository.UserRepository;
import dev.senaleevisal.library.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modalMapper;

    @Autowired
    public UserServiceIMPL(UserRepository userRepository, ModelMapper modalMapper) {
        this.userRepository = userRepository;
        this.modalMapper = modalMapper;
    }

    @Override
    public boolean RegisterUser(User user) {
        UserEntity userEntity = modalMapper.map(user, UserEntity.class);
        return userRepository.save(userEntity) == userEntity;
    }

    @Override
    public int loginUser(String userEmail, String userPassword) {
        if (userRepository.existsByEmail(userEmail) &&
                userRepository.findByEmail(userEmail).getPassword().equals(userPassword)) {

            return userRepository.findByEmail(userEmail).getId();
        }
        return -1;
    }

    @Override
    public User getUser(int id) {
        return modalMapper.map(userRepository.findById(String.valueOf(id)).get(), User.class);
    }
}