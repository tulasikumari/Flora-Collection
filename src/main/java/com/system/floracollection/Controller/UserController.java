package com.system.floracollection.Controller;

import com.system.floracollection.Entity.User;
import com.system.floracollection.Pojo.ContactPojo;
import com.system.floracollection.Pojo.UserPojo;
import com.system.floracollection.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class  UserController {
    private final UserService userService;

    private final ValidationAutoConfiguration validationAutoConfiguration;


    @GetMapping("/signup")
    public String createUser(Model model) {
        model.addAttribute("user", new UserPojo());
        return "signup";

    }
    @PostMapping("/save")
    public String saveUser(@Valid UserPojo userPojo) {
        userService.saveUser(userPojo);
        return "login";
    }
    @GetMapping("/about")
    public String getAbout() {
        return "AboutUs";
    }
    @GetMapping("/contact")
    public String getPage(Model model) {
        model.addAttribute("contact", new ContactPojo());
        return "contact";
    }

    @PostMapping("/send-message")
    public String submitMessage(@Valid ContactPojo contactPojo) {
        userService.submitMsg(contactPojo);
        return "redirect:/user/contact";
    }
    @GetMapping("/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        userService.deleteById(id);
        redirectAttributes.addFlashAttribute("deleteMsg", "Row delete successfully");
        return "redirect:/user/list";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.fetchById(id);
        model.addAttribute("user", new UserPojo(user));
        return "signup";
    }
}

