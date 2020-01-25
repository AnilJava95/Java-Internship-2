import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		boolean loggedIn = false;

		request.getRequestDispatcher("link.html").include(request, response);

		try
		{
			Cookie ck[] = request.getCookies();
			for (int i = 0; i < ck.length; i++)
			{
				String name = ck[i].getName();

				if ("name".equals(ck[i].getName()))
				{
					loggedIn = true;

					Cookie ckUser = new Cookie("name", "");
					ckUser.setMaxAge(0);
					response.addCookie(ckUser);

					out.print("Logged out.");

					break;
				}
			}

			if (loggedIn == false)
			{
				out.print("You are not logged in.");
			}
		}
		catch (NullPointerException e)
		{
			if (loggedIn == false)
			{
				out.print("You are not logged in.");
			}
		}

		out.close();
	}
}
