package br.com.AprendendoSpring.To_do_List.User;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
public class UserController {

  // Injeção de dependência do repositório de usuários
  @Autowired
  private UserRepository userRepository;

  @PostMapping("/")
  public UserModel create(@RequestBody UserModel userModel) {

    var userCreated = this.userRepository.save(userModel);
    return userCreated;

  }

}
