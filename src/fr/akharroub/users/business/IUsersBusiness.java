package fr.akharroub.users.business;

import java.util.ArrayList;

import fr.akharroub.users.bean.Users;

public interface IUsersBusiness {
	
	public ArrayList<Users> recupLaListeDesUsers();
	
	public Users findOne (int id);
	
public void supprimerUtilisateur(int id);

public boolean ajouterutilisateur(String nom ,String prenom, int numero,String phone, String email, String adresse , String photo);

public boolean modifierusers(int id ,String nom ,String prenom, int numero,String phone, String email, String adresse , String photo);

}
