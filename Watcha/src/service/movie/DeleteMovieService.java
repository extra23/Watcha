package service.movie;

public class DeleteMovieService {
	
	// 싱글톤 패턴 사용
	private static DeleteMovieService instance = new DeleteMovieService();
	private DeleteMovieService() {}
	public static DeleteMovieService getInstance() {
		return instance;
	}

}
