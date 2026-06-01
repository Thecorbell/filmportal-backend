package se.filmportal.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*; 

@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "alternative_title")
    private String alternativeTitle;

    private String genre;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    private String language;

    @Column(name = "subtitle_language")
    private String subtitleLanguage;

    private String logline;

    private String summary;

    @Column(name = "ai_used")
    private Boolean aiUsed;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Getters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAlternativeTitle() {
        return alternativeTitle;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public String getLanguage() {
        return language;
    }

    public String getSubtitleLanguage() {
        return subtitleLanguage;
    }

    public String getLogline() {
        return logline;
    }

    public String getSummary() {
        return summary;
    }

    public Boolean getAiUsed() {
        return aiUsed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAlternativeTitle(String alternativeTitle) {
        this.alternativeTitle = alternativeTitle;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setSubtitleLanguage(String subtitleLanguage) {
        this.subtitleLanguage = subtitleLanguage;
    }

    public void setLogline(String logline) {
        this.logline = logline;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setAiUsed(Boolean aiUsed) {
        this.aiUsed = aiUsed;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}