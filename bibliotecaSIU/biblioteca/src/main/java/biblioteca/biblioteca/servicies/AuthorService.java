package biblioteca.biblioteca.servicies;

import biblioteca.biblioteca.dto.AuthorResponse;
import biblioteca.biblioteca.dto.BookResponse;
import biblioteca.biblioteca.dto.CreateAuthorRequest;
import biblioteca.biblioteca.dto.CreateBookRequest;

import java.util.List;

public interface AuthorService {
    AuthorResponse crearAutor(CreateAuthorRequest request);
    List<AuthorResponse> listarAutores();
    AuthorResponse buscarPorId(Long id);
    BookResponse agregarLibro(CreateBookRequest request);

}

