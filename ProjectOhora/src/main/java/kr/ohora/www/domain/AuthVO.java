package kr.ohora.www.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthVO {
	
	private int authId; // pk
	private String authName;
	
} // class