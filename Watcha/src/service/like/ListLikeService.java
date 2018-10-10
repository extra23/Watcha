package service.like;

public class ListLikeService {
	
	//싱글톤
	private static ListLikeService instance = new ListLikeService();
	private ListLikeService () {}
	public static ListLikeService getInstance() {
		return instance;
	}
	
	
}
