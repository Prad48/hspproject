

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logout1
 */
//@WebServlet("/logout1")
public class logout1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        session.removeAttribute("user");
        session.invalidate();
        RequestDispatcher rd = request.getRequestDispatcher("Main.html");
        rd.forward(request, response);
       
	}
        //response.sendRedirect("Doctorlogin.html");
       /* response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
        response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility*/
        //String session =null;
       // HttpSession session = request.getSession();
      /*  HttpSession session = request.getSession(false);
		String	username = (String)session.getAttribute("doctordetail");
        if (null == username) {
           request.setAttribute("Error", "Session has ended.  Please login.");
           RequestDispatcher rd = request.getRequestDispatcher("Doctorlogin.html");
           rd.forward(request, response);
        }*/
  
        // Set the content type of response to "text/html"
        /*response.setContentType("text/html");
        response.setHeader("Catch-Control","no-cache,no-store,must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        
		if(session.getAttribute("username") == null) {
        	response.sendRedirect("Doctorlogin.html");*/
		/*PrintWriter out = response.getWriter();
        request.getRequestDispatcher("Doctorlogin.html")
            .include(request,
                     response); */// This statement includes
                                // link.html in this servlet
 
        // cookie with blank value is used to delete
        // a cookie to sign out the user
        //Cookie c = new Cookie("username", "");
       
        // setMaxAge will set the expiration of cookie.
        // This cookie will expire in 0seconds
       // c.setMaxAge(0);
       
        // Attach cookie to response
       // response.addCookie(c);
       
		
		
 
        
        	
    
	

}
