package com.powernode.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class otherServlet
 */
@WebServlet("/otherServlet")
public class otherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��request���ж�ȡuser����
		String user = request.getParameter("username");
		// ��ȡSession
		HttpSession session = request.getSession();
		// ��Session�ж�ȡָ������
		String username = null;
		if(session != null){
			username = (String) session.getAttribute("username");
		}
		response.getWriter().print("otherServlet:"+username);
	}

}
