package br.com.AprendendoSpring.To_do_List.User;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity create(@RequestBody UserModel userModel) {

    var users = this.userRepository.findByEmail(userModel.getEmail());

    if (users != null) {
      System.out.println("Email já cadastrado!");
      return ResponseEntity.badRequest().body("Email já cadastrado!");
    }

    var userCreated = this.userRepository.save(userModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);

  }

}
