package am.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import am.common.AmBoardFileUtils;
import am.common.AmFileUtils;
import am.dto.BoardFileDto;
import am.dto.CustomersDto;
import am.dto.NoticeDto;
import am.dto.OrdersDto;
import am.dto.ProductDto;
import am.dto.ProductFileDto;
import am.dto.QnaDto;
import am.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper adMapper;
	
	@Autowired
	private AmFileUtils amFileUtils;
	
	@Autowired
	private AmBoardFileUtils amboardFileUtils;
	
//	관리자 메인페이지 불러오기
	@Override
	public List<OrdersDto> adminMainPage() throws Exception {
		return adMapper.adminMainPage();
	}
	
////	회원관리 페이지 불러오기(수정전)
//	@Override
//	public List<CustomersDto> SelectCustomerList() throws Exception {
//		return adMapper.SelectCustomerList();
//	}

	//회원관리 페이지 불러오기에 페이징추가
	 @Override
	 public Page<CustomersDto> getCusList(int pageNo) throws Exception {
	     PageHelper.startPage(pageNo, 10);
	     return adMapper.SelectCustomerList();
	 }	
	
////	공지사항 리스트 불러오기(수정전)
//	@Override
//	public List<NoticeDto> SelectNoticeBoardList() throws Exception {
//		return adMapper.SelectNoticeBoardList();
//	}
	
//	공지사항 리스트 불러오기에 페이징 추가
	@Override
	public Page<NoticeDto> getNotiList(int pageNo) throws Exception {
	     PageHelper.startPage(pageNo, 10);
	     return adMapper.SelectNoticeBoardList();	
	}
	
//	공지사항 작성하기
	@Override
	public void NoticeWrite(NoticeDto notice, MultipartHttpServletRequest mhsr) throws Exception {
		adMapper.NoticeWrite(notice);
		List<BoardFileDto> list = amboardFileUtils.parseFileInfo(notice.getBoardCategoryPk(), notice.getNoticePk(), mhsr);
		
		if (CollectionUtils.isEmpty(list) == false) {
			adMapper.boardImageInsert(list);
		}
	}
	
//	공지사항 상세내용 확인하기
	@Override
	public NoticeDto NoticeDetail(int noticePk) throws Exception {
		return adMapper.NoticeDetail(noticePk);
	}
	
//	공지사항 상세내용 수정하기
	@Override
	public void noticeUpdate(NoticeDto noticeupdate, MultipartHttpServletRequest mhsr) throws Exception {
		adMapper.noticeUpdate(noticeupdate);
		List<BoardFileDto> list = amboardFileUtils.parseFileInfo(noticeupdate.getBoardCategoryPk(), noticeupdate.getNoticePk(), mhsr);
		
		if (CollectionUtils.isEmpty(list) == false) {
			adMapper.boardImageInsert(list);
		}
	}
	
//	공지사항 상세내용 삭제하기
	@Override
	   public void noticeDelete(int noticePk) throws Exception {
		adMapper.noticeDelete(noticePk);
	 }
	
//	상품재고 목록 확인하기(수정전)
//	@Override
//	public List<ProductDto> SelectStockList(int boardIdx) throws Exception {
//		return adMapper.SelectStockList(boardIdx);
//	}
	
//	상품재고 목록 확인하기 + 페이징추가
	@Override
	public Page<ProductDto> SelectStockList(int pageNo) throws Exception {
	     PageHelper.startPage(pageNo, 10);
		return adMapper.SelectStockList();
	}
	
//	상품정보 + 이미지 등록하기 + 재고에 productPk 추가하기
	@Override
	public void ProductInsert(ProductDto productIn, MultipartHttpServletRequest mhsr) throws Exception {
		adMapper.ProductInsert(productIn);
		adMapper.productStockInsert(productIn);
		List<ProductFileDto> list = amFileUtils.parseFileInfo(productIn.getProductPk(), mhsr);
		
		if (CollectionUtils.isEmpty(list) == false) {
			adMapper.productFileInsert(list);
		}
	}
	
//	관리자 문의리스트 불러오기(수정전)
//	@Override
//	public List<QnaDto> qnaList() throws Exception {
//		return adMapper.qnaList();
//	}
	
//	관리자 문의리스트 불러오기 + 페이징추가
	@Override
	public Page<QnaDto> getqnaList(int pageNo) throws Exception {
	     PageHelper.startPage(pageNo, 10);
		return adMapper.SelectqnaList();
	}
}
