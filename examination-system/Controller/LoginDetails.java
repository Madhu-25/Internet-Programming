
package MVCDemo.Controller;
import MVCDemo.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LoginDetails extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException,IOException
	{
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		LoginCheck obj = new LoginCheck();
		System.out.println("Checking Login Credentials...");
		
		try {
			
			String result = obj.getPassword(username, password);
			if (result.equals("0")){
	
				System.out.println("\nInvalid Login ..!");
				pw.println("<h1>Invalid Login ..!</h1><br><br>");
				pw.println("<button onclick=\"location.href = 'login.html';\">Try again</button>");
				
				
				
			}
			else{
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				System.out.println("\nUser: "+username);
				

				System.out.println("\nPassword Matched. Login Successful");
				pw.println("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" /><body><form name=\"exam\" action=\"questions\" method=\"GET\"><h4>Welcome "+result+" !</h4><br><h4>Model Online Examination - Instructions: </h4><ul><li>This test consists of 5 questions</li><br><li>Each question carries 5 marks, the total marks is 25.</li><br><li>There are no negative marks</li><br><li>Take the test on or before 28/03/2021</li></ul><br><br><input type=\"hidden\" name=\"username\" value=\""+username+"\"><input type=\"submit\" value=\"start test\" id=\"icon\"></form></body>");
				
			}
			
		}catch(Exception e){
			System.out.println("Exception thrown : "+e);
		}
	}
}


