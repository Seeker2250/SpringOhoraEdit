package kr.ohora.www.domain.product;

import lombok.Data;
import lombok.Getter;

@Data
public class ProductSearchDTO {
	private int categoryNumber; // 카테고리 번호
    private int start;          // 페이징 시작 번호
    private int end;            // 페이징 끝 번호
    private String sort;        // 정렬 기준
    private String keyword;     // 검색어
}
