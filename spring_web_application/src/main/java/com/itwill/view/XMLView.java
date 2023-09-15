package com.itwill.view;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component("xmlView")
public class XMLView extends AbstractView {
	public XMLView() {
		System.out.println("#### XMLView()생성자");
	}	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			System.out.println(">> renderMergedOutputModel");
			/*********************forward**************************
			 RequestDispatcher rd =request.getRequestDispatcher("xxx.jsp"); 
			 rd.forward(request, response);
			 ********************************************************/
			/*********************redirect************************** 
			 * response.sendRedirect("xxx");
			 ********************************************************/
			List<String>  friendList=(List<String>)model.get("friendList");
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<?xml version='1.0' encoding='UTF-8'?>");
			out.println("<friends>");
			for(String friend:friendList) {
				out.println("<friend>");
				out.println(friend);
				out.println("</friend>");
			}
			out.println("</friends>");
		
	}

}









