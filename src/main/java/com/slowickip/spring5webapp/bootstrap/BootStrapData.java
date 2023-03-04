package com.slowickip.spring5webapp.bootstrap;

import com.slowickip.spring5webapp.domain.Author;
import com.slowickip.spring5webapp.domain.Book;
import com.slowickip.spring5webapp.domain.Publisher;
import com.slowickip.spring5webapp.repositories.AuthorRepository;
import com.slowickip.spring5webapp.repositories.BookRepository;
import com.slowickip.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher ayu = new Publisher("Ayu", "Jl. Kebon Jeruk", "Jakarta", "Jakarta",
                "12345");
        publisherRepository.save(ayu);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ayu.getBooks().add(ddd);
        ddd.setPublisher(ayu);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(ayu);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(ayu);
        ayu.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(ayu);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());

    }
}
