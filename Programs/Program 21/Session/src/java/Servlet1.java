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

			HttpSession session = request.getSession();
			session.setAttribute("uname", n);

			out.print("<br><br><a href='Servlet2'>visit</a>");

			out.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
