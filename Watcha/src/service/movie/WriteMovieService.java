package service.movie;

public class WriteMovieService {
	
	// 싱글톤
	private static WriteMovieService instance = new WriteMovieService();
	private WriteMovieService() {};
	public static WriteMovieService getInstance() {
		return instance;
	}
	


}
