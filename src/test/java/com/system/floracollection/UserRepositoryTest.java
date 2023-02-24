package com.system.floracollection;

import com.system.floracollection.Entity.User;
import com.system.floracollection.Repo.UserRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    @Order(1)
    public void saveUserTest() {
        User user = User.builder()
                .username("tulasi")
                .password("1234")
                .build();
        userRepo.save(user);
        Assertions.assertThat(user.getId()).isGreaterThan(0);

    }

    @Test
    @Order(2)
    public void getUserTest() {
        User user = User.builder()
                .username("salini")
                .password("1234")
                .build();
        userRepo.save(user);
        User userCreated = userRepo.findById(user.getId()).get();
        Assertions.assertThat(user.getId()).isEqualTo(userCreated.getId());
    }
    @Test
    @Order(3)
    public void getListOfUserTest(){
        User user = User.builder()
                .username("rak")
                .email("a@g.com")
                .password("1234")
                .build();


        userRepo.save(user);
        List<User> User = userRepo.findAll();
        Assertions.assertThat(User.size()).isGreaterThan(0);
    }



@Test
@Order(4)
public void updateUserTest(){

    User user = User.builder()

            .username("beesha")
            .password("Educare")
            .email("1.gmail.com")
            .build();

    userRepo.save(user);

    User User1  = userRepo.findById(user.getId()).get();

    User1.setUsername("Educare nepal");

    User user2  = userRepo.save(user);

    Assertions.assertThat(user2.getUsername()).isEqualTo("Educare nepal");

}

    @Test
    @Order(5)
    public void deleteUserTest(){

        User user = User.builder()
                .username("rak")
                .email("a@g.com")
                .password("1234")
                .build();


        userRepo.save(user);

//        @Query(value = "SELECT * from")

        User user1 = userRepo.findById(user.getId()).get();
//        User user1 = userRepo.findById(user.getId()).get();
        userRepo.delete(user1);

        User user2 = null;
        Optional<User> optionalUser = userRepo.findByUserName("abs");
        if(optionalUser.isPresent()){
            user2 = optionalUser.get();
        }

        Assertions.assertThat(user2).isNull();
//        Assertions.assertThat(User1.getId()).isNull();
    }
}


