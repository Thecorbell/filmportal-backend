package se.filmportal.backend.repository;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import se.filmportal.backend.entity.Submission;
public interface SubmissionRepository extends JpaRepository<Submission, Long> {

	List<Submission> findByFilmId(Long filmId);

	List<Submission> findByFestivalId(Long festivalId);
}
