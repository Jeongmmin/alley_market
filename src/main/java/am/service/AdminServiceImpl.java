package am.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import am.dto.OrdersDto;
import am.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper adMapper;
	
//	관리자 메인페이지 불러오기
	public List<OrdersDto> adminMainPage() throws Exception {
		return adMapper.adminMainPage();
	}
}
