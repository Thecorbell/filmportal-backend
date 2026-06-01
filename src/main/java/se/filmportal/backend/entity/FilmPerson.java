package se.filmportal.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "film_persons")
public class FilmPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "person_id")
    private Long personId;

    private String role;

    public Long getId() {
        return id;
    }

    public Long getFilmId() {
        return filmId;
    }

    public Long getPersonId() {
        return personId;
    }

    public String getRole() {
        return role;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setRole(String role) {
        this.role = role;
    }
}