package kr.ohora.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ohora.www.domain.product.ProductDTO;
import kr.ohora.www.persistence.NotUserCartMapper;
import lombok.extern.log4j.Log4j;
@Log4j
@Service
public class NotUserCartServiceImpl implements NotUserCartService{
	
	@Autowired
	private NotUserCartMapper notUserCartMapper;

	@Override
	public List<ProductDTO> getProductsByIds(List<Integer> productIds) {
		// TODO Auto-generated method stub
		return notUserCartMapper.pdtsFromIds(productIds);
	}
}
