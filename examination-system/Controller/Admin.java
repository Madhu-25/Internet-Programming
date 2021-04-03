
package MVCDemo.Controller;
import MVCDemo.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class Admin extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException,IOException
	{
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		LoginCheck obj = new LoginCheck();
		System.out.println("Checking Admin Login Credentials...");
        Cookie ck[] = request.getCookies();

		
		try {
			
			String result = obj.getPassword(username, password);
			if (result.equals("0")){
				System.out.println("\nInvalid Login ..!");
				pw.println("<h1>Invalid Login ..!</h1><br><br>");
				pw.println("<button onclick=\"location.href = 'login.html';\">Try again</button>");
				
				
				
			}
			else{
                if(obj.getDesignation(username)==0)
                {
                    pw.println("<h1>Invalid Login only faculty memebers allowed..!</h1><br><br>");
				pw.println("<button onclick=\"location.href = 'login.html';\">Go back</button>");


                }
                else{

                    int count=SessionCounter.getSessionCount();
                    System.out.println("\nPassword Matched. Login Successful");
                    pw.println("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" /><body><h4>Welcome "+result+" !</h4><br><h4>Model Online Examination </h4><br> <h5> Number of students attending test right Now: "+count+" </h5>");

                    
				

                }
                 pw.println("</body>");
				
			}
			
		}catch(Exception e){
			System.out.println("Exception thrown : "+e);
		}
	}
}
