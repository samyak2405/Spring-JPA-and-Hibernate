package com.samyak.service;

import com.samyak.entity.User;
import com.samyak.entity.UserProfile;
import com.samyak.repository.UserProfileRepository;
import com.samyak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public User createUser(User user,UserProfile userProfile){
        user.setUserProfile(userProfile);
        userProfile.setUser(user);
        userRepository.save(user);
        return user;
    }

    public Optional<User> getUserById(Long userId){
        return userRepository.findById(userId);
    }

    public UserProfile updateUserProfile(Long userId,UserProfile newProfile){
        User user = userRepository.findById(userId).orElse(null);
        if(user!=null){
            UserProfile userProfile = user.getUserProfile();
            userProfile.setFullName(newProfile.getFullName());
            userProfileRepository.save(userProfile);
            return userProfile;
        }
        return null;
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }
}
