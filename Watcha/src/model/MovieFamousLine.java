package model;

public class MovieFamousLine {

	private int movieId;
	private String famousLine;
	
	public MovieFamousLine(int movieId, String famousLine) {
		this.movieId = movieId;
		this.famousLine = famousLine;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getFamousLine() {
		return famousLine;
	}

	public void setFamousLine(String famousLine) {
		this.famousLine = famousLine;
	}
	
}
