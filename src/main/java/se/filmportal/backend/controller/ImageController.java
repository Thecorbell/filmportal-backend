package se.filmportal.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.filmportal.backend.entity.Image;
import se.filmportal.backend.repository.ImageRepository;
import se.filmportal.backend.dto.ImageFilmResponse;
@RestController
@RequestMapping("/api/images")
public class ImageController {
	
	private ImageRepository imageRepository;
	

	public ImageController(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
		
	}
	
	@GetMapping
	public List<Image> getAllImages(){
		return imageRepository.findAll();
	}

	@GetMapping("/{id}")
	public Image getImageById(@PathVariable Long id) {
        return imageRepository.findById(id)
                .orElseThrow();
    }

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Image createImage(@RequestBody Image img) {
		return imageRepository.save(img);
	}

	@PutMapping("/{id}")
	public Image updateImage(
			@PathVariable Long id,
			@RequestBody Image updatedImage) {
		Image img = imageRepository.findById(id).orElseThrow();
		img.setFilmId(updatedImage.getFilmId());
		img.setImageType(updatedImage.getImageType());
		img.setObjectKey(updatedImage.getObjectKey());
		return imageRepository.save(img);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteImage(@PathVariable Long id) {
		imageRepository.deleteById(id);
	}

	@GetMapping("/film/{filmId}")
	public List<ImageFilmResponse> getImageForFilms(
	        @PathVariable Long filmId) {

		List<Image> images = imageRepository.findByFilmId(filmId);
	    return images.stream()
	            .map(img -> {
	               ImageFilmResponse response = new ImageFilmResponse();
	               response.setObjectKey(img.getObjectKey());
	               response.setImageType(img.getImageType());
	               response.setFilmId(img.getFilmId());
	               return response;
	            })
	            .toList();
	}
}

