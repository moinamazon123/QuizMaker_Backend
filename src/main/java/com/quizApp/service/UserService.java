package com.quizApp.service;

import com.quizApp.domain.security.PasswordResetToken;
import com.quizApp.domain.security.UserRole;
import com.quizApp.domain.User;

import com.quizApp.model.AssignRoles;

import java.util.List;
import java.util.Set;

/**
 * Created by shaik on 12/21/16.
 */
public interface UserService {
    User createUser (User user, Set<UserRole> userRoles);

    User save (User user);

    public User findOne(Long id);

    User findByUsername (String username);

    User findByEmail(String email);

    PasswordResetToken getPasswordResetToken(final String token);

    void createPasswordResetTokenForUser(final User user, final String token);




    List<User> getUserList();

    Set<UserRole> getUserRole(Long id);

    void assignRoles(AssignRoles assignRoles);

    boolean getOnlineUser(Long userId);
}
