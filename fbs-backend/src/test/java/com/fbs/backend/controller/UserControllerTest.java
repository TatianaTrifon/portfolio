package com.fbs.backend.controller;

import com.fbs.backend.controller.UserController;
import com.fbs.backend.domain.User;
import com.fbs.backend.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserControllerTest {
  @Mock UserServiceImpl userServiceImpl;

  UserController userController;

  @BeforeEach
  void setUp() {
    userController = new UserController(userServiceImpl);
  }

  private User getTestUser() {
    return new User(
        1, "Anton", "Ivanovici", "anton.invanovici@gmail.com", "passenger", "3673412123");
  }

  @Test
  void shouldCreateUser() {
    User user = getTestUser();

    Mockito.when(userServiceImpl.createUser(user)).thenReturn(user);
    userController.createUser(user);
    assertNotNull(user);

    Mockito.when(userServiceImpl.findUserById(user.getId())).thenReturn(user);
    User testUser = userController.findUserById(user.getId());
    assertNotNull(testUser);
    assertEquals(testUser, user);
  }

  @Test
  void shouldUpdateUser() {
    User user = getTestUser();

    Mockito.when(userServiceImpl.createUser(user)).thenReturn(user);
    userController.createUser(user);

    user.setEmail("anton.invanOvici@gmail.com");

    Mockito.when(userServiceImpl.updateUser(user)).thenReturn(user);
    User updatedUser = userController.updateUser(user);
    assertNotNull(updatedUser);

    Mockito.when(userServiceImpl.findUserById(updatedUser.getId())).thenReturn(updatedUser);
    User foundUser = userController.findUserById(updatedUser.getId());
    assertNotNull(foundUser);
    assertEquals(foundUser, updatedUser);

    Mockito.when(userServiceImpl.deleteUserById(user.getId())).thenReturn(true);
    boolean isDeleted = userController.deleteUserById(user.getId());

    assertTrue(isDeleted);
  }

  @Test
  void shouldCreateUserIfNotFound() {
    User user =
        new User("Anton", "Ivanovici", "anton.invanovici@gmail.com", "passenger", "3673412123");

    Mockito.lenient().when(userServiceImpl.findUserById(user.getId())).thenReturn(null);
    User notFoundUser = userController.findUserById(user.getId());
    assertNull(notFoundUser);

    Mockito.when(userServiceImpl.createUser(user)).thenReturn(user);
    user.setId(1);
    userController.createUser(user);
    assertNotNull(user);

    Mockito.when(userServiceImpl.findUserById(user.getId())).thenReturn(user);
    User testUser = userController.findUserById(user.getId());
    assertNotNull(testUser);
    assertEquals(testUser, user);
  }

  @Test
  void shouldDeleteUserById() {
    User user = getTestUser();
    userController.createUser(user);
    assertNotNull(user);

    Mockito.when(userServiceImpl.deleteUserById(user.getId())).thenReturn(true);
    boolean isDeleted = userServiceImpl.deleteUserById(user.getId());
    assertTrue(isDeleted);
  }

  @Test
  void shouldFindUserById() {
    User user = getTestUser();
    userController.createUser(user);
    assertNotNull(user);

    Mockito.when(userServiceImpl.findUserById(user.getId())).thenReturn(user);
    User foundUser = userServiceImpl.findUserById(user.getId());

    assertNotNull(foundUser);
  }

  @Test
  void shouldFindUserByEmail() {
    User user = getTestUser();

    userController.createUser(user);
    assertNotNull(user);

    Mockito.when(userServiceImpl.findUserByEmail(user.getEmail())).thenReturn(user);
    User foundUser = userServiceImpl.findUserByEmail(user.getEmail());

    assertNotNull(foundUser);
  }
}
