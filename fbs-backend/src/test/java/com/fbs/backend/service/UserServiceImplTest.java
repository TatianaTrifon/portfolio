package com.fbs.backend.service;

import com.fbs.backend.dao.UserDAOImpl;
import com.fbs.backend.domain.User;
import com.fbs.backend.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

  @Mock UserDAOImpl userDAOImpl;

  UserServiceImpl userServiceImpl;

  @BeforeEach
  void setUp() {
    userServiceImpl = new UserServiceImpl(userDAOImpl);
  }

  private User getTestUser() {
    return new User(
        1, "Anton", "Ivanovici", "anton.invanovici@gmail.com", "passenger", "3673412123");
  }

  @Test
  void shouldCreateUser() {
    User user = getTestUser();

    Mockito.when(userDAOImpl.create(user)).thenReturn(user);
    userServiceImpl.createUser(user);
    assertNotNull(user);

    Mockito.when(userDAOImpl.findById(user.getId())).thenReturn(user);
    User testUser = userServiceImpl.findUserById(user.getId());
    assertNotNull(testUser);
    assertEquals(testUser, user);
  }

  @Test
  void shouldUpdateUser() {
    User user = getTestUser();

    Mockito.when(userDAOImpl.create(user)).thenReturn(user);
    userServiceImpl.createUser(user);

    user.setEmail("anton.invanOvici@gmail.com");

    Mockito.when(userDAOImpl.update(user)).thenReturn(user);
    User updatedUser = userServiceImpl.updateUser(user);
    assertNotNull(updatedUser);

    Mockito.when(userDAOImpl.findById(updatedUser.getId())).thenReturn(updatedUser);
    User foundUser = userServiceImpl.findUserById(updatedUser.getId());
    assertNotNull(foundUser);
    assertEquals(foundUser, updatedUser);

    Mockito.when(userDAOImpl.deleteById(user.getId())).thenReturn(true);
    boolean isDeleted = userServiceImpl.deleteUserById(user.getId());
    assertTrue(isDeleted);
  }

  @Test
  void ShouldCreateUserIfNotFound() {

    User user =
        new User("Anton", "Ivanovici", "anton.invanovici@gmail.com", "passenger", "3673412123");

    Mockito.lenient().when(userDAOImpl.findById(user.getId())).thenReturn(null);
    User notFoundUser = userServiceImpl.findUserById(user.getId());
    assertNull(notFoundUser);

    Mockito.when(userDAOImpl.create(user)).thenReturn(user);
    user.setId(1);
    userServiceImpl.createUser(user);
    assertNotNull(user);

    Mockito.when(userDAOImpl.findById(user.getId())).thenReturn(user);
    User anotherUser = userServiceImpl.findUserById(user.getId());
    assertNotNull(anotherUser);
    assertEquals(anotherUser, user);
  }

  @Test
  void shouldDeleteUserById() {
    User user = getTestUser();

    userServiceImpl.createUser(user);
    assertNotNull(user);

    Mockito.when(userDAOImpl.deleteById(user.getId())).thenReturn(true);
    boolean isDeleted = userServiceImpl.deleteUserById(user.getId());

    assertTrue(isDeleted);
  }

  @Test
  void shouldFindUserById() {
    User user = getTestUser();
    userServiceImpl.createUser(user);
    assertNotNull(user);

    Mockito.when(userDAOImpl.findById(user.getId())).thenReturn(user);
    User foundUser = userServiceImpl.findUserById(user.getId());

    assertNotNull(foundUser);
  }

  @Test
  void shouldFindUserByEmail() {
    User user = getTestUser();

    userServiceImpl.createUser(user);
    assertNotNull(user);

    Mockito.when(userDAOImpl.findByEmail(user.getEmail())).thenReturn(user);
    User foundUser = userServiceImpl.findUserByEmail(user.getEmail());

    assertNotNull(foundUser);
  }
}
