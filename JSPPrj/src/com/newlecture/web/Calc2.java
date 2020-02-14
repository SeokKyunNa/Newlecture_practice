package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		// 계산
		if(op.equals("=")) {
			//int x = (Integer)application.getAttribute("value");
			//int x = (Integer)session.getAttribute("value");
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().contentEquals("value")){
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			
			int y = v;
			//String operator = (String)application.getAttribute("operator");
			//String operator = (String)session.getAttribute("operator");
			
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().contentEquals("op")){
					operator = c.getValue();
					break;
				}
			}
			int result = 0;
			
			if(operator.equals("+")) {
				result = x + y;
			} else if(operator.equals("-")){
				result = x - y; 
			}
			
			response.getWriter().printf("result is %d\n", result);
		// 값을 저장
		} else {
			//application.setAttribute("value", v);
			//application.setAttribute("operator", op);
			
			//session.setAttribute("value", v);
			//session.setAttribute("operator", op);
			
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			valueCookie.setPath("/calc2");
			valueCookie.setMaxAge(24*60*60);	// cookie 만료 날짜
			opCookie.setPath("/calc2");
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("calc2.html");
		}
		
	}

}
