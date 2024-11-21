package com.santucci.app_todo_list.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired // irá gerenciar a instanciação da minha classe 
    private IUserRepository userRepository;
    
    @PostMapping("/")
   public UserModel create(@RequestBody UserModel userModel) {
    return this.userRepository.save(userModel);

   }
}
