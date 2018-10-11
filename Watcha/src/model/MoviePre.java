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
	private String searchWord2;
	private String searchWord3;
	
	// 생성자 (1) : 데이터 베이스에서 읽어올 때 필요한 생성자
	public MoviePre(int movieId, String title, int genreId, int time, String releaseDate, int rate, String famousLine, String imageName, String searchWord1, String searchWord2, String searchWord3) {
		this.movieId = movieId;
		this.title = title;
		this.genreId = genreId;
		this.time = time;
		this.releaseDate = releaseDate;
		this.rate = rate;
		this.famousLine = famousLine;
		this.imageName = imageName;
		this.searchWord1 = searchWord1;
		this.searchWord2 = searchWord2;
		this.searchWord3 = searchWord3;
	}
	
	// 생성자 (2) : 작성을 위한 생성자
	public MoviePre(String title, int genreId, int time, String releaseDate, int rate, String famousLine, String imageName, String searchWord1, String searchWord2, String searchWord3) {
		this.title = title;
		this.genreId = genreId;
		this.time = time;
		this.releaseDate = releaseDate;
		this.rate = rate;
		this.famousLine = famousLine;
		this.imageName = imageName;
		this.searchWord1 = searchWord1;
		this.searchWord2 = searchWord2;
		this.searchWord3 = searchWord3;
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

	public String getSearchWord1() {
		return searchWord1;
	}

	public void setSearchWord1(String searchWord1) {
		this.searchWord1 = searchWord1;
	}

	public String getSearchWord2() {
		return searchWord2;
	}

	public void setSearchWord2(String searchWord2) {
		this.searchWord2 = searchWord2;
	}

	public String getSearchWord3() {
		return searchWord3;
	}

	public void setSearchWord3(String searchWord3) {
		this.searchWord3 = searchWord3;
	}

}
