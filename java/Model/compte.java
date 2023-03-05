package Model;

import java.io.Serializable;

public class compte implements Serializable {
	
	private static final long serialVersionUID = -4937812758111456354L;
	
	private String titulaire;
	private Integer numero;
	private double solde;
	
	
	
	public String getTitulaire() {
		return titulaire;
	}
	public void setTitulaire(String titulaire) {
		this.titulaire = titulaire;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	
	@Override
	public String toString() {
		return " \n **********COMPTE************ [titulaire = " + titulaire + ", numero = " + numero + ", solde = " + solde + "] \n \n";
	}
	
	
	
	
	
	
	
	
	

}