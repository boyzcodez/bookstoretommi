package fi.haaga.bookstoretommi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookTypeRepository extends CrudRepository<BookType, Long> {
    List<BookType> findByMyBookType(String myBookType);
} 

// ssh -L 3306:localhost:3306 tommik@softala.haaga-helia.fi

