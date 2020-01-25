import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	

		String password = request.getParameter("password");

		if (password.equals("admin"))
		{
			request.getRequestDispatcher("link2.html").include(request, response);
			
			String name = request.getParameter("name");
			Cookie ck = new Cookie("name", name);
			response.addCookie(ck);
			
			out.print("Logged in.");
			out.print("<br><br>Welcome, " + name);
		}
		else
		{
			request.getRequestDispatcher("link.html").include(request, response);
			
			request.getRequestDispatcher("login.html").include(request, response);
			out.print("Username or password error.");
		}

		out.close();
	}
}
