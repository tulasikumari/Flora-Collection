package com.system.floracollection.Pojo;

import com.system.floracollection.Entity.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactPojo {
    private Integer id;
    private String name;
    private String email;
    private String message;
    public ContactPojo(Contact contact) {
        this.id=contact.getId();
        this.name=contact.getName();
        this.email=contact.getEmail();
        this.message=contact.getMessage();
    }
}
