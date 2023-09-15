package com.itwill.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SpringModelController {
	@RequestMapping("/model_request")
	public String request(HttpServletRequest request) {
		request.setAttribute("req","리퀘스트데이타");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_model")
	public String model(Model model) {
		//System.out.println("### model:"+model.getClass().getSimpleName());
		model.addAttribute("model", "모델데이타");
		/*
		request.setAttribute("model","모델데이타");
		 */
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_map")
	public String map(Map map){
		map.put("map", "맵데이타");
		/*
		request.setAttribute("map","맵데이타");
		 */
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_modelmap")
	public String modelmap(ModelMap modelMap) {
		modelMap.addAttribute("modelmap", "모델맵데이타");
		/*
		request.setAttribute("modelmap","모델맵데이타");
		 */
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_modelandview")
	public ModelAndView modelandview() {
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.setViewName("forward:/WEB-INF/views/spring_model.jsp");
		modelAndView.addObject("modelandview","모델앤드뷰데이타" );
		return modelAndView;
	}
	@RequestMapping("/model_all")
	public String model_all(HttpServletRequest request,Model model,Map map,ModelMap modelMap){
		request.setAttribute("req","리퀘스트데이타");
		model.addAttribute("model", "모델데이타");
		map.put("map", "맵데이타");
		modelMap.addAttribute("modelmap", "모델맵데이타");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
}












