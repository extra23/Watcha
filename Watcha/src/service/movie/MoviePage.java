package service.movie;

import java.util.ArrayList;
import java.util.List;

import model.MoviePre;

public class MoviePage {
	
	// MoviePre 객체의 내용들을 담고 있는 객체들의 목록
	private List<MoviePre> moviePreList = new ArrayList<>();
	// 사용자가 요청한 페이지 번호
	private int currentPage;
	// 전체 페이지 수
	private int totalPages;
	// MoviePre의 전체 갯수
	private int totalMoviePres;
	// 화면 하단에 보여줄 페이지링크의 시작 번호
	private int startPage;
	// 화면 하단에 보여줄 페이지링크의 끝 번호
	private int endPage;
	
	public MoviePage(List<MoviePre> moviePreList, int currentPage, int totalMoviePres, int size, int blockSize) {
			// size : 한 페이지에서 보여줄 게시글의 개수 (9개)
			// blockSize : 한 페이지에서 보여줄 하단 페이지 링크의 블럭 개수 (5개)

		// moviePreList, currentPage, totalMoviePres 초기화
		this.moviePreList = moviePreList;
		this.currentPage = currentPage;
		this.totalMoviePres = totalMoviePres;
		
		// totalPages, startPage, endPage 초기화
		if(totalMoviePres == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		}else {
			
			// totalPages 초기화
			totalPages = totalMoviePres / size;
			if((totalMoviePres%size) > 0) {
				totalPages += 1;
			}
			
			// startPage 초기화
			startPage = (currentPage / blockSize) * blockSize + 1;
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

	public List<MoviePre> getMoviePreList() {
		return moviePreList;
	}

	public void setMoviePreList(List<MoviePre> moviePreList) {
		this.moviePreList = moviePreList;
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

	public int getTotalMoviePres() {
		return totalMoviePres;
	}

	public void setTotalMoviePres(int totalMoviePres) {
		this.totalMoviePres = totalMoviePres;
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
	
	// 페이지가 없을 때 화면을 편하게 출력하기 위한 메소드;
	public boolean hasMoviePres() {
		return totalMoviePres > 0;
	}
	
}
