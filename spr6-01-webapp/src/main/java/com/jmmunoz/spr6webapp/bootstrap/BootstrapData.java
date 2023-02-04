package com.jmmunoz.spr6webapp.bootstrap;

import com.jmmunoz.spr6webapp.domain.Author;
import com.jmmunoz.spr6webapp.domain.Book;
import com.jmmunoz.spr6webapp.domain.Publisher;
import com.jmmunoz.spr6webapp.repositories.AuthorRepository;
import com.jmmunoz.spr6webapp.repositories.BookRepository;
import com.jmmunoz.spr6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// CommandLineRunner
// Dice a SpringBoot que, cuando arranque y detecte este tipo de componente en el classpath o en el contexto,
// lo coja y ejecute el método run
@Component
public class BootstrapData implements CommandLineRunner {

    // Es una buena práctica declarar componentes del contexto Spring como final, para que no puedan cambiar
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    // Al ejecutarse, Spring hace el autowire automático de las implementaciones de los repositorios que nos
    // proporciona Spring Data JPA
    public BootstrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        // Al grabar un autor, la interface repository devuelve un objeto nuevo, y es una buena práctica guardarlo
        // en una variable
        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("4723842379");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        // Asociaciones entre authors y books
        // Esta instrucción da error si no inicializamos, en la clase Book y Author el Set, porque tenemos id, pero
        // Book vale null, y nos aparece un error NullPointerException
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        // Persistiendo la nueva asociación de Book a Author
        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());

        // Informando editores
        Publisher addison = new Publisher();
        addison.setPublisherName("Addison Wesley");
        addison.setAddress("123 Street");
        addison.setCity("Reading");
        addison.setState("Massachusets");
        addison.setZipCode("12345");
        publisherRepository.save(addison);

        Publisher wiley = new Publisher();
        wiley.setPublisherName("Addison Wesley");
        wiley.setAddress("111 River Street Hoboken");
        wiley.setCity("New York");
        wiley.setState("New York");
        wiley.setZipCode("07030");
        publisherRepository.save(wiley);

        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
