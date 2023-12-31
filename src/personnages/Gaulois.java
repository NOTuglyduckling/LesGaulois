package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		parler ("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
	}
	
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole()+"«"+ texte+ "»");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
	}
	

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesRecu = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesRecu != null && i < tropheesRecu.length; i++,nbTrophees++) {
			this.trophees[nbTrophees] = tropheesRecu[i];
		}
	}
			
	
	public static void main (String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8);
		Romain marcus = new Romain("Marcus", 5);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		asterix.parler("Bonjour");
		asterix.boirePotion(2);
		asterix.frapper(marcus);
		
	}
}
