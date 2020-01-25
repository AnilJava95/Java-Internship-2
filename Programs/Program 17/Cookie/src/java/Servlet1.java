import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet1 extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			// Take http request parameter "userName" and print it on web page
			String n = request.getParameter("userName");
			out.print("http request parameter \"userName\": " + n);

			// Create cookie object name: userName, value: userName parameter.
			Cookie ck = new Cookie("userName", n);
			response.addCookie(ck); // Add cookie to the response
			out.print("<br/><br/>Created cookie with cookie name: \"" + ck.getName() + 
				"\" and cookie value: \"" + ck.getValue() + "\" and added cookie to reponse.");

			// Creating a button link to Servlet2
			out.print("<br/><br/><form action=Servlet2 method='post'>");
			out.print("<input type='submit' value='Servlet2'>");
			out.print("</form>");

			out.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
