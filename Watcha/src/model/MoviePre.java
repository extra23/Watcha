package model;

public class MoviePre {
	
	private int movieId;
	private String title;
	private int genreId;
	private int time;
	private String releaseDate;
	private int rate;
	private String famousLine;
	private String imageName;
	private String searchWord1;
	
	// 생성자 (1) : 데이터 베이스에서 읽어올 때 필요한 생성자
	public MoviePre(int movieId, String title, int genreId, int time, String releaseDate, int rate, String famousLine, String imageName) {
		this.movieId = movieId;
		this.title = title;
		this.time = time;
		this.releaseDate = releaseDate;
		this.rate = rate;
		this.famousLine = famousLine;
		this.imageName = imageName;
	}
	
	// 생성자 (2) : 작성을 위한 생성자
	public MoviePre(String title, int genreId, int time, String releaseDate, int rate, String famousLine, String imageName) {
		this.title = title;
		this.genreId = genreId;
		this.time = time;
		this.releaseDate = releaseDate;
		this.rate = rate;
		this.famousLine = famousLine;
		this.imageName = imageName;
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

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}
