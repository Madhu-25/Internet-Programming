package MVCDemo.Controller;
import MVCDemo.Model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class MarkDetails extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException,IOException
	{
        
		
		
        String username = request.getParameter("username");
        
        
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
        pw.println("<script src=script.js></script>");
        pw.println("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" /><body><h3 align=\"center\"> "+username+"\'s Test result </h3> <button id=\"icon\" onclick=\"display1()\"> View IP marks </button> <button id=\"icon2\" onclick=\"display2()\"> View Marksheet </button><div id=\"table1\"><table> <tr><th>Question</th><th>Your Answer</th><th>Correct Answer </th></tr> ");
        MarkCheck obj = new MarkCheck();
        
       
        int total =0;
        try{
            pw.println("<br><details><summary> View Review </summary> ");
            System.out.println("Fetching marks....");
            for(int i=1; i<=5; i++)
            {
                String ques = request.getParameter(String.valueOf(i*11));
                
                String ans = request.getParameter(String.valueOf(i));
                
                String crct = obj.checkAnswer(ques, ans);
                if(crct.equals(ans))
                {
                    total+=5;
                    pw.println("<tr><td>"+ques+ "</td><td id=\"right\">"+ans+"</td><td>"+ans+"</td></tr>");

                }
                else{
                    pw.println("<tr><td>"+ques+ "</td><td id=\"wrong\">"+ans+"</td><td >"+crct+"</td></tr>");

                }



            }
            System.out.println("\nUser: "+username+"  Marks: "+total);
            pw.println("</table></details><h3 id=\"marks\"> Your Total marks : "+ total + "/25 </h3></div><div id=\"table2\"><table><tr><th>Subject</th><th>Mark</th></tr>");
            ResultFetch rf = new ResultFetch();
            ResultSet rs = rf.getMarks(username);
            pw.println("<tr><td>ML</td><td id=\"right\">"+rs.getString("ML")+"</td></tr>");
            pw.println("<tr><td>IPR</td><td id=\"right\">"+rs.getString("IPR")+"</td></tr>");
            pw.println("<tr><td>FDS</td><td id=\"right\">"+rs.getString("FDS")+"</td></tr>");
            pw.println("<tr><td>DBMS</td><td id=\"right\">"+rs.getString("DBMS")+"</td></tr>");
            pw.println("<tr><td>IP</td><td id=\"right\">"+total+"</td></tr></table></div>");





            HttpSession session = request.getSession();
		    session.invalidate();
		    System.out.println("Session closed");

        }catch(Exception e){
			System.out.println("Exception thrown : "+e);
		}
    }
}