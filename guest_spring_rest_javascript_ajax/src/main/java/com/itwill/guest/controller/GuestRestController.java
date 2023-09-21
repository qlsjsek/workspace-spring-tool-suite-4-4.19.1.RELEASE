package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
   /*
	1. GET    - /guests : 모든 데이터를 요청한다.
	2. POST   - /guests : 데이터를 추가한다.
	3. GET    - /guests/{n} : n번째 데이터를 요청한다.
	4. PUT    - /guests/{n} : n번째 데이터를 수정한다.
	5. DELETE - /guests/{n} : n번째 데이터를 제거한다.
	*/

@RestController
public class GuestRestController {
	@Autowired
	private GuestService guestService;
	@GetMapping(value = "/guests",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,Object> guest_list()throws Exception{
		Map<String, Object> resultMap=new HashMap<String, Object>();
		int status=1;
		String msg="성공";
		List<Guest> data=new ArrayList<Guest>();
		
		data=guestService.selectAll();
		
		resultMap.put("status", status);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
	}
	@GetMapping(value = "/guests/{guest_no}")
	public Map<String,Object> guest_detail(@PathVariable(value = "guest_no") int guest_no )throws Exception{
		Map<String, Object> resultMap=new HashMap<String, Object>();
		int status=1;
		String msg="성공";
		List<Guest> data=new ArrayList<Guest>();
		
		Guest guest=guestService.selectByNo(guest_no);
		if (guest!=null) {
			data.add(guest);
		}else {
			status=2;
			msg="게시물이 존재하지 않습니다.";
		}
	
		resultMap.put("status", status);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
	}
	
	@PostMapping(value = "/guests",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,Object> guest_write_action(@RequestBody Guest guest){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		int status=1;
		String msg="성공";
		List<Guest> data=new ArrayList<Guest>();
		try {
			int insert_guest_no=guestService.insertGuest(guest);
			status=1;
			msg="성공";
			Guest newGuest=guestService.selectByNo(insert_guest_no);
			data.add(newGuest);
		} catch (Exception e) {
			status=2;
			msg="방명록쓰기실패";
			e.printStackTrace();
		}
		
		resultMap.put("status", status);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	@Operation(summary = "방명록수정",description = "전송되는 아이디에 해당하는 게시물수정")	
	@Parameter(name = "guest_no",description = "방명록의 번호")
	@PutMapping(value = "/guests/{guest_no}")
	public Map<String,Object> guest_modify_action(@PathVariable("guest_no") int guest_no, @RequestBody Guest guest)throws Exception{
		Map<String, Object> resultMap=new HashMap<String, Object>();
		int status=1;
		String msg="성공";
		List<Guest> data=new ArrayList<Guest>();
		
		guest.setGuest_no(guest_no);
		guestService.updateGuest(guest);
		data.add(guest);
		
		resultMap.put("status", status);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
	}
	@DeleteMapping(value = "/guests/{guest_no}")
	public Map<String,Object> guest_remove_action(@PathVariable(value = "guest_no") int guest_no){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		int status=1;
		String msg="성공";
		List<Guest> data=new ArrayList<Guest>();
		
		try {
			guestService.deleteGuest(guest_no);
			status=1;
			msg="";
		} catch (Exception e) {
			e.printStackTrace();
			status=2;
			msg="방명록삭제실패";
		}
		
		resultMap.put("status", status);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
	@ExceptionHandler(Exception.class)
	public Map<String, Object> exceptionHandler(Exception e){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		int status=3;
		String msg="알수없는예외";
		List data=new ArrayList();
		data.add(e.getMessage());
		
		resultMap.put("status", status);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
	
	
}

