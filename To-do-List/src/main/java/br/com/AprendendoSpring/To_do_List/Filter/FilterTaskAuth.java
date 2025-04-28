package br.com.AprendendoSpring.To_do_List.Filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.AprendendoSpring.To_do_List.User.UserRepository;
import br.com.AprendendoSpring.To_do_List.User.UserModel;
import at.favre.lib.crypto.bcrypt.BCrypt;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

  @Autowired
  private UserRepository userRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterchain)
      throws IOException, ServletException {

    // pegar a autenticação (usuario,senha)
    var authorization = request.getHeader("Authorization");

    var authEncoded = authorization.substring("Basic ".length()).trim();

    byte[] authDecoded = Base64.getDecoder().decode(authEncoded);

    var authString = new String(authDecoded);

    String[] credentials = authString.split(":");
    String username = credentials[0];
    String password = credentials[1];
    System.out.println("Username: " + username);
    System.out.println("Password: " + password);

    // validar usuario
    var user = this.userRepository.findByUserName(username);
    if (user == null) {
      response.sendError(401, "Usuario não encontrado!");
    } else {
      // validar senha
      var passwordValid = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
      if (passwordValid.verified) {
        filterchain.doFilter(request, response);
      } else {
        response.sendError(401, "Senha inválida!");
      }
    }

    filterchain.doFilter(request, response);

  }
}