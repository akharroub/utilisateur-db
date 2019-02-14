package fr.akharroub.users.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.akharroub.users.bean.Users;
import fr.akharroub.users.business.impl.UsersBusiness;

/**
 * Servlet implementation class UsersInfoServlet
 */
@WebServlet(name = "users_info", urlPatterns = { "/users_info" })
public class UsersInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersBusiness ubz = new UsersBusiness();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idi = request.getParameter("id");
		int id = Integer.parseInt(idi);
		
		Users user = ubz.findOne(id);
		request.setAttribute("user", user);
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/user_info.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
