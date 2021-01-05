package com.quizApp.service.impl;

import com.quizApp.domain.*;
import com.quizApp.domain.security.PasswordResetToken;
import com.quizApp.domain.security.Role;
import com.quizApp.domain.security.UserRole;

import com.quizApp.model.AssignRoles;
import com.quizApp.repository.*;
import com.quizApp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by shaik on 12/21/16.
 */

@Service
public class UserServiceImpl implements UserService {

    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private RoleRepository roleRepository;



    @Autowired
    UserRoleRepository userRoleRepository;

    @Transactional
    public User createUser(User user, Set<UserRole> userRoles) {
        User localUser = userRepository.findByUsername(user.getUsername());

        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        } else {


            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);

         //   user.setShoppingCart(shoppingCart);

           // user.setUserShippingList(new ArrayList<UserShipping>());
         //   user.setUserPaymentList(new ArrayList<UserPayment>());

            localUser = userRepository.save(user);
        }

        return localUser;
    }

    public User save(User user){
        return userRepository.save(user);
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public PasswordResetToken getPasswordResetToken(final String token) {
        return passwordResetTokenRepository.findByToken(token);
    }

    @Override
    public void createPasswordResetTokenForUser(final User user, final String token) {
        final PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordResetTokenRepository.save(myToken);
    }










    @Override
    public List<User> getUserList() {
       return  userRepository.findAll();
    }

    @Override
    public Set<UserRole> getUserRole(Long id) {
        User user = userRepository.getUserById(id);
        LOG.info(" User Roles "+user.getUserRoles());
        return user.getUserRoles();
    }

    @Override

    public void assignRoles(AssignRoles assignRoles) {


        Role role =null;

        /** Delete Existing Role **/
        userRoleRepository.deleteRoleByUserId(assignRoles.getUserId());

        for(Integer roleId : assignRoles.getRoles()){
            UserRole userRole = new UserRole();
            User user = new User();
            user.setId(assignRoles.getUserId());
            userRole.setUser(user);
            role = new Role();
            role.setRoleId(roleId);
            userRole.setRole(role);
            userRoleRepository.save(userRole);

        }



    }

    @Override
    public boolean getOnlineUser(Long userId) {
        String online=null;

        boolean onlineStatus =false;
       String status = userRepository.getOnlineUserById(userId);



        if(status!=null && status.equalsIgnoreCase("Login Event")){
            onlineStatus = true;
        }
return onlineStatus;

    }

}
