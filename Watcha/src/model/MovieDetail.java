package model;

public class MovieDetail {

	private int movieId;
	private String director;
	private String actor;
	private int genreId;
	private String plot;
	private String trailer;
	
	// 생성자 (1) : 데이터베이스에서 가져오기 위한 생성자
	public MovieDetail(int movieId, String director, String actor, int genreId, String plot, String trailer) {
		this.movieId = movieId;
		this.director = director;
		this.actor = actor;
		this.genreId = genreId;
		this.plot = plot;
		this.trailer = trailer;
	}
	
	// 생성자 (2) : 작성을 위한 생성자
	public MovieDetail(String director, String actor, int genreId, String plot, String trailer) {
		this.director = director;
		this.actor = actor;
		this.genreId = genreId;
		this.plot = plot;
		this.trailer = trailer;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	public String getActor() {
		return actor;
	}
	
	public void setActor(String actor) {
		this.actor = actor;
	}
	
	public int getGenreId() {
		return genreId;
	}
	
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	
	public String getPlot() {
		return plot;
	}
	
	public void setPlot(String plot) {
		this.plot = plot;
	}
	
	public String getTrailer() {
		return trailer;
	}
	
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	
}
