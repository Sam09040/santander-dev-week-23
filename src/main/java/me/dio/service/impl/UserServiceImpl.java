package me.dio.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User createUser(User userToCreate) {
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId()) && userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber()) && userRepository.existsByCardNumber(userToCreate.getCard().getNumber())) {
            throw new IllegalArgumentException("This user already exists!");
        }
        return userRepository.save(userToCreate);
    }
    
}
