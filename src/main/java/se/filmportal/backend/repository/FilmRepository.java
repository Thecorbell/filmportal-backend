package se.filmportal.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.filmportal.backend.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

}