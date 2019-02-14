package fr.akharroub.users.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fr.akharroub.users.bean.Users;
import fr.akharroub.users.repository.IUsersRepository;

public class UsersRepository implements IUsersRepository {

	@Override
	public ArrayList<Users> recupLaListeDesUsers() {
		ArrayList<Users> ListeDesUsers = new ArrayList<>();

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306/users", "root", "");

			Statement st = cnx.createStatement();
			ResultSet resultat = 
					st.executeQuery("SELECT id,nom,prenom,numero,phone,email,adresse,photo FROM utilisateur");

			while (resultat.next()) {
				int iduser =  resultat.getInt("id");
				String nomuser = resultat.getString("nom");
				String prenomuser = resultat.getString("prenom");
				int numerouser = resultat.getInt("numero");
				String phoneuser = resultat.getString("phone");
				String emailuser = resultat.getString("email");
				String adresseuser = resultat.getString("adresse");
				String photouser = resultat.getString("photo");

				Users per = new Users(iduser, nomuser, prenomuser, numerouser, phoneuser, emailuser, adresseuser, photouser);
				ListeDesUsers.add(per);


			}
		} catch (Exception e) {
			e.printStackTrace();
		}




		return ListeDesUsers;
	}

	@Override
	public Users findOne(int id) {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/users", "root", "");
			Statement st = cnx.createStatement();
			ResultSet resultat = st.executeQuery("SELECT id,nom,prenom,numero,phone,email,adresse,photo FROM utilisateur where id =" + id);
			
			while (resultat.next()) {
				int iduser =  resultat.getInt("id");
				String nomuser = resultat.getString("nom");
				String prenomuser = resultat.getString("prenom");
				int numerouser = resultat.getInt("numero");
				String phoneuser = resultat.getString("phone");
				String emailuser = resultat.getString("email");
				String adresseuser = resultat.getString("adresse");
				String photouser = resultat.getString("photo");

				Users pers = new Users(iduser, nomuser, prenomuser, numerouser, phoneuser, emailuser, adresseuser, photouser);
				return pers;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public void supprimerUtilisateur(int id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/users", "root", "");

			Statement st = cnx.createStatement();

			st.executeQuery("DELETE FROM utilisateur WHERE id = " + id);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean ajouterutilisateur(String nom, String prenom, int numero, String phone, String email, String adresse,
			String photo) {
		
		
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/users", "root", "");

				PreparedStatement ps = cnx.prepareStatement("Insert into utilisateur (nom,prenom,numero,phone,email,adresse,photo) values (?,?,?,?,?,?,?) ");
				ps.setString(1, nom);
				ps.setString(2, prenom);
				ps.setInt(3, numero);
				ps.setString(4, phone);
				ps.setString(5, email);
				ps.setString(6, adresse);
				ps.setString(7, photo);
				
				ps.executeUpdate();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false ;
			}
		
	}

	@Override
	public boolean modifierusers(int id,String nom, String prenom, int numero, String phone, String email, String adresse,
			String photo) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/users", "root", "");

			PreparedStatement ps = cnx.prepareStatement("update utilisateur set nom = ? ,prenom = ? ,numero = ? ,phone = ? ,email = ?,adresse = ? ,photo = ?  where id = ? ");
			
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setInt(3, numero);
			ps.setString(4, phone);
			ps.setString(5, email);
			ps.setString(6, adresse);
			ps.setString(7, photo);
			ps.setInt(8, id);
			 
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}


}
