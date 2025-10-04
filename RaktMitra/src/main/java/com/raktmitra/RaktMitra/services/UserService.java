package com.raktmitra.RaktMitra.services;

import com.raktmitra.RaktMitra.entity.User;

public interface UserService {
    public User registerUser(User user);

    User findByEmail(String email);
}
