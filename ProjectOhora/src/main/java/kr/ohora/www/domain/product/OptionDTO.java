package kr.ohora.www.domain.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OptionDTO {


		private int optId;  //opt_id -> optId
		private int pdtId;  //pdt_id  -> pdtId
		private String optName;   // opt_name  -> optName
		private int optAmount;  //  opt_amount  -> optAmount
		private int optCount;    //opt_count   -> optCount

	
}
