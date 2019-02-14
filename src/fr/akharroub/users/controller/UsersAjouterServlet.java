package fr.akharroub.users.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.akharroub.users.business.impl.UsersBusiness;

/**
 * Servlet implementation class UsersAjouterServlet
 */
@WebServlet(name = "usersajouter", urlPatterns = { "/usersajouter" })
public class UsersAjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersBusiness ub = new  UsersBusiness();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersAjouterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouter_users.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		String numeroString = request.getParameter("numero");
		int numero = 0;
		try {
			numero = Integer.parseInt(numeroString);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("usersajouter");
			return;
		}


		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String adresse = request.getParameter("adresse");
		String photo = request.getParameter("photo");

		if(nom.equals("")|| prenom.equals("")||phone.equals("")||email.equals("")||adresse.equals("")||photo.equals("")){

			response.sendRedirect("usersajouter");
			return;
		}

		boolean ok = ub.ajouterutilisateur(nom, prenom, numero, phone, email, adresse, photo);
		if (ok) {
			response.sendRedirect("users-servlet");
		}else {
			response.sendRedirect("usersajouter");
		}


	}

}
