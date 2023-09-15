package com.itwill.guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("guestService")
public class GuestServiceImpl implements GuestService{
	
	private GuestDao guestDao;
	
	public GuestServiceImpl() {
		System.out.println("#### GuestServiceImpl()기본생성자호출");
		
	}
	@Autowired
	public GuestServiceImpl(GuestDao guestDao) {
		System.out.println("#### GuestServiceImpl("+guestDao+")생성자호출");
		this.guestDao=guestDao;
	}

	public void setGuestDao(GuestDao guestDao) {
		System.out.println("#### GuestServiceImpl.setGuestDao("+guestDao+")메쏘드호출");
		this.guestDao = guestDao;
	}
	@Override
	public List<Guest> selectAll() throws Exception {
		System.out.println("#### GuestSeriveImpl.selectAll()메쏘드호출");
		List<Guest> guestList=guestDao.selectAll();
		return guestList;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		System.out.println("#### GuestSeriveImpl.selectByNo("+no+")메쏘드호출");
		return guestDao.selectByNo(no);
	}

}
