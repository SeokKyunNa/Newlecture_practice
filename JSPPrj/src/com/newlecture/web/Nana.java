package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")		// ���� URL ����
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
		
		response.setCharacterEncoding("UTF-8");					// ������ ��� ���� ���� (���ڵ� Ÿ�� ����)
		response.setContentType("text/html; charset=UTF-8");	// �޴� ������ ���� ����
		
		PrintWriter out = response.getWriter();
		
		int cnt = Integer.parseInt(request.getParameter("cnt"));	// getParameter�� ������ ���ڿ��� �ԷµǹǷ� ��Ȳ�� �°� ĳ���� �ʿ�
		
		for(int i = 0; i < cnt; i++) {
			out.println((i + 1) + " : �ȳ� Servlet!!<br />");
		}
	}
}