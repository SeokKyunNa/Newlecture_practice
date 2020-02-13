package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext application = request.getServletContext();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html); charset=UTF-8");
		
		String v_ = request.getParameter("v");
		String op_ = request.getParameter("operator");
		
		int v = 0;
		
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		// 계산
		if(op_.equals("=")) {
			int x = (Integer)application.getAttribute("value");
			int y = v;
			String op = (String)application.getAttribute("op");
			int result = 0;
			
			if(op.equals("+")) {
				result = x + y;
			} else if(op.equals("-")){
				result = x - y; 
			}
			
			response.getWriter().printf("result is %d\n", result);
		// 값을 저장
		} else {
			application.setAttribute("value", v);
			application.setAttribute("op", op_);
		}
		
	}

}
