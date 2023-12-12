package tpalmerjr.springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tpalmerjr.springframework.spring6webapp.domain.Author;
import tpalmerjr.springframework.spring6webapp.domain.Book;
import tpalmerjr.springframework.spring6webapp.domain.Publisher;
import tpalmerjr.springframework.spring6webapp.repositories.AuthorRepository;
import tpalmerjr.springframework.spring6webapp.repositories.BookRepository;
import tpalmerjr.springframework.spring6webapp.repositories.PublisherRepository;

import java.awt.*;

@Component
public class BoostrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BoostrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author terry = new Author();
        terry.setFirstName("Terry");
        terry.setLastName("Palmer");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author terrySaved = authorRepository.save(terry);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        terrySaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(terrySaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main");
        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
