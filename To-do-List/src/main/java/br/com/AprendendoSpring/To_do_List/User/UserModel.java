package br.com.AprendendoSpring.To_do_List.User;

import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
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

  // A anottation @Column é usada para definir as propriedades da coluna no banco
  // de dados, no caso da coluna "email" e "userName" são únicas e não podem ser
  // nulas
  // O atributo "nullable" indica se a coluna pode ser nula ou não

  // Atributos do usuario
  private String name;
  @Column(unique = true, nullable = false)
  private String email;
  private String password;
  @Column(unique = true)
  private String userName;

  // Anotação para indicar que esse campo será preenchido automaticamente com a
  // data e hora de criação
  @CreationTimestamp
  private LocalDateTime createdAt;

}
