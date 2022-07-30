

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

/**
 * Servlet implementation class bill
 */
//@WebServlet("/bill")
public class bill extends HttpServlet {
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
		    String s1 =  "select * from bill where bill_no =? ";
			PreparedStatement pt = con.prepareStatement(s1);
			int m=Integer.parseInt(request.getParameter("num5"));
		    //String T =request.getParameter("test");
			pt.setInt(1,m);
		    ResultSet  Re = pt.executeQuery();
		    /*if(Re.next()) {
		    	P1.println("<h1>patient Bill Detail <h1>");
		    }else {
		    	P1.println("<h1>Incorrect ID<h1>");
		    }*/
			/*P1.println("<style>");
			P1.println("h1{");
			P1.println("color:black;");
			P1.println("background-color:yellow;");
			P1.println("text-align:center");
			//P1.println("border: 1px solid black;");
			P1.println("}");
			P1.println("</style>");
			RequestDispatcher rd =request.getRequestDispatcher("bill.html");
	    	rd.include(request, response);
		    while(Re.next()) {
		    	P1.println("<h1><h1>"+"Patient Id :"+Re.getInt(1));	
		    	P1.println("<h1><h1>"+"Name : "+Re.getString(2));
				P1.println("<h1><h1>"+"Disease :"+Re.getString(3));
				P1.println("<h1><h1>"+"Total Bill : "+Re.getString(4));
			    P1.println("<h1><h1>"+"Date :"+Re.getString(5));     
		    }8*/
		    RequestDispatcher rd =request.getRequestDispatcher("cure.html");
	    	rd.include(request, response);
		    P1.println("</br></br></br></br>"); 
		    P1.println("<table border=2 width=100% height=1000%> ");  
		    P1.println("<style>" );
		    P1.println("table{");
		    P1.println("background-color:	#DCDCDC;");
		    P1.println("color:black;");
		    P1.println("text-align:center;");
		    P1.println("}");
		    P1.println("</style>" );
		    
            P1.println("<tr><th>Patient Id</th><th>Name</th><th>Disease</th><th>Total Bill</th><th>Date</th><tr>");  
            
            while (Re.next()) 
            {  
                String nm = Re.getString(1);
                P1.println("<tr><td>" + nm+ "</td><td>" + Re.getString(2)+ "</td><td>" + Re.getString(3) + "</td><td>"
                		+  Re.getString(4)+ "</td><td>" +  Re.getString(5)+ "</td></tr>");   
            }  
            P1.println("</table>");
		  
			con.close();
	    	
		}catch(Exception e) {
			P1.println(e);
		}
	}
}
