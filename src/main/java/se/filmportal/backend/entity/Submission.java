package se.filmportal.backend.entity;


import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "submissions")
public class Submission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="film_id")
	private Long filmId;
	
	@Column(name = "festival_id")
	private Long festivalId;
	
	private String status;
	
	@Column(name = "attending_screening")
	private boolean attendingScreening;
	
	@Column(name = "submitted_at")
    private LocalDateTime createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public Long getFestivalId() {
		return festivalId;
	}

	public void setFestivalId(Long festivalId) {
		this.festivalId = festivalId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isAttendingScreening() {
		return attendingScreening;
	}

	public void setAttendingScreening(boolean attendingScreening) {
		this.attendingScreening = attendingScreening;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	
	
}
