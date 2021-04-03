import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.Math;

public class Calculator extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        int a1= Integer.parseInt(request.getParameter("operand1"));
        int a2= Integer.parseInt(request.getParameter("operand2"));
        if(request.getParameter("r1")!=null)
        {
            out.println("<h3>Addition: "+(a1+a2)+"</h3>");
        }
        if(request.getParameter("r2")!=null)
        {
            out.println("<h3>Substraction: "+(a1-a2)+"</h3>");
        }
        if(request.getParameter("r3")!=null)
        {
            out.println("<h3>Multiplication: "+(a1*a2)+"</h3>");
        }if(request.getParameter("r1")!=null)
        {
            out.println("<h3>Division: "+(a1/a2)+"</h3>");
        }
        }
        catch(Exception e)
        {

        }
    }
}