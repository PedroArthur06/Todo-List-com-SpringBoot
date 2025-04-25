package br.com.AprendendoSpring.To_do_List.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

  // Métodos para buscar usuários por email e nome de usuário
  UserModel findByEmail(String email);

  UserModel findByUserName(String userName);
}