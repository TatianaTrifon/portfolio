package com.fbs.backend.dao;

import com.fbs.backend.dao.UserDAO;
import com.fbs.backend.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDAOImplTest {

  @Autowired private UserDAO userDAO;

  private User getTestUser(){
    return  new User("Anton", "Ivanovici", "anton.ivanoovici@gmail.com", "passenger", "634101463");
  }

  @Test
  void ShouldCreateUser() {
    User user = getTestUser();


    userDAO.create(user);

    assertNotNull(user);

    User testUser = userDAO.findById(user.getId());
    assertNotNull(testUser);
    assertEquals(testUser, user);

    boolean isTheUserDeleted = userDAO.deleteById(user.getId());

    assertTrue(isTheUserDeleted);
  }



      @Test
      void ShouldUpdateUser() {
          User user = getTestUser();

          userDAO.create(user);

        user.setEmail("anton.invanoOvici@gmail.com");

    User updatedUser = userDAO.update(user);
    assertNotNull(updatedUser);

    User foundUser = userDAO.findById(updatedUser.getId());
    assertNotNull(foundUser);
    assertEquals(foundUser,updatedUser);

    boolean isDeleted = userDAO.deleteById(user.getId());
    assertTrue(isDeleted);
        }

        @Test
        void ShouldCreateUserIfNotFound(){

          User user = getTestUser();

    assertNull(userDAO.findById(user.getId()));

     userDAO.create(user);
    assertNotNull(user);


    boolean isDeleted = userDAO.deleteById(user.getId());
    assertTrue(isDeleted);
        }



  @Test
  void ShouldDeleteById() {
    User user = getTestUser();

    userDAO.create(user);

    assertNotNull(user);

    boolean isTheUserDeleted = userDAO.deleteById(user.getId());

    assertTrue(isTheUserDeleted);
  }


  @Test
  void findById() {
    User user = getTestUser();

    userDAO.create(user);

    assertNotNull(user);

    User foundUser = userDAO.findById(user.getId());
    assertNotNull(foundUser);

    boolean isTheUserDeleted = userDAO.deleteById(user.getId());
    assertTrue(isTheUserDeleted);
  }

  @Test
  void findByEmail() {
    User user = getTestUser();

    userDAO.create(user);

    assertNotNull(user);

    User foundUser = userDAO.findByEmail(user.getEmail());
    assertNotNull(foundUser);

    boolean isTheUserDeleted = userDAO.deleteById(user.getId());
    assertTrue(isTheUserDeleted);
  }
}
