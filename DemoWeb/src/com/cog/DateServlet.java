package com.cog;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DateServlet")
public class DateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int count;
	
	public void init(){
		count = 0;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		Date date = new Date();
//		response.setContentType("application/json");
//		// response.getWriter().append("<h1>Served at date:
//		// </h1>").append(date.toString());
//		response.addHeader("Access-Control-Allow-Origin", "*");
//		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
//		response.addHeader("Access-Control-Allow-Headers",
//				"X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
//		response.addHeader("Access-Control-Max-Age", "1728000");
//
//		response.getWriter().println("{\"auth\": true}");
		
//		count++;
		
		count++;
				
		String email = request.getParameter("email");
		response.setContentType("text/html");
		response.getWriter().println("<h1>" + email +  "</h1>");
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		response.setContentType("text/html");
		response.getWriter().println("<h1>+" + email +  "</h1>");
		
		

	}

}
