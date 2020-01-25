import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet2 extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			out.print("Searching through cookies that were sent with request to find "
				+ "the cookie named \"userName\"<br/><br/>");
			// Get cookies and print the one with the name "userName"
			Cookie ck[] = request.getCookies();
			for (int i = 0; i < ck.length; i++)
			{
				if ("userName".equals(ck[i].getName()))
				{
					out.print("Cookie name: " + ck[i].getName() + 
						"<br/>Cookie value: " + ck[i].getValue());
				}
			}

			// Creating a button link to Servlet3
			out.print("<br/><br/><form action='Servlet3' method='post'>");
			out.print("<input type='submit' value='Servlet3'>");
			out.print("</form>");

			out.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
