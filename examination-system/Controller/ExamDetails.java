package MVCDemo.Controller;
import MVCDemo.Model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class ExamDetails extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        Questions q = new Questions();
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
        String username = request.getParameter("username");
        
        
        try{
            System.out.println("Loading Questions...");
            
            pw.println("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" /><body><form method=\"post\" action=\"finish\"> <h4 align=\"center\"> ONLINE MODEL EXAM </h4> ");
            ResultSet result = q.LoadQuestions(5);
            int i=1;
            System.out.println("Displaying questions....");
            do
            {
                ArrayList<String> mylist = new ArrayList<String>();
                mylist.add("choice1");
                mylist.add("choice2");
                mylist.add("choice3");
                mylist.add("choice4");
                Collections.shuffle(mylist);
                int index = 0;
                
                pw.println(i+" <p> "+ result.getString("question")+ "</p><input type=\"hidden\" name=\""+i*11+"\" value=\""+result.getString("question")+"\"/>");
                
                
                pw.println("<input type=\"radio\" id=\""+String.valueOf(i)+"1\" name=\""+i+"\" value=\""+result.getString(mylist.get(index))+"\"> <label for=\""+String.valueOf(i)+"1\"> "+result.getString(mylist.get(index))+"</label> <br>");
                index+=1;
                
                pw.println("<input type=\"radio\" id=\""+String.valueOf(i)+"2\" name=\""+i+"\" value=\""+result.getString(mylist.get(index))+"\"><label for=\""+String.valueOf(i)+"2\"> "+result.getString(mylist.get(index))+"</label> <br>");
                index+=1;
        
                pw.println("<input type=\"radio\" id=\""+String.valueOf(i)+"3\" name=\""+i+"\" value=\""+result.getString(mylist.get(index))+"\"> <label for=\""+String.valueOf(i)+"3\"> "+result.getString(mylist.get(index))+"</label><br>");
                index+=1;
               
                pw.println("<input type=\"radio\" id=\""+String.valueOf(i)+"4\" name=\""+i+"\" value=\""+result.getString(mylist.get(index))+"\"> <label for=\""+String.valueOf(i)+"4\"> "+result.getString(mylist.get(index))+"</label><br><br>");
                i+=1;
                              
            }while(result.next());

            pw.println("<br><input type=\"hidden\" name=\"username\" value=\""+username+"\"/><br><input type=\"submit\" value =\"Submit Test\" id=\"icon\"> </form></body>");
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}