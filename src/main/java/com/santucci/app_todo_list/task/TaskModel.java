package com.santucci.app_todo_list.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tasks")
public class TaskModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String description;

    @Column(length=50)
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority; 

    private UUID idUser;

    @CreationTimestamp
    private LocalDateTime createdAt;
   
}