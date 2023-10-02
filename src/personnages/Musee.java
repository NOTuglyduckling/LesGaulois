package personnages;

public class Musee {
	private Trophee[] trophee;
	private int nbTrophee = 0;
	
	public Musee() {
		this.trophee = new Trophee[200];
	}
	
	public Trophee[] donnerTrophees(Gaulois gaulois,Trophee trophee) {
		trophee[nbTrophee] = trophee;
		nbTrophee +=1;
	}
	
	public static void main(String[] args) {

	}

}
