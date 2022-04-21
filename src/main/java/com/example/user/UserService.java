package com.example.user;

import com.example.user.dto.UserDTO;

import javax.inject.Singleton;
import java.util.HashSet;
import java.util.Set;

@Singleton
public class UserService {
    private Set<UserDTO> users = new HashSet<UserDTO>();

    public boolean Add(UserDTO user) {
        this.users.add(user);
        return true;
    }

    public Set<UserDTO> GetAll(){
        return users;
    }
}
