package com.jmmunoz.spr6webapp.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    // Un autor puede tener varios libros y un libro puede tener varios autores (Many to Many)
    // Es mejor usar Set que List porque cada Book debería ser un item unique y un List permite elementos duplicados
    @ManyToMany(mappedBy = "authors")
    // Si no inicializamos nos da un error en la clase BootstrapData
    private Set<Book> books = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    // Siempre es bueno crear el método toString()
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }

    // Es importante crear los métodos equals() y hashCode() porque Hibernate los usa de forma interna para determinar
    // la igualdad entre objetos.
    // Hay un par de estrategias que se pueden implementar, como utilizar solo el campo Id o todos los campos de la entidad.
    // En este ejemplo se va a usar solo el campo Id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
