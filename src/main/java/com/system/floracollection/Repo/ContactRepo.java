package com.system.floracollection.Repo;

import com.system.floracollection.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepo extends JpaRepository <Contact, Integer> {
    Optional<Contact> findContactByEmail(String answer);

}
