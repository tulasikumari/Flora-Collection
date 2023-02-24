package com.system.floracollection.Pojo;

import com.system.floracollection.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private MultipartFile image;

    public UserPojo(User user) {
        this.id=user.getId();
        this.username=user.getUsername();
        this.email=user.getEmail();
        this.password=user.getPassword();
    }
}


