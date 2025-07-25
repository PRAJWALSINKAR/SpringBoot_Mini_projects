package prajwal.in.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prajwal.in.enity.User;
import prajwal.in.repo.UserRepo;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean saveUser(User user) {
        Optional<User> existing = userRepo.findByEmail(user.getEmail());
        if (existing.isPresent()) {
            return false; // email already exists
        }
        userRepo.save(user);
        return true;
    }

    @Override
    public User login(String email, String pwd) {
        Optional<User> userOpt = userRepo.findByEmail(email);
        if (userOpt.isPresent() && userOpt.get().getPwd().equals(pwd)) {
            return userOpt.get();
        }
        return null;
    }
}
