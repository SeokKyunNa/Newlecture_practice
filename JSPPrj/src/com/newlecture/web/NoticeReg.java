package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")		// 서블릿 URL 매핑
public class NoticeReg extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setCharacterEncoding("UTF-8");					// 보내는 출력 형식 지정 (인코딩 타입 지정)
		response.setContentType("text/html; charset=UTF-8");	// 받는 콘텐츠 형식 지정
		
		//request.setCharacterEncoding("UTF-8");					// 입력 형식 지정 (인코딩 타입 지정)
		
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		out.println(title + "<br >");
		out.println(content);
	}
}