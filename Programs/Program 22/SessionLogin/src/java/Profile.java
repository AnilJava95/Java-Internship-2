import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Profile extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		if (session != null)
		{
			request.getRequestDispatcher("link2.html").include(request, response);

			String name = (String) session.getAttribute("name");
			
			out.print("<br>");
			out.print("<b>Profile</b>");
			out.print("<br><br>Welcome, " + name + ".");
		}
		else
		{
			request.getRequestDispatcher("link.html").include(request, response);
			
			out.print("You are not logged in.");
		}
		out.close();
	}
}
