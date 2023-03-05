package DAO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Model.Coco;

public class cocoDAO {

	public void ajouterCommande(Coco cc) {

		ArrayList<Coco> tab = new ArrayList<>();

		try {

			FileInputStream io = new FileInputStream("C:\\Users\\Jekyll\\Documents\\textJsp\\Commande.txt");

			ObjectInputStream o = new ObjectInputStream(io);

			tab = (ArrayList<Coco>) o.readObject();
			tab.add(cc);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();

		}

		try {

			FileOutputStream io = new FileOutputStream("C:\\Users\\Jekyll\\Documents\\textJsp\\Commande.txt");

			ObjectOutputStream o = new ObjectOutputStream(io);

			o.writeObject(tab);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public ArrayList<Coco> afficherTousCommandes() {

		ArrayList<Coco> c = new ArrayList<>();

		try {

			FileInputStream io = new FileInputStream("C:\\Users\\Jekyll\\Documents\\textJsp\\Commande.txt");

			ObjectInputStream o = new ObjectInputStream(io);

			c = (ArrayList<Coco>) o.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();

		}

		return c;

	}
}
