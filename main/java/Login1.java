

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login1
 */
//@WebServlet("/Login1")
public class Login1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter P1 = response.getWriter();
		HttpSession session = request.getSession();
		try {
		
			String m=request.getParameter("num1");
		    int n=   Integer.parseInt(request.getParameter("num2"));
		    //String T =request.getParameter("test");
			
			//P1.println("<h2> welcome to your profile <h2>");
			if(m.equals("Pradhumn")&& n == 1) {
		    	//P1.println("<h1> Welcome To Your Profile<h1>");
		    	RequestDispatcher rd =request.getRequestDispatcher("editDetail.html");
		    	rd.include(request, response);
		    } else{
		    	P1.println("<h1>Username Or Password Error<h1>");
		    	RequestDispatcher rd =request.getRequestDispatcher("LOCK.html");
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
			
		    
		    /*if (i.equals("Pradhumn")&& j == 1) {
		    	P1.println("Login Successful !!\n\n");
			    request.setAttribute("username",i);
			    RequestDispatcher rd =request.getRequestDispatcher("Suc");
			    rd.include(request, response);
		    } else{
		    	P1.println("Check username/Passsword");
		    	
		    }*/
			//String T =request.getParameter("test");
		    /*if(Re.next()) {
		    	P1.println("<h1> welcome to your profile<h1>");
		    } else {
		    	P1.println("<h1>Usernam or password erro<h1>");
		    	RequestDispatcher rd =request.getRequestDispatcher("LOCK.html");
		    	rd.include(request, response);
		    }*/
		    
			    /*RequestDispatcher rd =request.getRequestDispatcher("regis.html");
		    	rd.include(request, response);*/
		   
		    	/*RequestDispatcher rd1 =request.getRequestDispatcher("BloodDonation.html");
		        rd1.include(request, response);
		        if("Login1".equals(T) && Re.next()) {
		        	P1.println("<h1> welcome to your profile<h1>");
		        }else {
		        	P1.println("<h1>Usernam or password error<h1>");
		    	    RequestDispatcher rd2 =request.getRequestDispatcher("LOCK.html");
		    	    rd.include(request, response);
		        }*/
		     
	}
		catch(Exception e) {
			P1.println(e);
		}
		// TODO Auto-generated method stub
	}

}
