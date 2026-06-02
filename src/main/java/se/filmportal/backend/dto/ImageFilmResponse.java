package se.filmportal.backend.dto;

public class ImageFilmResponse {
	private Long filmId;
	private String objectKey;
	private String imageType;
	public Long getFilmId() {
		return filmId;
	}
	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}
	public String getObjectKey() {
		return objectKey;
	}
	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	

}
