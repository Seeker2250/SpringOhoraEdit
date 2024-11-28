package kr.ohora.www.domain.product;

import lombok.Data;
import lombok.Getter;

@Data
public class ProductSearchDTO {
    private int start;
    private int end;
    private int categoryNumber;
}
