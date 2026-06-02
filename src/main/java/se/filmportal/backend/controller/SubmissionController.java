package se.filmportal.backend.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import se.filmportal.backend.entity.Festival;
import se.filmportal.backend.entity.Film;
import se.filmportal.backend.entity.Submission;
import se.filmportal.backend.repository.FestivalRepository;
import se.filmportal.backend.repository.FilmRepository;
import se.filmportal.backend.repository.SubmissionRepository;

import se.filmportal.backend.dto.SubmissionResponse;

@RestController
@RequestMapping("/api/submission")
public class SubmissionController {
	private SubmissionRepository submissionRepository;
	private final FilmRepository filmRepository;
	private final FestivalRepository festivalRepository;
	
	public SubmissionController(
	        SubmissionRepository submissionRepository,
	        FilmRepository filmRepository,
	        FestivalRepository festivalRepository) {

	    this.submissionRepository = submissionRepository;
	    this.filmRepository = filmRepository;
	    this.festivalRepository = festivalRepository;
	}
	@GetMapping
	public List<Submission> getAllSubmission(){
		return submissionRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Submission getSubmissionById(@PathVariable Long id) {
		return submissionRepository.findById(id).orElseThrow();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Submission createSubmission(@RequestBody Submission submission) {
		return submissionRepository.save(submission);
	}

	@PutMapping("/{id}")
	public Submission updateSubmission(@PathVariable Long id, @RequestBody Submission updatedSubmission ) {
		Submission submission = submissionRepository.findById(id).orElseThrow();
		submission.setFilmId(updatedSubmission.getFilmId());
		submission.setFestivalId(updatedSubmission.getFestivalId());
		submission.setStatus(updatedSubmission.getStatus());
		submission.setAttendingScreening(updatedSubmission.isAttendingScreening());
		return submissionRepository.save(submission);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteSubmission(@PathVariable Long id) {
		submissionRepository.deleteById(id);
	}
	
	
	@GetMapping("/film/{filmId}")
	public List<SubmissionResponse> getSubmissionsForFilm(
	        @PathVariable Long filmId){
		List<Submission> submissions = submissionRepository.findByFilmId(filmId);
		
		return submissions.stream()
		        .map(submission -> {
		        	Festival festival =
		        	        festivalRepository.findById(
		        	                submission.getFestivalId())
		        	        .orElseThrow();
		            
		        	Film film =
		        	        filmRepository.findById(
		        	                submission.getFilmId())
		        	        .orElseThrow();
		        	
		            SubmissionResponse response =
		                    new SubmissionResponse();
		            response.setSubmissionId(
		                    submission.getId());
		            response.setFilmTitle(film.getTitle());
		            response.setFestivalName(festival.getName());
		            response.setStatus(submission.getStatus());
		            response.setAttendingScreening(submission.isAttendingScreening());
		            return response;
		        })
		        .toList();
		
	}
	
	@GetMapping("/festival/{festivalId}")
	public List<SubmissionResponse> getSubmissionsForFestival(
	        @PathVariable Long festivalId){
		List<Submission> submissions = submissionRepository.findByFestivalId(festivalId);
		
		return submissions.stream()
		        .map(submission -> {
		        	Festival festival =
		        	        festivalRepository.findById(
		        	                submission.getFestivalId())
		        	        .orElseThrow();
		            
		        	Film film =
		        	        filmRepository.findById(
		        	                submission.getFilmId())
		        	        .orElseThrow();
		        	
		            SubmissionResponse response =
		                    new SubmissionResponse();
		            response.setSubmissionId(
		                    submission.getId());
		            response.setFilmTitle(film.getTitle());
		            response.setFestivalName(festival.getName());
		           
		            return response;
		        })
		        .toList();
		
	}
	
	
}
