package com.itwill0.context;

import com.itwill.guest.GuestDaoImpl;
import com.itwill.guest.GuestServiceImpl;
import com.itwill.order.OrderServiceImpl;
import com.itwill.user.UserServiceImpl;

public class JavaApplicationMain {

	public static void main(String[] args)throws Exception {
		GuestDaoImpl guestDaoImpl=new GuestDaoImpl();
		GuestServiceImpl guestServiceImpl=new GuestServiceImpl(guestDaoImpl);
		System.out.println(guestServiceImpl.selectAll());
		System.out.println(guestServiceImpl.selectByNo(1));
		
	}

}










