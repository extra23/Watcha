package model;

import java.time.LocalDateTime;

public class MoviePre {
	
	private int movieId;
	private String title;
	private int time;
	private LocalDateTime releaseDate;
	private int rate;
	private String famousLine;
	private String image;
	
	public MoviePre(int movieId, String title, int time, LocalDateTime releaseDate, int rate, String famousLine, String image) {
		this.movieId = movieId;
		this.title = title;
		this.time = time;
		this.releaseDate = releaseDate;
		this.rate = rate;
		this.famousLine = famousLine;
		this.image = image;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public LocalDateTime getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDateTime releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getFamousLine() {
		return famousLine;
	}

	public void setFamousLine(String famousLine) {
		this.famousLine = famousLine;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
