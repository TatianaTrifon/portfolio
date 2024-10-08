package com.fbs.backend.controller;

import com.fbs.backend.domain.User;
import com.fbs.backend.service.UserService;
import com.fbs.backend.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

  private final UserService userService;


  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/create")
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @PutMapping("/update")
  public User updateUser(@RequestBody User user) {
    return userService.updateUser(user);
  }

  @DeleteMapping("/delete/{id}")
  public boolean deleteUserById(@PathVariable int id) {
    return userService.deleteUserById(id);
  }

  @GetMapping("/find-by-id/{id}")
  public User findUserById(@PathVariable Integer id) {
    if(id == null){
      return null;
    } else {
      return userService.findUserById(id);
        }
  }

  @GetMapping("/find-by-email/{email}")
  public User findUserByEmail(@PathVariable String email) {
    return userService.findUserByEmail(email);
  }
}
