package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		
		System.out.println("title : ");
		System.out.println(title);
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");
		boolean pub = false;
		if(isOpen != null) {
			pub = true;
		}
		
		Notice notice = new Notice();
		
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);
		notice.setWriterId("engsk");
		
		NoticeService service = new NoticeService();
		service.insertNotice(notice);
		
		/* 출력 시 (response) 한글 처리 */
		/*response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html); charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.printf("title : %s<br >", title);
		out.printf("content : %s<br >", content);
		out.printf("isOpen : %s<br >", isOpen);
		*/
		
		response.sendRedirect("list");
	}
}
