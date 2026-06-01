package se.filmportal.backend.dto;

public class FilmPersonResponse {

    private String name;
    private String role;
    private Long personId;

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

	
}