package controle;

public class Voyageur_Angmar extends Abs_Voyageur {
	private Visa visa;

	public Voyageur_Angmar() {}

	public Voyageur_Angmar(String nom, Passport passport, Visa visa) {
		super(nom, passport);
		this.visa = visa;
	}

	public Visa getVisa() {
		return visa;
	}

	public void setVisa(Visa visa) {
		this.visa = visa;
	}

	public PoliceControlResult verify(int date){
		if (super.verify(date).equals(PoliceControlResult.authorizedEntry)
				&&  date >= visa.getEntryDate()
				&& date <= visa.getExitDate()
				&& visa.getCountry().equals("Eldamar"))
			return PoliceControlResult.authorizedEntry;
		else return PoliceControlResult.noAdmission;
	}
}
