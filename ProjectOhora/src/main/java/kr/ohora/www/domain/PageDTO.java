package kr.ohora.www.domain;

import lombok.Getter;
import lombok.ToString;

// 페이징 블럭 1 2 [3] 4 5 6 7 8 9 10 >
@Getter
@ToString
public class PageDTO {

    private int startPage; // 현재 페이지 그룹의 시작 페이지
    private int endPage;   // 현재 페이지 그룹의 끝 페이지
    private boolean prev;  // 이전 버튼 표시 여부
    private boolean next;  // 다음 버튼 표시 여부

    private int total;     // 전체 데이터 개수
    private int realStartPage;
    private int realEndPage;
    private Criteria criteria; // 현재 페이지 정보 (pageNum, amount)

    public PageDTO(Criteria criteria, int total) {
        this.criteria = criteria;
        this.total = total;

        // 페이지 그룹 크기 (한 번에 보여줄 페이지 수)
        int displayPageCount = 10;

        // 현재 페이지 그룹의 끝 페이지 계산
        this.endPage = (int) (Math.ceil(criteria.getPageNum() / (double) displayPageCount) * displayPageCount);

        // 현재 페이지 그룹의 시작 페이지 계산
        this.startPage = this.endPage - displayPageCount + 1;
        
        this.realStartPage = 1;

        // 전체 페이지 수 계산
        this.realEndPage = (int) Math.ceil((double) total / criteria.getAmount());

        // 실제 마지막 페이지보다 endPage가 크면 조정
        if (realEndPage < this.endPage) {
            this.endPage = realEndPage;
        }

        // 이전, 다음 버튼 표시 여부 설정
        this.prev = this.startPage > 1;
        this.next = this.endPage < realEndPage;
    }
}
