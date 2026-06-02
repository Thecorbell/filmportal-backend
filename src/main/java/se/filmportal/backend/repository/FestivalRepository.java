package se.filmportal.backend.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import se.filmportal.backend.entity.Festival;
public interface FestivalRepository extends JpaRepository<Festival, Long> {

}
