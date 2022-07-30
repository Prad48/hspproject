

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class doctorDetail2
 */
//@WebServlet("/doctorDetail2")
public class doctorDetail2 extends HttpServlet {
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
		    String s1 =  "select * from doctordetail where doctorId =?";
			PreparedStatement pt = con.prepareStatement(s1);
		
			String m=request.getParameter("num1");
			pt.setString(1,m);
		    ResultSet  Re = pt.executeQuery();
		    //int n=   Integer.parseInt(request.getParameter("num2"));
		    //String T =request.getParameter("test");
			
			//P1.println("<h2> welcome to your profile <h2>");
			if(Re.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("user",m);
				response.sendRedirect("doctor.html");
				//Cookie c = new Cookie("username", m);
	            // attaching cookie to response object
	            //response.addCookie(c);
		    	//RequestDispatcher rd =request.getRequestDipatcher("doctor.html");
		    	//rd.include(request, response);
		    	P1.println("<h1> welcome to your profile<h1>");
		    } else{
		    	P1.println("<h1>Password Error<h1>");
		    	RequestDispatcher rd =request.getRequestDispatcher("Doctorlogin.html");
		    	rd.include(request, response);
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
			
		
			response.setContentType("text/html");
			
		} 
		catch(Exception e) {
			P1.println(e);
		}
	}


}
