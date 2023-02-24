package com.system.floracollection.Controller;

import ch.qos.logback.core.model.Model;
import com.system.floracollection.Entity.Contact;
import com.system.floracollection.Entity.User;
import com.system.floracollection.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class admincontroller {
    private final UserService userService;

    @GetMapping("/dashboard")
    public String getAdminProfile(Model model) {
        return "admin";

    }

    @GetMapping("/contactlist")
    public String getContactList(org.springframework.ui.Model model) {
        List<Contact> contacts = userService.fetchAllContact();
        model.addAttribute("contact", contacts);
        return "viewcontact";
    }

    @GetMapping("/userDetails")
    public String getUserDetails(org.springframework.ui.Model model) {
        List<User> users = userService.fetchAll();
        model.addAttribute("userList", users.stream().map(user ->
                User.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .email(user.getEmail())
//                        .phone(user.getPhone())
                        .build()
        ));
        return "/Userlist";
    }





    @GetMapping("/deleteContact/{id}")
    public String deleteContact(@PathVariable("id") Integer id) {
        userService.CdeleteById(id);
        return "redirect:/admin/contactlist";
    }

//    @GetMapping("/userDetails")
//    public String getUserDetails(Model model) {
//        List<User> users = userService.fetchAll();
//        model.addA
//        return "Admin/user-list";
//    }
}


