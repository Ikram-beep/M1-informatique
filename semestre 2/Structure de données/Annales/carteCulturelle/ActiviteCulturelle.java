package carteCulturelle;

public abstract class ActiviteCulturelle implements IActiviteCulturelle {

	private String intitulé;
	private double montantAbonnement;
	private boolean estSubventionnee;
	
	public ActiviteCulturelle() {
		// TODO Auto-generated constructor stub
	}

	public ActiviteCulturelle(String intitulé, double montantAbonnement,
			boolean estSubventionnee) {
		this.intitulé = intitulé;
		this.montantAbonnement = montantAbonnement;
		this.estSubventionnee = estSubventionnee;
	}



	@Override
	public String getIntitule() {
		// TODO Auto-generated method stub
		return this.intitulé;
	}

	@Override
	public double getAbonnement() {
		// TODO Auto-generated method stub
		return this.montantAbonnement;
	}

	@Override
	public boolean estSubventionnee() {
		// TODO Auto-generated method stub
		return this.estSubventionnee;
	}

}
