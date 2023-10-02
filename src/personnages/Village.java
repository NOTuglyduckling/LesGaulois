package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	
	public Village(String nom,int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String gteNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois, int place) {
		nbVillageois +=1;
		villageois[place]=gaulois;
	}
	
	public Gaulois trouverHabitant(int place) {
		return villageois[place];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef" + chef + " vivent les legendaires gaulois :");
			for (int i = 0; i<nbVillageois; i++) {
				System.out.println("- " + villageois[i].getNom());
			}
	}
	
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",30);
//		Gaulois gaulois = village.trouverHabitant(30);
		       // ERREUR : Index 30 out of bounds for length 3
		Chef abra = new Chef("Abraracourcix", 6, village);
		village.setChef(abra);
		Gaulois asterix = new Gaulois("Asterix",8);
		village.ajouterHabitant(asterix, 0);
//		Gaulois asterix = village.trouverHabitant(1);
//		System.out.println(gaulois);
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterHabitant(obelix, 1);
		village.afficherVillageois();
	}

}
