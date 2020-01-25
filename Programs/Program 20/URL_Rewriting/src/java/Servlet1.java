import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet1 extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String n = request.getParameter("userName");
			out.print("Welcome " + n);

			//appending the username in the query string  
			out.print("<br><br><a href=Servlet2?uname=" + n + ">visit</a>");

			out.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
