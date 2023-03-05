package DAO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Model.Clicli;

public class ClicliDAO {

	public void ajouterCompte(Clicli cc) {

		ArrayList<Clicli> tab = new ArrayList<>();

		try {

			FileInputStream io = new FileInputStream("C:\\Users\\Jekyll\\Documents\\textJsp\\Clicli.txt");

			ObjectInputStream o = new ObjectInputStream(io);

			tab = (ArrayList<Clicli>) o.readObject();
			tab.add(cc);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();

		}

		try {

			FileOutputStream io = new FileOutputStream("C:\\Users\\Jekyll\\Documents\\textJsp\\Clicli.txt");

			ObjectOutputStream o = new ObjectOutputStream(io);

			o.writeObject(tab);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public ArrayList<Clicli> afficherTousComptes() {

		ArrayList<Clicli> c = new ArrayList<>();

		try {

			FileInputStream io = new FileInputStream("C:\\Users\\Jekyll\\Documents\\textJsp\\Clicli.txt");

			ObjectInputStream o = new ObjectInputStream(io);

			c = (ArrayList<Clicli>) o.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();

		}

		return c;

	}
}
