package personnages;

public class Romain {
	private String nom;
	private String texte;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
			assert force >= 0;
			this.nom = nom;
			this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "«"+ texte+ "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	//Start ajout
	

	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force == 0) {
			parler("Aïe");
		}else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
			// post condition la force a diminuée
			assert force < oldForce;
			return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
		texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else if (equipements[i] != null && equipements[i].equals(Equipement.CASQUE)) {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}


	

	
	public void donner(Equipement equipement, int index) {
		equipements[index] = equipement;
		nbEquipement ++;
		texte = "Le soldat ";
		System.out.println(texte + nom + " s'équipe d'un " + equipement + ".");
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 1:
			if (equipements[0] == equipement) {
				System.out.println(texte + nom + " possède déjà un " + equipement + " !");
	
			} else {
				donner(equipement, 0);
			}
			break;
		case 2:
			System.out.println(texte + nom + " est déjà bien protégé !");
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
