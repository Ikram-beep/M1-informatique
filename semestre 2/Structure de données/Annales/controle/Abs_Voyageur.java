package controle;

public abstract class Abs_Voyageur implements I_Voyageur{
	private String nom = "";
	private Passport passport;
	
	public Abs_Voyageur() {}

	public Abs_Voyageur(String nom, Passport passport) {
		this.nom = nom;
		this.passport = passport;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public PoliceControlResult verify(int date){
		if (date >= passport.getDeliveryDate() 
				&& date <= passport.getExpiryDate())
			return PoliceControlResult.authorizedEntry;
		else return PoliceControlResult.noAdmission;
	}
}
