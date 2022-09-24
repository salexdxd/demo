package test.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.demo.model.User;
import test.demo.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        return userRepository.save(newUser);
    }
}
