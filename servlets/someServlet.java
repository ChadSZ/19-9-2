package com.powernode.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ����request��getSession()���÷���
 * һ������£���Ҫ��Session��д�����ݣ�����ʹ��getSession(true)����getSession()������
 * ��ȡSession����ʱ���ж�����ʹ�øö�����û���򴴽��µ�Session����
 * 
 * ��getSession(false)����Session������ʹ�øö�����û�У��򷴻�null��
 * Servlet implementation class someServlet
 */
@WebServlet("/someServlet")
public class someServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ�û��ύ�Ĳ���
		String username = request.getParameter("username");
		// ����������request��
		request.setAttribute("user", username);
		// ��ȡSession����
		HttpSession session = request.getSession();
		// ��Session����д������
		session.setAttribute("username", username);
		response.getWriter().print("SomeServlet:"+username);
	}

}
