package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement equipements[] = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
			assert force >= 0;
			this.nom = nom;
			this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "«"+ texte+ "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force >= 0;
		force -= forceCoup;
		int veriForce = force;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert veriForce < force;
	}
	
	public void donner(Equipement equipement, int index) {
		equipements[index] = equipement;
		nbEquipement ++;
		System.out.println("Le soldat " + nom + " s'équipe d'un " + equipement + ".");
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
	
			} else {
				donner(equipement, 0);
			}
			break;
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 0:
			donner (equipement, 0);
			break;
		}
	}
	
	
	
	public static void main (String[] args) {
		Romain marcus = new Romain("Marcus",6);
		System.out.println(marcus.getNom());
		System.out.println(marcus);
		marcus.prendreParole();
		marcus.parler("Bonjour");
		marcus.sEquiper(Equipement.CASQUE);
		marcus.sEquiper(Equipement.CASQUE);
		marcus.sEquiper(Equipement.BOUCLIER);
		marcus.sEquiper(Equipement.CASQUE);
		
	}
}
