package MVCDemo.Controller;
import MVCDemo.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Registration extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException,IOException
    {
        try{
            res.setContentType("text/html");
		    PrintWriter pw=res.getWriter();
            String username = request.getParameter("username");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String desgn = request.getParameter("desgn");
            LoginCheck obj = new LoginCheck();
            System.out.println("\nInserting user");
            obj.insert(name, username, password, desgn);
            pw.println("alert(\"Registration successful!\")");
            res.sendRedirect("login.html");
        }catch(Exception e)
        {
            System.out.println(e);
        }
        

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/plain;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String username = request.getParameter("username");
            LoginCheck obj = new LoginCheck();
           
            String[] users = obj.getIds();
            int flag = 0;
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i])) {
                    flag = 1;
                    out.print("0");
                }
            }
            if (flag == 0) {
                out.print("1");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

