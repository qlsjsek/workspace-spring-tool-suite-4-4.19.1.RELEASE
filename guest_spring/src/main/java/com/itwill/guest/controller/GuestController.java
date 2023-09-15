package com.itwill.guest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
@Controller
public class GuestController {
	@Autowired
	private GuestService guestService;
	public GuestController() {
		System.out.println(">>>GuestController");
	}
	@GetMapping("/guest_main")
	public String guest_main() {
		String forwardPath="";
		//forwardPath="guest_main";
		forwardPath="forward:/WEB-INF/views/guest_main.jsp";
		return forwardPath;
	}
	@GetMapping("/guest_list")
	public String guest_list(Model model) throws Exception {
		List<Guest> guestList=guestService.selectAll();
		model.addAttribute("guestList", guestList);
		return "guest_list";
	}
	/*
	 * parameter 에 guest_no 가존재하지않으면
	 */
	@GetMapping(value="/guest_view",params = "!guest_no")
	public String guest_view() throws Exception {
		return "redirect:guest_main";
	}
	
	/*
	 * parameter 에 guest_no 가존재하면
	 */
	@GetMapping(value="/guest_view",params = "guest_no")
	public String guest_view(@RequestParam int guest_no,Model model) throws Exception {
		Guest guest=guestService.selectByNo(guest_no);
		if(guest==null) {
			model.addAttribute("GUEST_NOT_FOUND_MSG","게시물이 존재하지않습니다." );
			return "guest_view_not_found";
		}
		model.addAttribute("guest", guest);
		return "guest_view";
	}
	@GetMapping("/guest_write_form")
	public String guest_write_form() {
		return "guest_write_form";
	}
	@PostMapping("/guest_write_action")
	public String guest_write_action(@ModelAttribute Guest guest,
									 RedirectAttributes redirectAttributes) throws Exception{
		int guest_no=guestService.insertGuest(guest);
		redirectAttributes.addAttribute("guest_no", guest_no);
		return "redirect:guest_view";
	}
	
	@PostMapping("/guest_remove_action")
	public String guest_remove_action(@RequestParam int guest_no) throws Exception {
		guestService.deleteGuest(guest_no);
		return "redirect:guest_list";
	}
	@PostMapping("/guest_modify_form")
	public String guest_modify_form(@RequestParam int guest_no,Model model) throws Exception{
		Guest guest=guestService.selectByNo(guest_no);
		model.addAttribute("guest", guest);
		return "guest_modify_form";
	}
	@PostMapping("/guest_modify_action")
	public String guest_modify_action(@ModelAttribute Guest guest,
										RedirectAttributes redirectAttributes) 
												throws Exception{
		guestService.updateGuest(guest);
		redirectAttributes.addAttribute("guest_no", guest.getGuest_no());
		return "redirect:guest_view";
	}
	
	@GetMapping(value = {"/guest_write_action","/guest_remove_action"})
	public String guest_get() {
		return "redirect:guest_main";
	}
	
	
	
	
	@ExceptionHandler(Exception.class)
	public String guest_exception_handler(Exception e) {
		return "guest_error";
	}
	
	

}













