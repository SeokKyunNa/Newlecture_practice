package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html); charset=UTF-8");
		/*
		PrintWriter out = response.getWriter();
		
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		
		int x = 0, y = 0;
		
		if(x_==null||x_.equals("")) {
			x = 0;
		} else {
			x = Integer.parseInt(x_);
		}
		
		if(y_==null||y_.equals("")) {
			y = 0;
		} else {
			y = Integer.parseInt(y_);
		}
		
		int sum = x + y;
		
		out.print(x + " + " + y + " = ");
		out.print(sum);
		*/
		
		/* Newlec Version */
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		
		int x = 0, y = 0;
		
		if(!x_.equals("")) x = Integer.parseInt(x_);
		if(!y_.equals("")) y = Integer.parseInt(y_);
		
		int result = x + y;
		
		response.getWriter().printf("result is %d\n", result);
		
	}

}
