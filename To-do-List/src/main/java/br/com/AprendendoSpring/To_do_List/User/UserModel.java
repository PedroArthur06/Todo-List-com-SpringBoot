package br.com.AprendendoSpring.To_do_List.User;

public class UserModel {

  // Atributos do usuario
  private String name;
  private String email;
  private String password;

  // Construtor
  public UserModel(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }

}
