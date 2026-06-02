package se.filmportal.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import se.filmportal.backend.entity.Person;
import se.filmportal.backend.repository.PersonRepository;
import se.filmportal.backend.entity.Film;
import se.filmportal.backend.entity.FilmPerson;

import se.filmportal.backend.repository.FilmRepository;
import se.filmportal.backend.repository.FilmPersonRepository;
import se.filmportal.backend.dto.PersonFilmResponse;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

	private final PersonRepository personRepository;
	private final FilmRepository filmRepository;
	private final FilmPersonRepository filmPersonRepository;

	public PersonController(
	        PersonRepository personRepository,
	        FilmRepository filmRepository,
	        FilmPersonRepository filmPersonRepository) {

	    this.personRepository = personRepository;
	    this.filmRepository = filmRepository;
	    this.filmPersonRepository = filmPersonRepository;
	}

    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
    	return personRepository.findById(id)
    			.orElseThrow();
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
    	return personRepository.save(person);
    }
    
    @PutMapping("/{id}")
    public Person updatePerson(
    		@PathVariable Long id,
    		@RequestBody Person updatedPerson) {
    	Person person = personRepository.findById(id)
    			.orElseThrow();
    	person.setName(updatedPerson.getName());
    	person.setEmail(updatedPerson.getEmail());
    	person.setPhone(updatedPerson.getPhone());
    	return personRepository.save(person);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
    	personRepository.deleteById(id);
    }
    @GetMapping("/{id}/films")
    public List<PersonFilmResponse> getFilmsForPerson(
            @PathVariable Long id) {

        List<FilmPerson> relations =
                filmPersonRepository.findByPersonId(id);

        return relations.stream()
                .map(relation -> {

                    Film film =
                            filmRepository
                                    .findById(relation.getFilmId())
                                    .orElseThrow();

                    PersonFilmResponse response =
                            new PersonFilmResponse();

                    response.setTitle(film.getTitle());
                    response.setRole(relation.getRole());
                    response.setFilmId(relation.getFilmId());

                    return response;
                })
                .toList();
    }
    
}