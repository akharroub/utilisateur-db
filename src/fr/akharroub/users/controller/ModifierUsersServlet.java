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
 * Servlet implementation class ModifierUsersServlet
 */
@WebServlet(name = "modifier-users", urlPatterns = { "/modifier-users" })
public class ModifierUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersBusiness userss = new UsersBusiness();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString =request.getParameter("id");
		int id =Integer.parseInt(idString);
		
		Users users = userss.findOne(id);
		request.setAttribute("users", users);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifier_users.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		String numeroString = request.getParameter("numero");
		int numero = 0;
		try {
			numero = Integer.parseInt(numeroString);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("modifier-users");
			return;
		}


		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String adresse = request.getParameter("adresse");
		String photo = request.getParameter("photo");

		if(nom.equals("")|| prenom.equals("")||phone.equals("")||email.equals("")||adresse.equals("")||photo.equals("")){

			response.sendRedirect("modifier-users");
			return;
		}
		
		boolean ok = userss.modifierusers(id ,nom, prenom, numero, phone, email, adresse, photo);
		if (ok) {
			response.sendRedirect("users_info?id=" + id);
		}else {
			response.sendRedirect("modifier-users?id=" + id);
		}

	}

}
