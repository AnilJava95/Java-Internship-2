import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet3 extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			// Deleting value of cookie "userName"
			Cookie ck = new Cookie("userName", "");
			out.print("Cookie's value has been deleted.");
			ck.setMaxAge(5); // Changing the maximum age to 0 seconds  
			out.print("<br/>Cookie's max age  has been set to 5 seconds.");
			response.addCookie(ck); // Adding cookie in the response  

			out.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
