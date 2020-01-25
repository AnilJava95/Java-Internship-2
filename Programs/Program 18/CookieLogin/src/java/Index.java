import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Index extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		boolean loggedIn = false;

		// See if the user is logged in or not using cookie named "name". Forward 
		// to index2.html if logged in, forward to index.html if not.
		try
		{
			Cookie ck[] = request.getCookies();
			for (int i = 0; i < ck.length; i++)
			{
				String name = ck[i].getName();

				if ("name".equals(ck[i].getName()))
				{
					request.getRequestDispatcher("index2.html").forward(request, response);

					loggedIn = true;

					break;
				}
			}
			
			if (loggedIn == false)
			{
				request.getRequestDispatcher("index.html").forward(request, response);
			}
		}
		catch (NullPointerException e)
		{
			if (loggedIn == false)
			{
				request.getRequestDispatcher("index.html").forward(request, response);
			}
		}

		out.close();
	}
}
