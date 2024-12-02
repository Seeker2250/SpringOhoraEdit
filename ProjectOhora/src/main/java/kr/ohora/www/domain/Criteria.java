package kr.ohora.www.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Criteria : 페이징 기준, 척도
@Getter
@Setter
@ToString
public class Criteria {

	private int pageNum;        // 현재 페이지 번호
    private int amount;         // 페이지당 항목 수
    private String sort;        // 정렬 기준
    private String keyword;     // 검색어
	
	 public Criteria() {
	      this(1,12);
	   }   

	   public Criteria(int pageNum, int amount) {
	      super();
	      this.pageNum = pageNum;
	      this.amount = amount;
	   }
	
	   // ?pageNum=2&amount=10&type=keyword=홍길동&....
	   // org.springframwork.web.util.
	   // 	ㄴ UriComponentsBuilder
	   public String getListLink() {
		    UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
		                                .queryParam("pageNum", this.pageNum)
		                                .queryParam("amount", this.amount);
		    return builder.toUriString();
		}
	
	
}// class
