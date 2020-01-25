import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet2 extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
	   PrintWriter out = res.getWriter();
		
		try
		{
			ServletContext context = getServletContext();
			String n = (String) context.getAttribute("company");

			out.println("Attribute name: company<br>");
			out.println("Attribute value: " + n);
			out.close();
		}
		catch (Exception e)
		{
			out.println(e);
		}
	}
}
