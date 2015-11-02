package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

/**
 * Servlet implementation class SetLanguageServlet
 */
@WebServlet("/SetLanguage")
public class SetLanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SetLanguageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Lager cookie og redirecter tilbake til der han kom fra om bruker bytter språk
	 * ***Krav: Skal funke fra alle sider**
	 * Får param locale fra languages.jsp, bruker den til å sette formatet som styrer språk (1).
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String locale = request.getParameter("locale");
		if (locale != null) {
			Config.set(request.getSession(), Config.FMT_LOCALE, locale); //(1)
			Cookie localeCookie = new Cookie("locale", locale);
			localeCookie.setMaxAge(1); // setter cookie expiration
			response.addCookie(localeCookie);
			// Cookie with locale sent to client
		}

		String referrer = request.getHeader("referer"); //sender tilbake med nytt(?) språk
		response.sendRedirect(referrer);
		//

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
