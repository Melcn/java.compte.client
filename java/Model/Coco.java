package Model;

import java.io.Serializable;

public class Coco implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String date;
	private String montant;
	private String mode;
	private String statutPaiement;
	private String modeLivraison;
	private String statutLivraison;
	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getStatutPaiement() {
		return statutPaiement;
	}

	public void setStatutPaiement(String statutPaiement) {
		this.statutPaiement = statutPaiement;
	}

	public String getModeLivraison() {
		return modeLivraison;
	}

	public void setModeLivraison(String modeLivraison) {
		this.modeLivraison = modeLivraison;
	}

	public String getStatutLivraison() {
		return statutLivraison;
	}

	public void setStatutLivraison(String statutLivraison) {
		this.statutLivraison = statutLivraison;
	}

	@Override
	public String toString() {
		return "coco [date=" + date + ", montant=" + montant + ", mode=" + mode + ", statutPaiement=" + statutPaiement
				+ ", modeLivraison=" + modeLivraison + ", statutLivraison=" + statutLivraison + "]";
	}
	

	
	
	
}
