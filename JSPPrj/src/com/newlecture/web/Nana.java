package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")		// 서블릿 URL 매핑
public class Nana extends HttpServlet{

	/*
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("Hello~~~!! NSK");
	}
	*/
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setCharacterEncoding("UTF-8");					// 보내는 출력 형식 지정 (인코딩 타입 지정)
		response.setContentType("text/html; charset=UTF-8");	// 받는 콘텐츠 형식 지정
		
		PrintWriter out = response.getWriter();
		
		int cnt = Integer.parseInt(request.getParameter("cnt"));	// getParameter는 무조건 문자열로 입력되므로 상황에 맞게 캐스팅 필요
		
		for(int i = 0; i < cnt; i++) {
			out.println((i + 1) + " : 안녕 Servlet!!<br />");
		}
	}
}