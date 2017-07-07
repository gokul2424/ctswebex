package com.cog;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cog.model.User;


@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		
		User user = new User(email,pwd);
		
		UserService service = new UserService();
		boolean isAuthenticated = service.authenticate(user);	
		System.out.println("Authenticated: " + isAuthenticated);
		if(isAuthenticated){
			
			req.setAttribute("user", user);
			RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
			rd.forward(req, response);
		}
		
	}

}
