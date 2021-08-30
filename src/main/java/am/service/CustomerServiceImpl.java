package am.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import am.dto.ProductDto;
import am.dto.ProductInfoDto;
import am.mapper.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerMapper cusMapper;
	
	@Override
	public List<ProductInfoDto> productInfoMainPage() throws Exception {
//		return cusMapper.productMainPage();
		return cusMapper.productInfoMainPage();
	}
	
//	
	@Override
	public void vueInsertBoard(ProductDto board) throws Exception {
		cusMapper.vueInsertBoard(board);
	}
	
//	상세페이지 데이터 가져오기
	@Override
	public ProductDto productDetailBoard(int productPk) throws Exception{
		return cusMapper.productDetailBoard(productPk);
	}
}
