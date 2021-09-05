package carteMultisport;

public class ActiviteSportive implements IActiviteSportive {
	private String nom="";
	private double cotisation;
	private String equipement;
	private boolean disciplineOlympique;

	public ActiviteSportive() {
	}
	
	public ActiviteSportive(String nom) {
		this.nom = nom;
	}
	
	public ActiviteSportive(String nom, double cotisation, String equipement,
			boolean disciplineOlympique) {
		this.nom = nom;
		this.cotisation = cotisation;
		this.equipement = equipement;
		this.disciplineOlympique = disciplineOlympique;
	}

	@Override
	public String nom() {
		return nom;
	}

	@Override
	public double cotisation() {
		return this.cotisation;
	}

	@Override
	public String équipement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean disciplineOlympique() {
		// TODO Auto-generated method stub
		return this.disciplineOlympique;
	}
	
	public String toString(){return this.nom();}
	
	public boolean equals(Object autre){
		System.out.println("equals");
		return ((ActiviteSportive)this).nom().compareTo(((ActiviteSportive)autre).nom())==0;
	}	

}
