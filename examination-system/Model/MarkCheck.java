package MVCDemo.Model;
import java.util.*;
import java.sql.*;
public class MarkCheck{
    public String checkAnswer(String ques, String ans) throws Exception{
		try{
			String user = "root";
			String password = "madhu";
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/examsys",user,password);
			
			Statement st = con.createStatement();
			
			String sql = "select * from questions where question = \'" + ques + "\'";
            
			ResultSet rs = st.executeQuery(sql);
            rs.next();
            String answer = rs.getString("answer");
            return answer;
			
			
		}catch(Exception e){
			System.out.println(e);
			return "0";
		}
	}
}