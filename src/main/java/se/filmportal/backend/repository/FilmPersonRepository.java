package se.filmportal.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se.filmportal.backend.entity.FilmPerson;
import java.util.List;

public interface FilmPersonRepository
        extends JpaRepository<FilmPerson, Long> {
	List<FilmPerson> findByFilmId(Long filmId);
	List<FilmPerson> findByPersonId(Long personId);

}