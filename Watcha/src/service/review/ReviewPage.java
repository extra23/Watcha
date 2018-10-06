package service.review;

import java.util.ArrayList;
import java.util.List;

import model.WatchaReview;

public class ReviewPage {

	//watchaReview 객체의 내용들을 담고 잇는 객체들의 목록
	private List<WatchaReview> reviewList = new ArrayList<>();
	// 사용자가 요청한 페이지 번호
	private int currentPage;
	// 전체 페이지 수
	private int totalPages;
	//review의 전체 갯수
	private int totalReviews;
	// 화면 하단에 보여줄 페이지링크의 시작 번호
	private int startPage;
	// 화면 하단에 보여줄 페이지링크의 끝 번호
	private int endPage;
	
	public ReviewPage(List<WatchaReview> reviewList, int currentPage, int  totalReviews, int size, int blockSize) {
		//size: 한 페이지에서 볻여줄 리뷰의 개수(3)
		//blockSize: 한 페이지에서 보여줄 하단 페이지 링크의 블럭 개수(5)
		
		//reviewList, currentPage, totalReivews 초기화
		this.reviewList = reviewList;
		this.currentPage = currentPage;
		this.totalReviews = totalReviews;
		
		//totalPages, startPage,endPage 초기화
		if(totalReviews == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		}else {
			
			//totalPages 초기화
			totalPages = totalReviews / size;
			if(totalReviews % size > 0) {
				totalPages += 1;
			}
			
			//startPage 초기화
			startPage = (currentPage / blockSize)*blockSize +1;
			if((currentPage%blockSize) == 0) {
				startPage -= 1;
			}
			
			// endPage 초기화
			endPage = startPage + blockSize - 1;
			if(endPage > totalPages) {
				endPage = totalPages;
			}
		}
		
	}

	public List<WatchaReview> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<WatchaReview> reviewList) {
		this.reviewList = reviewList;
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

	public int getTotalReviews() {
		return totalReviews;
	}

	public void setTotalReviews(int totalReviews) {
		this.totalReviews = totalReviews;
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
	
	//페이지가 없을 때 화면을 편하게 출력하기 위한 메소드
	public boolean hasReviews() {
		return totalReviews > 0;
	}
	
}
