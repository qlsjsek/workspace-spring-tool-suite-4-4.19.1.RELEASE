package com.itwill.guest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class GuestDaoImpl implements GuestDao{
	
	public GuestDaoImpl() {
		System.out.println("#### GuestDaoImpl()기본생성자호출");
	}
	@Override
	public List<Guest> selectAll() throws Exception {
		System.out.println("#### GuestDaoImpl.selectAll()메쏘드호출");
		List<Guest> guestList=new ArrayList<Guest>();
		guestList.add(new Guest(1,"KIM"));
		guestList.add(new Guest(2,"LEE"));
		guestList.add(new Guest(3,"LIM"));
		return guestList;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		System.out.println("#### GuestDaoImpl.selectByNo("+no+")메쏘드호출");
		return new Guest(1,"KIM");
	}

}
