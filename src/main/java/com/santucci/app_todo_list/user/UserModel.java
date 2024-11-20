package com.santucci.app_todo_list.user;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
@Entity(name = "users")
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    private String username;
    private String password;
    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    

    // getters e setters 

    // public void setUsername(String username) {
    //     this.username = username;
    // }

    // public String getUsername() {   
    //     return this.username;

    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public String getName() {
    //     return this.name;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }

    // public String getPassword() {
    //     return this.password;
    // }
    
}