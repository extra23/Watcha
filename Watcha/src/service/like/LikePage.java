package service.like;

import java.util.ArrayList;
import java.util.List;

import model.WatchaLike;

public class LikePage {
	
	//WatchaLike객체의 내용들을 담고 있는 객체들의 목록
	private List<WatchaLike> likeList = new ArrayList<>();
	//사용자가 요청한 페이지 번호
	private int currentPage;
	//전체 페이지 수
	private int totalPages;
	//WatchaLike의 전체 갯수
	private int totalLikes;
	//화면 하단에 보여줄 페이지링크의 시작 번호
	private int startPage;
	//화면 하단에 보여줄 페이지링크의 끝 번호
	private int endPage;
	public LikePage(List<WatchaLike> likeList, int currentPage, int totalLikes, int size, int blockSize) {
		//size: 한 페이지에서 보여줄 보고싶어요 한 영화의 개수 10개
		//blockSize: 한 페이지
		
		//likeList,currentPage,totalLikes 초기화
		this.likeList = likeList;
		this.currentPage = currentPage;
		this.totalLikes = totalLikes;
		
		//totalPages, startPage, endPage 초기화
		if(totalLikes == 0) {
			totalPages =0;
			startPage = 0;
			endPage = 0;
		}else {
			//totalPages 초기화
			totalPages = totalLikes / size;
			if((totalLikes % size) > 0) {
				totalPages +=1;
			}
			if(currentPage ==1 || currentPage ==2) {
				startPage = (currentPage/blockSize) * blockSize +1;
			}else {
				startPage = currentPage -2;
			}
			if(currentPage == (totalPages -1) || currentPage == totalPages) {
				endPage = totalPages;
			}else if(currentPage ==1 || currentPage ==2) {
				endPage = startPage + blockSize -1;
				if(endPage>totalPages) {
					endPage = totalPages;
				}
			}else {
				endPage = currentPage + 2;
			}
		}
	}
	
	//getter, setter
	public List<WatchaLike> getLikeList() {
		return likeList;
	}
	public void setLikeList(List<WatchaLike> likeList) {
		this.likeList = likeList;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalLikes() {
		return totalLikes;
	}
	public void setTotalLikes(int totalLikes) {
		this.totalLikes = totalLikes;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	//페이지가 없을 때 화면을 편하게 출력하기 위한 메소드;
	public boolean hasLikes() {
		return totalLikes > 0;
	}
	
	
}
