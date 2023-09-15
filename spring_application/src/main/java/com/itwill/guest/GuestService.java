package com.itwill.guest;

import java.util.List;

public interface GuestService {
	List<Guest> selectAll() throws Exception;
	Guest selectByNo(int no) throws Exception;
}
