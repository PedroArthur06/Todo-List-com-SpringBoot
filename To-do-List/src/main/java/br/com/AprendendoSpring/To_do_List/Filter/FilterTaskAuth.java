package br.com.AprendendoSpring.To_do_List.Filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Base64;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

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
    // validar senha

    filterchain.doFilter(request, response);

  }
}