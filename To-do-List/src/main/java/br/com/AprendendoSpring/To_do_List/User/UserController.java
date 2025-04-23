package br.com.AprendendoSpring.To_do_List.User;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
public class UserController {

  @PostMapping("/")
  public void create(@RequestBody UserModel userModel) {

    System.out.println("User created: " + userModel.getName());
    System.out.println("Email: " + userModel.getEmail());
    System.out.println("Password: " + userModel.getPassword());

  }

}
