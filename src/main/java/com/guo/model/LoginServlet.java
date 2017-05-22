package com.guo.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// check username & password:
		if("admin".equals(username) && "123456".equals(password)) {
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getNamedDispatcher("dispatcher");
			dispatcher.forward(request, response);
		}
		else {
			throw new RuntimeException("Login failed.");
		}
	}
}
