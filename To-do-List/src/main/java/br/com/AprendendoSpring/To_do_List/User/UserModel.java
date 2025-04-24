package br.com.AprendendoSpring.To_do_List.User;

import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import java.time.LocalDateTime;

@Data

// Anotação para indicar que essa classe é uma entidade do banco de dados
// O nome da tabela será "tb_users"
@Entity(name = "tb_users")
public class UserModel {

  @Id

  // Gera o ID automaticamente
  @GeneratedValue(generator = "UUID")

  private UUID id;

  // Atributos do usuario
  private String name;
  private String email;
  private String password;

  @CreationTimestamp
  private LocalDateTime createdAt;

}
