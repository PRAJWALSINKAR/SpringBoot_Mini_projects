package prajwal.in.service;

import prajwal.in.enity.User;

public interface UserService {
    boolean saveUser(User user); // for registration
    User login(String email, String pwd); // for login
}
