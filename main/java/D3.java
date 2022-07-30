

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class D3
 */
//@WebServlet("/D3")
public class D3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter P1 = response.getWriter();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentd","root","Seven696#");
		    //String s1 =  "select * from studentda where Student_id = ?";
		    //String s2 = "insert into studentda values(?,?,?)";
		    //String stlQ = "delete from studentda where Student_id =? ";
		   // String s1 =  "select * from userlogin where uname =? and uid =?";
		    //String s1 = "update studentda set Name = '', Student_id = 69 where uname = ? and uid =?";
			/*PreparedStatement pt = con.prepareStatement(s1);
			String m=request.getParameter("uname");
		    String n=   request.getParameter("uid");
		    //String T =request.getParameter("test");
			pt.setString(1,m);
			pt.setString(2,n);
		    ResultSet  Re = pt.executeQuery();
		    System.out.println("Your deatail are :");
		    while(Re.next()) {
		    	P1.println(Re.getString(1)+" "+Re.getString(2)+" "+Re.getString(3));	
		    }
			con.close();*/
		    RequestDispatcher rd =request.getRequestDispatcher("D.html");
	    	rd.include(request, response);
	    	con.close();
		}catch(Exception e) {
			P1.println(e);
		}
		
		// TODO Auto-generated method stub
	}

}
