package com.slowickip.spring5webapp.repositories;

import com.slowickip.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
