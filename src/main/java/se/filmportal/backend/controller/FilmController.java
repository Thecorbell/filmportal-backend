package se.filmportal.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import se.filmportal.backend.entity.Person;
import se.filmportal.backend.entity.FilmPerson;

import se.filmportal.backend.repository.PersonRepository;
import se.filmportal.backend.repository.FilmPersonRepository;
import se.filmportal.backend.entity.Film;
import se.filmportal.backend.repository.FilmRepository;
import se.filmportal.backend.dto.FilmPersonResponse;

@RestController
@RequestMapping("/api/films")
public class FilmController {

	private final FilmRepository filmRepository;
	private final FilmPersonRepository filmPersonRepository;
	private final PersonRepository personRepository;
	

	public FilmController(
	        FilmRepository filmRepository,
	        FilmPersonRepository filmPersonRepository,
	        PersonRepository personRepository) {

	    this.filmRepository = filmRepository;
	    this.filmPersonRepository = filmPersonRepository;
	    this.personRepository = personRepository;
	}

    @GetMapping
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable Long id) {
        return filmRepository.findById(id)
                .orElseThrow();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Film createFilm(@RequestBody Film film) {
        return filmRepository.save(film);
    }
    
    @PutMapping("/{id}")
    public Film updateFilm(
            @PathVariable Long id,
            @RequestBody Film updatedFilm) {

        Film film = filmRepository.findById(id)
                .orElseThrow();

        film.setTitle(updatedFilm.getTitle());
        film.setAlternativeTitle(updatedFilm.getAlternativeTitle());
        film.setGenre(updatedFilm.getGenre());
        film.setDurationMinutes(updatedFilm.getDurationMinutes());
        film.setLanguage(updatedFilm.getLanguage());
        film.setSubtitleLanguage(updatedFilm.getSubtitleLanguage());
        film.setLogline(updatedFilm.getLogline());
        film.setSummary(updatedFilm.getSummary());
        film.setAiUsed(updatedFilm.getAiUsed());

        return filmRepository.save(film);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Long id) {
        filmRepository.deleteById(id);
    }
    
    @GetMapping("/{id}/persons")
    public List<FilmPersonResponse> getPersonsForFilm(
            @PathVariable Long id) {

        List<FilmPerson> relations =
                filmPersonRepository.findByFilmId(id);

        return relations.stream()
                .map(relation -> {

                    Person person =
                            personRepository
                                    .findById(relation.getPersonId())
                                    .orElseThrow();

                    FilmPersonResponse response =
                            new FilmPersonResponse();

                    response.setName(person.getName());
                    response.setRole(relation.getRole());
                    response.setPersonId(relation.getPersonId());

                    return response;
                })
                .toList();
    }
}