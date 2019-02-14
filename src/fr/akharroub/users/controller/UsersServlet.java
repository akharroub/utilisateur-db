package fr.akharroub.users.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.akharroub.users.bean.Users;
import fr.akharroub.users.business.impl.UsersBusiness;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet(name = "users-servlet", urlPatterns = { "/users-servlet" })
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersBusiness usersbz = new UsersBusiness();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ArrayList<Users> users = usersbz.recupLaListeDesUsers();
		 request.setAttribute("users", users);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
