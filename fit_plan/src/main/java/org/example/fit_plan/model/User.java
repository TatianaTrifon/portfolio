package org.example.fit_plan.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {

    private int userId;

    private String email;

    private String username;

     private String password;

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(int userId, String email, String password) {
        this.userId = userId;
        this.email = email;
        this.password = password;
    }
}
