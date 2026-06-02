package se.filmportal.backend.dto;



public class FilmFileResponse {

	private Long filmid;
	
	private String objectKey;
	
	private String fileName;
	
	private int fileSize;

	public Long getFilmid() {
		return filmid;
	}

	public void setFilmid(Long filmid) {
		this.filmid = filmid;
	}

	public String getObjectKey() {
		return objectKey;
	}

	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

}
