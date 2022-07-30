

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update1
 */
//@WebServlet("/update1")
public class update1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter P1 = response.getWriter();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentd","root","Seven696#");
		    //String s1 =  "select * from studentda where Student_id = ?";
		    //String s2 = "insert into studentda values(?,?,?)";
		    //String stlQ = "delete from studentda where Student_id =? ";
		   // String s1 =  "select * from userlogin where uname =? and uid =?";
		    
		    String l=request.getParameter("u");
		    String a=request.getParameter("a");
		    String b =request.getParameter("b");
		    
		    String s1 = "update patient set uname=?,contact=? where uid = ? ";
			PreparedStatement pt = con.prepareStatement(s1);
		    
		    //String upass1 =request.getParameter("upass");
			
			pt.setString(1,a);
			pt.setString(2,b);
			pt.setString(3,l);
			//pt.setString(2,a);
			//pt.setString(3,b);
			
			//pt.setString(3,upass1);
			int r =pt.executeUpdate();
			RequestDispatcher rd =request.getRequestDispatcher("update.html");
	    	rd.include(request, response);
			
			//P1.println("<h1>Enter Id<h1>");
	    	if(r==1) {
	    		P1.println("<h1>Details updated!<h1>");
			//P1.println("<h1>Details updated!<h1>"+ a);
	    	}else {
	    		P1.println("<h1>Incorrect ID!<h1>");	
	    	}
		    P1.println("");
			P1.println("");
			P1.println("<style>");
			P1.println("h1{");
			P1.println("color:white;");
			P1.println("background-color:red;");
			P1.println("text-align:center");
			//P1.println("border: 1px solid black;");
			P1.println("}");
			P1.println("</style>");
			
		    /*ResultSet  Re = pt.executeQuery();
		    while(Re.next()) {
		    	P1.println(Re.getString(1)+" "+Re.getString(2)+" "+Re.getString(3));	
		    }
			con.close();
		    /*RequestDispatcher rd =request.getRequestDispatcher("");
	    	rd.include(request, response);*/
		}catch(Exception e) {
			P1.println(e);
		}
	}
}
