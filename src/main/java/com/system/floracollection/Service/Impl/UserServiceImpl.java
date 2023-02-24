package com.system.floracollection.Service.Impl;

import com.system.floracollection.Entity.Contact;
import com.system.floracollection.Entity.User;
import com.system.floracollection.Pojo.ContactPojo;
import com.system.floracollection.Pojo.UserPojo;
import com.system.floracollection.Repo.ContactRepo;
import com.system.floracollection.Repo.UserRepo;
import com.system.floracollection.Service.UserService;
import com.system.floracollection.exception.AppException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepo userRepo;
    public final ContactRepo contactRepo;


    @Override
    public User fetchById(Integer id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));

    }

    @Override
    public String saveUser(UserPojo userPojo) {
        System.out.println("userserviceimplsave");
        User user = new User();
        user.setUsername(userPojo.getUsername());
        user.setEmail(userPojo.getEmail());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(userPojo.getPassword());
        user.setPassword(encodePassword);
        userRepo.save(user);
        return "created";
    }

    @Override
    public List<User> fetchAll() {
        return userRepo.findAll();
    }
    @Override
    public String submitMsg(ContactPojo contactPojo) {
        Contact contact = new Contact();
        contact.setName(contactPojo.getName());
        contact.setEmail(contactPojo.getEmail());
//        contact.setSubject(contactPojo.getSubject());
        contact.setMessage(contactPojo.getMessage());
        contactRepo.save(contact);
        return null;
    }

//

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public UserPojo findByUserName(String username) {
        User user = userRepo.findByUserName(username)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
        return new UserPojo(user);
    }




    @Override
    public UserPojo findByEmail(String email) {
        return null;
    }

    @Override
    public UserPojo findByPassword(String password) {
        return null;
    }
    @Override
    public List<Contact> fetchAllContact() {
        return this.contactRepo.findAll();
    }


    @Override
    public Contact CfetchById(Integer id) {
        return contactRepo.findById(id).orElseThrow(()->new RuntimeException("no found"));
    }

    @Override
    public void CdeleteById(Integer id) {
            contactRepo.deleteById(id);
    }



}
