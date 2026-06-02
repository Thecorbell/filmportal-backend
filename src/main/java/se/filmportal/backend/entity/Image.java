package se.filmportal.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "images")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "film_id")
    private Long filmId;
	
	@Column(name = "image_type")
	private String imageType;
	
	@Column(name = "object_key")
	private String objectKey;
	
	
	@Column(name = "created_at")
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


	public String getImageType() {
		return imageType;
	}


	public void setImageType(String imageType) {
		this.imageType = imageType;
	}


	public String getObjectKey() {
		return objectKey;
	}


	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}
