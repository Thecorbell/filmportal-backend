package se.filmportal.backend.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import se.filmportal.backend.entity.Image;


public interface ImageRepository
               extends JpaRepository<Image, Long>{
	List<Image> findByFilmId(Long filmId);

}
