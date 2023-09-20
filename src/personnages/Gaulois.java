package personnages;

public class Gaulois {
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	private String nom;
	private int force;
	private int effetPotion = 1;
	public String getNom() {
		return nom;
	}
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	public static void main(String[] args) {
		if (condition) {
			
		}
	}
}


public class Romain {
	private String nom;
	private int force;
	public Romain(String nom, int force) {
			this.nom = nom;
			this.force = force;
}
	public String getNom() {
		return nom;
}
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
}
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else {
			parler("J'abandonne...");
		}
	}
}



public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � " + effetPotionMax + ".");
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
}

public class Chef {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;
	public Chef(String nom, int force, Village village) {
		this.nom = nom;
		this.force = force;
		this.effetPotion = effetPotion;
		this.village = village;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	private String prendreParole() {
		return "Le chef " + nom + " du village " + village.getNom() + " : ";
	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " +
				romain.getNom());
		romain.recevoirCoup(force / 3);
	}
}




