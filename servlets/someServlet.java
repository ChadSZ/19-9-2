package com.powernode.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 对于request的getSession()的用法：
 * 一般情况下，若要向Session中写入数据，则需使用getSession(true)，即getSession()方法。
 * 获取Session对象时，有对象，则使用该对象，若没有则创建新的Session对象。
 * 
 * 而getSession(false)，有Session对象，则使用该对象；若没有，则反回null。
 * Servlet implementation class someServlet
 */
@WebServlet("/someServlet")
public class someServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取用户提交的参数
		String username = request.getParameter("username");
		// 将参数放入request域
		request.setAttribute("user", username);
		// 获取Session对象
		HttpSession session = request.getSession();
		// 向Session域中写入数据
		session.setAttribute("username", username);
		response.getWriter().print("SomeServlet:"+username);
	}

}
