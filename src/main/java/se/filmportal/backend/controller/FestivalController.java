package se.filmportal.backend.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import se.filmportal.backend.entity.Festival;
import se.filmportal.backend.entity.Submission;
import se.filmportal.backend.repository.FestivalRepository;
import se.filmportal.backend.dto.FestivalResponse;


@RestController
@RequestMapping("/api/festival")
public class FestivalController {
	private FestivalRepository festivalRepository;
	
	public FestivalController(FestivalRepository festivalRepository) {
		this.festivalRepository = festivalRepository;
	}
	
	@GetMapping
	public List<Festival> findAllFestivals(){
		return festivalRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Festival getFestivalById(@PathVariable Long Id) {
		return festivalRepository.findById(Id).orElseThrow();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Festival createFestival(@RequestBody Festival festival) {
		return festivalRepository.save(festival);
	}

	@PutMapping("/{id}")
	public Festival updateFestival(@PathVariable Long Id, @RequestBody Festival updatedFestival ) {
		Festival festival = festivalRepository.findById(Id).orElseThrow();
	    festival.setName(updatedFestival.getName());
	    festival.setCountry(updatedFestival.getCountry());
	    festival.setCity(updatedFestival.getCity());
	    festival.setStartDate(updatedFestival.getStartDate());
	    festival.setEndDate(updatedFestival.getEndDate());
	    festival.setWebsite(updatedFestival.getWebsite());
	    festival.setEmail(updatedFestival.getEmail());
	    festival.setStatus(updatedFestival.getStatus());

	    return festivalRepository.save(festival);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteFestival(@PathVariable Long id) {
		festivalRepository.deleteById(id);
	}
}
