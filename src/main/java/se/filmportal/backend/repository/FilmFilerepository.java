package se.filmportal.backend.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import se.filmportal.backend.entity.FilmFile;

public interface FilmFilerepository extends JpaRepository<FilmFile, Long> {
	List<FilmFile> findByFilmId(Long filmId);

}
