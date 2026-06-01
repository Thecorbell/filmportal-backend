package se.filmportal.backend.dto;

public class PersonFilmResponse {

    private String title;
    private String role;
    private Long filmId;

    public String getTitle() {
        return title;
    }

    public String getRole() {
        return role;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRole(String role) {
        this.role = role;
    }

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}
}