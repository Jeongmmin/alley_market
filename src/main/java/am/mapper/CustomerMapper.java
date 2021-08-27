package am.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import am.dto.OrdersDto;
import am.dto.ProductDto;
import am.dto.QnaDto;
import am.dto.ReviewDto;

@Mapper
public interface CustomerMapper {
	
	//	메인페이지 불러오기
	List<ProductDto> productMainPage() throws Exception;
//	
//	void vueInsertBoard(ProductDto board) throws Exception;
//
//	//상세페이지 확인하기
//	ProductDto vueSelectDetailBoard(int productPk) throws Exception;
	
//	리뷰보기
	List<ReviewDto> reviewRead(@Param("productPk") int productPk) throws Exception;

//	문의 보기
	List<QnaDto> qnaRead(@Param("productPk") int productPk) throws Exception;
	
//	문의 등록
	void qnaInsert(QnaDto qna) throws Exception;
	
//	주문하기 - 상품정보 불러오기
	List<ProductDto> orderProduct(@Param("orderPk") int orderPk) throws Exception;

//	주문하기 - 주문입력
	void orderInsert(OrdersDto order) throws Exception;
}
