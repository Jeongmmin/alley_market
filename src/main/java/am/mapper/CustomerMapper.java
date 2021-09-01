package am.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import am.dto.OrdersDto;
import am.dto.ProductDto;
import am.dto.ProductFileDto;
import am.dto.ProductInfoDto;
import am.dto.QnaDto;
import am.dto.ReviewDto;

@Mapper
public interface CustomerMapper {
	
//	메인페이지 불러오기
//	List<ProductDto> productMainPage() throws Exception;
	List<ProductInfoDto> productInfoMainPage() throws Exception;
	
//	사진파일 불러오기 
	List<ProductFileDto> productFileMainPage() throws Exception;
	void vueInsertBoard(ProductDto board) throws Exception;

//	상품 상세페이지 불러오기
	ProductDto productDetail(int productPk) throws Exception;
	
//	리뷰보기
	List<ReviewDto> reviewRead(@Param("productPk") int productPk) throws Exception;

//	문의 보기
	List<QnaDto> qnaRead(@Param("productPk") int productPk) throws Exception;
	
//	문의 상세 보기
	QnaDto qnaDetail(int qnaPk) throws Exception;
		
//	문의 등록
	void qnaInsert(QnaDto qna) throws Exception;
	
//	문의 답변하기(관리자)
	void answerUpdate(QnaDto qna) throws Exception;
	
//	주문하기 - 상품정보 불러오기
	List<ProductDto> orderProduct(@Param("customerPk") int customerPk) throws Exception;

//	주문하기 - 주문입력
	void orderInsert(OrdersDto order) throws Exception;
	void orderDetailUpdate(OrdersDto order) throws Exception;
	
//	장바구니에 담기
	void cartInsert(OrdersDto cart) throws Exception;
	
//	장바구니 불러오기
	List<ProductDto> cartList(@Param("customerPk") int customerPk) throws Exception;
	
//	마이페이지 - 주문내역
	List<OrdersDto> myPageOrder(@Param("customerPk") int customerPk) throws Exception;
}
