package com.ecommerce.service;

import com.ecommerce.dao.RoleDao;
import com.ecommerce.dao.UserDao;
import com.ecommerce.entity.Role;
import com.ecommerce.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user) {

        Role role = roleDao.findById("User").get();

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        user.setRole(roleSet);

        String password = getEncodedPassword(user.getUserPassword());
        user.setUserPassword(password);

        return userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

//    public User registerNewUser(User user){
//        Role role = roleDao.findById("User").get();
//
//        Set<Role> roles = new HashSet<>();
//        roles.add(role);
//        user.setRole(roles);
//
//        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
//        return userDao.save(user);
//    }

    public void initRoleAndUser() {
        // automatic set two roles: admin and user
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default new created user");
        roleDao.save(userRole);

        // save admin in the User table
        User adminUser = new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("123456"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        // create default new user in the User table
        User user = new User();
        user.setUserFirstName("meiwei");
        user.setUserLastName("Zhang");
        user.setUserName("meiwei123");
        user.setUserPassword(getEncodedPassword("123456"));
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }

}

//    public String getEncodedPassword(String password){
//        return passwordEncoder.encode(password);
//    }
//}
