package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")		// ���� URL ����
public class NoticeReg extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setCharacterEncoding("UTF-8");					// ������ ��� ���� ���� (���ڵ� Ÿ�� ����)
		response.setContentType("text/html; charset=UTF-8");	// �޴� ������ ���� ����
		
		//request.setCharacterEncoding("UTF-8");					// �Է� ���� ���� (���ڵ� Ÿ�� ����)
		
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		out.println(title + "<br >");
		out.println(content);
	}
}