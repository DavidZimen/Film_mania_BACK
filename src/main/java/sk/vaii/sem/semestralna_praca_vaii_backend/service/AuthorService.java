package sk.vaii.sem.semestralna_praca_vaii_backend.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.Author;
import sk.vaii.sem.semestralna_praca_vaii_backend.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllUsers() {
        return this.authorRepository.findAll();
    }

    public Optional<Author> findAuthorById(Long id) {
        return this.authorRepository.findById(id);
    }

    public Author addAuthor(Author author) {
        return this.authorRepository.save(author);
    }

    public Author updateAuthor(Author author) {
        return this.authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        this.authorRepository.deleteById(id);
    }
}
