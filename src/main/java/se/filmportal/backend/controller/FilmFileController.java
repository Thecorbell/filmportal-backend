package se.filmportal.backend.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.filmportal.backend.entity.FilmFile;
import se.filmportal.backend.repository.FilmFilerepository;
import se.filmportal.backend.dto.FilmFileResponse;
import se.filmportal.backend.dto.ImageFilmResponse;

@RestController
@RequestMapping("/api/filmFile")
public class FilmFileController {
	
	private FilmFilerepository filmFileRepository;
	
	public FilmFileController(FilmFilerepository filmFileRepository) {
		this.filmFileRepository = filmFileRepository;
	}
	
	@GetMapping
	public List<FilmFile> getAllFilmFiles(){
		return filmFileRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public FilmFile getFilmFileById(@PathVariable Long id) {
		return filmFileRepository.findById(id).orElseThrow();
	}
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public FilmFile createFilmFile(@RequestBody FilmFile filmFile) {
		return filmFileRepository.save(filmFile);
		
	}
	
	@PutMapping("/{id}")
public FilmFile updateFilmFile(@PathVariable Long id, @RequestBody FilmFile updatedFilmFile) {
		FilmFile filmFile = filmFileRepository.findById(id).orElseThrow();
		filmFile.setFilmId(updatedFilmFile.getFilmId());
		filmFile.setObjectKey(updatedFilmFile.getObjectKey());
		filmFile.setFileName(updatedFilmFile.getFileName());
		filmFile.setMimeType(updatedFilmFile.getMimeType());
		filmFile.setFileSize(updatedFilmFile.getFileSize());
	
		return filmFileRepository.save(filmFile);
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteFilmFile(@PathVariable Long id) {
		filmFileRepository.deleteById(id);
	}
	
	@GetMapping("/film/{filmId}")
	public List<FilmFileResponse> getFilmFilesForFilm(
			@PathVariable Long filmId){
		List <FilmFile> filmFiles = filmFileRepository.findByFilmId(filmId);
		return filmFiles.stream()
				.map(filmFile -> {
		               FilmFileResponse response = new FilmFileResponse();
		               response.setFilmid(filmFile.getFilmId());
		               response.setObjectKey(filmFile.getObjectKey());
		               response.setFileName(filmFile.getFileName());
		               response.setFileSize(filmFile.getFileSize());
		               return response;
		            })
		            .toList();
	}
	
	
	
	

}
