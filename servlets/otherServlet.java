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
		// 从request域中读取user属性
		String user = request.getParameter("username");
		// 获取Session
		HttpSession session = request.getSession();
		// 从Session中读取指定属性
		String username = null;
		if(session != null){
			username = (String) session.getAttribute("username");
		}
		response.getWriter().print("otherServlet:"+username);
	}

}
