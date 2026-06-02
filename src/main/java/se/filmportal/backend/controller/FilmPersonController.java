package se.filmportal.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import se.filmportal.backend.entity.FilmPerson;
import se.filmportal.backend.repository.FilmPersonRepository;

@RestController
@RequestMapping("/api/film-persons")
public class FilmPersonController {

    private final FilmPersonRepository filmPersonRepository;

    public FilmPersonController(FilmPersonRepository filmPersonRepository) {
        this.filmPersonRepository = filmPersonRepository;
    }

    @GetMapping
    public List<FilmPerson> getAllFilmPersons() {
        return filmPersonRepository.findAll();
    }

    @GetMapping("/{id}")
    public FilmPerson getFilmPersonById(@PathVariable Long id) {
        return filmPersonRepository.findById(id)
                .orElseThrow();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public FilmPerson createFilmPerson(
            @RequestBody FilmPerson filmPerson) {

        return filmPersonRepository.save(filmPerson);
    }

    @PutMapping("/{id}")
    public FilmPerson updateFilmPerson(
            @PathVariable Long id,
            @RequestBody FilmPerson updatedFilmPerson) {

        FilmPerson filmPerson = filmPersonRepository
                .findById(id)
                .orElseThrow();

        filmPerson.setFilmId(
                updatedFilmPerson.getFilmId());

        filmPerson.setPersonId(
                updatedFilmPerson.getPersonId());

        filmPerson.setRole(
                updatedFilmPerson.getRole());

        return filmPersonRepository.save(filmPerson);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteFilmPerson(
            @PathVariable Long id) {

        filmPersonRepository.deleteById(id);
    }
}