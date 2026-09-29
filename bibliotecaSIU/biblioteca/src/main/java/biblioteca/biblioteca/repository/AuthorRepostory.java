package biblioteca.biblioteca.repository;

import biblioteca.biblioteca.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepostory extends JpaRepository<Author, Long>{
    //CRUD

}
