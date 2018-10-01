package model;

import java.time.LocalDateTime;

public class MoviePre {
	private int movieId;
	private String title;
	private int time;
	private LocalDateTime releaseDate;
	private int rate;
	private String shortPlot;
	private String image;
	public MoviePre(int movieId, String title, int time, LocalDateTime releaseDate, int rate, String shortPlot,
			String image) {
		this.movieId = movieId;
		this.title = title;
		this.time = time;
		this.releaseDate = releaseDate;
		this.rate = rate;
		this.shortPlot = shortPlot;
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
	public String getShortPlot() {
		return shortPlot;
	}
	public void setShortPlot(String shortPlot) {
		this.shortPlot = shortPlot;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
