package DAO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Model.compte;

public class compteDao {

	public void ajouterCompte(compte cc) {

		// lire le contenu du fichier dans une liste l
		ArrayList<compte> tab = new ArrayList<>();

		try {

			// déserialiser le fichier dans lequel j'enregistre le client
			FileInputStream io = new FileInputStream("C:\\Users\\Jekyll\\Documents\\textJsp\\Compte.txt");
			// pour écrire des objets dans le fichier de stockage
			ObjectInputStream o = new ObjectInputStream(io); // prendre le fichier dans lequel je veux enregistrer en

			// lire le tableau// paramètre
			tab = (ArrayList<compte>) o.readObject(); // en paramètre le nom de l'objet à écrire dans le fichier
			tab.add(cc);// ajouter un client au tableau

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace(); // message dans le cas d'une erreur / exception

		}

		// ajouter client dans l

		try {

			// fichier dans lequel j'enregistre mon client
			FileOutputStream io = new FileOutputStream("C:\\Users\\Jekyll\\Documents\\textJsp\\Compte.txt");
			// pour écrire des objets dans le fichier de stockage
			ObjectOutputStream o = new ObjectOutputStream(io); // prendre le fichier dans lequel je veux enregistrer en
																// paramètre

			// inscrire le client dans le tableau qui sera envoyé dans le fichier
			o.writeObject(tab); // en paramètre le nom de l'objet à écrire dans le fichier

		} catch (IOException e) {
			e.printStackTrace(); // message dans le cas d'une erreur / exception

		}
	}

	public ArrayList<compte> afficherTousComptes() {

		ArrayList<compte> c = new ArrayList<>();

		// lecture du tableau
		try {

			// fichier dans lequel j'enregistre mon client
			FileInputStream io = new FileInputStream("C:\\Users\\Jekyll\\Documents\\textJsp\\Compte.txt");
			// pour lire des objets dans le fichier de stockage
			ObjectInputStream o = new ObjectInputStream(io); // prendre le fichier dans lequel je veux enregistrer en
																// paramètre
			c = (ArrayList<compte>) o.readObject(); // lire l'objet client

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace(); // message dans le cas d'une erreur / exception

		}

		return c;

	}

	public compte afficherCompte() {

		compte cc = new compte();
		try {

			// fichier dans lequel mon compte est enregistré
			FileInputStream io = new FileInputStream("C:\\Users\\Jekyll\\Documents\\textJsp\\Compte.txt"); // lireles
																											// objets
																											// dans le
																											// fichier
																											// de
																											// stockage
			ObjectInputStream o = new ObjectInputStream(io); // prendre en paramètre le fichier dans lequel l'objetest
																// enregistré

			cc = (compte) o.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			// message dans le cas d'une erreur / exception }
		}

		return cc;
	}

	public void crediter(compte compte, double somme) {

		ArrayList<compte> tab = new ArrayList<>();

		// désérialiser
		try {

			// déserialiser le fichier dans lequel j'enregistre le client
			FileInputStream io = new FileInputStream("C:\\Users\\Jekyll\\Documents\\textJsp\\Compte.txt");
			// pour écrire des objets dans le fichier de stockage
			ObjectInputStream o = new ObjectInputStream(io); // prendre le fichier dans lequel je veux enregistrer en

			// lire le tableau// paramètre
			tab = (ArrayList<compte>) o.readObject(); // en paramètre le nom de l'objet à écrire dans le fichier

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace(); // message dans le cas d'une erreur / exception

		}

		// chercher le compte

				double res = compte.getSolde();
				res += somme;
				compte.setSolde(res);
				System.out.println("Youpi" + res);
		

		// sérialiser la nouvelle liste

		try {

			// fichier dans lequel j'enregistre mon client
			FileOutputStream io = new FileOutputStream("C:\\Users\\Jekyll\\Documents\\textJsp\\Compte.txt");
			// pour écrire des objets dans le fichier de stockage
			ObjectOutputStream o = new ObjectOutputStream(io); // prendre le fichier dans lequel je veux enregistrer en
																// paramètre

			// inscrire le client dans le tableau qui sera envoyé dans le fichier
			o.writeObject(tab); // en paramètre le nom de l'objet à écrire dans le fichier

		} catch (IOException e) {
			e.printStackTrace(); // message dans le cas d'une erreur / exception
		}
	}

	public void debiter(int num, double somme) {
		double res = 0;

		ArrayList<compte> tab = new ArrayList<>();

		// désérialiser
		try {

			// déserialiser le fichier dans lequel j'enregistre le client
			FileInputStream io = new FileInputStream(
					"C:\\Users\\\\Allpo\\eclipse-workspace\\Exercice_1_JEE\\Compte.txt");
			// pour écrire des objets dans le fichier de stockage
			ObjectInputStream o = new ObjectInputStream(io); // prendre le fichier dans lequel je veux enregistrer en

			// lire le tableau// paramètre
			tab = (ArrayList<compte>) o.readObject(); // en paramètre le nom de l'objet à écrire dans le fichier

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace(); // message dans le cas d'une erreur / exception

		}

		// chercher le compte

		for (compte compte : tab) {
			if (num == compte.getNumero()) {
				res -= somme;
				compte.setSolde(res);

			}

		}

		// sérialiser la nouvelle liste

		try {

			// fichier dans lequel j'enregistre mon client
			FileOutputStream io = new FileOutputStream("C:\\Users\\Jekyll\\Documents\\textJsp\\Compte.txt");
			// pour écrire des objets dans le fichier de stockage
			ObjectOutputStream o = new ObjectOutputStream(io); // prendre le fichier dans lequel je veux enregistrer en
																// paramètre

			// inscrire le client dans le tableau qui sera envoyé dans le fichier
			o.writeObject(tab); // en paramètre le nom de l'objet à écrire dans le fichier

		} catch (IOException e) {
			e.printStackTrace(); // message dans le cas d'une erreur / exception
		}
	}

}