import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet1 extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		try
		{
			ServletContext context = getServletContext();
			context.setAttribute("company", "IBM");

			out.println("Attrubute has been set.");
			out.println("<a href=Servlet2>visit</a>");
			out.close();
		}
		catch (Exception e)
		{
			out.println(e);
		}
	}
}
