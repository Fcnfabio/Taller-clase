package biblioteca.biblioteca.servicies.impl;

import biblioteca.biblioteca.dto.AuthorResponse;
import biblioteca.biblioteca.dto.BookResponse;
import biblioteca.biblioteca.dto.CreateAuthorRequest;
import biblioteca.biblioteca.dto.CreateBookRequest;
import biblioteca.biblioteca.entities.Author;
import biblioteca.biblioteca.entities.Book;
import biblioteca.biblioteca.repository.AuthorRepostory;
import biblioteca.biblioteca.repository.BookRepository;
import biblioteca.biblioteca.servicies.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepostory authorRepostory;

    @Autowired
    private BookResponse bookResponse;
    @Override
    public AuthorResponse crearAutor(CreateAuthorRequest request){
        Author author = new Author(request.nombre());
        Author guardado = authorRepostory.save(author);

        return mapToResponse(guardado);
    }

    //Mapeo
    private AuthorResponse mapToResponse(Author author){
        List<BookResponse> librosDTO =author.getBooks()
                .stream()
                .map(book -> new BookResponse(book.getId(), book.getTitle()))
                .toList();

        return new AuthorResponse(author.getId(), author.getName(), librosDTO);
    }

    public List<AuthorResponse> listarAutores(){
        return authorRepostory.findAll().stream().map(this::mapToResponse).toList();
    }

    public AuthorResponse buscarPorId(Long id){
        Author author = authorRepostory.findById(id).orElseThrow(() -> new RuntimeException("Autor no encontrado on el id "+id));

        return mapToResponse(author);
    }

    public BookResponse agregarLibro(CreateBookRequest request){
        Author author = authorRepostory.findById(request.authorId()).orElseThrow(() -> new RuntimeException("Autor no encontrado on el id "+id));

        Book book = new Book(request.title());
        author.addBook(book);
        Book guardado = BookRepository.
    }
}