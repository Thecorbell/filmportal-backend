package se.filmportal.backend.dto;

public class SubmissionResponse {

	private Long submissionId;

	private String filmTitle;

	private String festivalName;

	private String status;

	private boolean attendingScreening;

	public Long getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(Long submissionId) {
		this.submissionId = submissionId;
	}

	public String getFilmTitle() {
		return filmTitle;
	}

	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}

	public String getFestivalName() {
		return festivalName;
	}

	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
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
}
