package fr.akharroub.users.business.impl;


import java.util.ArrayList;

import fr.akharroub.users.bean.Users;
import fr.akharroub.users.business.IUsersBusiness;
import fr.akharroub.users.repository.impl.UsersRepository;

public class UsersBusiness implements IUsersBusiness{
	UsersRepository usse = new UsersRepository();
	
	@Override
	public ArrayList<Users> recupLaListeDesUsers() {
		ArrayList<Users> ListeDesUsers = usse.recupLaListeDesUsers();

		return ListeDesUsers;
	}

	@Override
	public Users findOne(int id) {
		
		Users u = usse.findOne(id);
		
		return u;
	}

	@Override
	public void supprimerUtilisateur(int id) {
		usse.supprimerUtilisateur(id);
		
	}

	@Override
	public boolean ajouterutilisateur(String nom, String prenom, int numero, String phone, String email, String adresse,
			String photo) {
		
		boolean b = usse.ajouterutilisateur(nom, prenom, numero, phone, email, adresse, photo);
		return b ;
	}

	@Override
	public boolean modifierusers(int id ,String nom, String prenom, int numero, String phone, String email, String adresse,
			String photo) {
		boolean mu = usse.modifierusers(id ,nom, prenom, numero, phone, email, adresse, photo);
		return mu;
	}

}
