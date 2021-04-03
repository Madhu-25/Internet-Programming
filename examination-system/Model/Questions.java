package MVCDemo.Model;
import java.util.*;
import java.sql.*;

public class Questions{
    public ResultSet LoadQuestions(int n) throws Exception{
		try{
			String user = "root";
			String password = "madhu";
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/examsys",user,password);
			
			Statement st = con.createStatement();
			
			String sql = "select * from questions order by rand() limit " + n ;
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()){
				return rs;
			}
			else{
				return null;
			}
			
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
}