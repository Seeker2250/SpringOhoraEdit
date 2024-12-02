package kr.ohora.www.domain.review;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewRating {
	private double avgRating;
	
	private int count5;
	private int count4;
	private int count3;
	private int count2;
	private int count1;
}
