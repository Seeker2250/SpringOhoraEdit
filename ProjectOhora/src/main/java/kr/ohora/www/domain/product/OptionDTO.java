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


		private int opt_id;
		private int pdt_id;
		private String opt_name;
		private int opt_amount;
		private int opt_count;

	
}
