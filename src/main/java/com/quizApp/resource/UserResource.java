package com.quizApp.resource;

import com.quizApp.config.SecurityUtility;
import com.quizApp.domain.Department;
import com.quizApp.domain.Question;
import com.quizApp.domain.Quiz;
import com.quizApp.domain.User;
import com.quizApp.domain.security.PasswordResetToken;
import com.quizApp.domain.security.Role;
import com.quizApp.domain.security.UserRole;
import com.quizApp.model.AssignRoles;
import com.quizApp.model.PassChange;
import com.quizApp.model.UserInfo;
import com.quizApp.repository.RoleRepository;
import com.quizApp.service.UserService;
import com.quizApp.service.impl.UserSecurityService;
import com.quizApp.utility.FileUploadUtil;
import com.quizApp.utility.MailConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by shaik on 3/4/17.
 */

@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSecurityService userSecurityService;

    @Autowired
    private MailConstructor mailConstructor;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping(value = "/checkEmail/{email}", method = RequestMethod.GET)
    public ResponseEntity checkEmail(HttpServletRequest request,
                                  @PathVariable("email") String email){
        String msg = null;
        if (userService.findByEmail(email) != null) {

          msg = "emailExists";
        }

        return new ResponseEntity(msg, HttpStatus.OK);
    }

    @RequestMapping(value = "/add/profileimage/{userId}", method = RequestMethod.POST)
    public String upload(
            @RequestParam("picture") MultipartFile multipartFile1,@PathVariable("userId") Long userId,
            HttpServletResponse response, HttpServletRequest request
    ) throws IOException {
        //String blobExtension = StringUtils.cleanPath(multipartFile1.getOriginalFilename().split(".")[1]);

        String blobExtension = "png";//multipartFile1.getOriginalFilename().split("\\.")[1];


        String uploadDir = "uploads/profiles" +"/";

        FileUploadUtil.saveFile(uploadDir, userId+"."+blobExtension, multipartFile1);

        return "Upload Success";

    }

    @GetMapping(path = "/getProfileImage/{userId}")
    public FileSystemResource getProfileImage(@PathVariable("userId") Long userId) {

        return new FileSystemResource("uploads/profiles/"+userId+".png");
    }

    @RequestMapping(value = "/checkUserName/{username}", method = RequestMethod.GET)
    public ResponseEntity checkUsername(HttpServletRequest request,
                                  @PathVariable("username") String username){
        String msg = null;
        if (userService.findByUsername(username) != null) {

            msg = "usernameExists";
        }

        return new ResponseEntity(msg, HttpStatus.OK);
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public ResponseEntity newUser(HttpServletRequest request,
                                  @RequestBody HashMap<String, String> mapper,
                          Model model
    ) throws Exception {
        String username = mapper.get("username");
        String userEmail = mapper.get("email");
        String password = mapper.get("password");
        String city = mapper.get("city");
        String address = mapper.get("address");
        String phone = mapper.get("phone");
        String country = mapper.get("country");
        String state = mapper.get("state");

//        check username exists
        if (userService.findByUsername(username) != null) {
            model.addAttribute("usernameExists", true);

            return new ResponseEntity("usernameExists", HttpStatus.OK);
        }

//        check email address exists
        if (userService.findByEmail(userEmail) != null) {
            model.addAttribute("emailExists", true);

            return new ResponseEntity("emailExists", HttpStatus.OK);
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(userEmail);
       user.setPhone(phone);
       user.setCity(city);
       user.setAddress(address);
       user.setCountry(country);
       user.setState(state);

        Department department = new Department();
        department.setDeptId(7l);
        user.setDepartment(department);

       // String password = SecurityUtility.randomPassword();

        String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
        user.setPassword(encryptedPassword);

        Role role = new Role();
        role.setRoleId(7);
        role.setName("GUEST");
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, role));
        userService.createUser(user, userRoles);

        String token = UUID.randomUUID().toString();
        userService.createPasswordResetTokenForUser(user, token);

        String appUrl =
                "http://" + request.getServerName() +
                        ":" + request.getServerPort() +
                        request.getContextPath();

    /*    SimpleMailMessage email =
                mailConstructor.constructResetTokenEmail(appUrl, request.getLocale(), token, user, password);

        mailSender.send(email);

        model.addAttribute("emailSent", "true");*/

        return new ResponseEntity("User Added Successfully!", HttpStatus.OK);
    }


    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ResponseEntity changePassword(@RequestBody PassChange passChange){

        User user = userService.findOne(passChange.getUserId());
        if(passChange.getPassword()!=null) {
            String encryptedPassword = SecurityUtility.passwordEncoder().encode(passChange.getPassword());
            user.setPassword(encryptedPassword);
        }

        user.setShowStatus(passChange.isShowStatus());

        userService.save(user);

        return new ResponseEntity("Password Changed Successfully!", HttpStatus.OK);
    }

    @RequestMapping("/addNewUser")
    public ResponseEntity addNewUser(
            Locale locale, Model model,
            @RequestParam("token") String token) {

        PasswordResetToken passToken = userService.getPasswordResetToken(token);
        if (passToken == null) {
            String message = "Invalid Token.";
            model.addAttribute("message", message);
            return new ResponseEntity("Can't Add User!", HttpStatus.BAD_REQUEST);

        }

        Calendar cal = Calendar.getInstance();
        if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            model.addAttribute("message", "Token has expired.");
            return new ResponseEntity("Can't Add User!", HttpStatus.BAD_REQUEST);

        }

        User user = passToken.getUser();

        String username = user.getUsername();

        UserDetails userDetails = userSecurityService.loadUserByUsername(username);

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        model.addAttribute("user", user);

        return new ResponseEntity("User Added Successfully!", HttpStatus.OK);
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public List<User> getUserList() {

        return userService.getUserList();
    }

    @RequestMapping(value = "/getOnlineUsers", method = RequestMethod.GET)
    public List<UserInfo> getOnlineUser() {

        List<UserInfo> userInfoList = new ArrayList<UserInfo>();

        for (User user : userService.getUserList()) {
            UserInfo userInfo = new UserInfo();
            userInfo.setCity(user.getCity());
            userInfo.setUsername(user.getUsername());
            userInfo.setState(user.getState());
            userInfo.setRole(user);
            userInfo.setStatus(userService.getOnlineUser(user.getId()));
            userInfoList.add(userInfo);

    }
        return userInfoList;
    }

    @RequestMapping(value = "/getUserRole/{id}", method = RequestMethod.GET)
    @Transactional
    public List<UserRole> getUserRole(@PathVariable("id") Long id) {

        return userService.getUserRole(id).stream().collect(Collectors.toList());
    }

    @RequestMapping(value = "/getUserRoles", method = RequestMethod.GET)
    @Transactional
    public List<Role> getUserRoles() {

        return (List<Role>)roleRepository.findAll();
    }

    @RequestMapping(value = "/addRoles", method = RequestMethod.POST)
    @Transactional
    public String addRoles(@RequestBody AssignRoles assignRoles) {

       userService.assignRoles(assignRoles);
       return "Sucess";
    }
}
