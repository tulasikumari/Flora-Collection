package com.system.floracollection.Service;

import com.system.floracollection.Entity.Contact;
import com.system.floracollection.Entity.User;
import com.system.floracollection.Pojo.ContactPojo;
import com.system.floracollection.Pojo.UserPojo;

import java.util.List;

public interface UserService {

    abstract User fetchById(Integer id);

    String saveUser(UserPojo userPojo);
    List<User> fetchAll();
    String submitMsg(ContactPojo contactPojo);
    void deleteById(Integer id);

    UserPojo findByUserName(String username);
    UserPojo findByEmail(String email);

    UserPojo findByPassword(String password);
    List<Contact> fetchAllContact();

    Contact CfetchById(Integer id);
    void CdeleteById(Integer id);


}