package controle;

public class Voyageur_Brethil extends Abs_Voyageur {
	private boolean invitation = false;
	public Voyageur_Brethil() {}

	public Voyageur_Brethil(String nom, Passport passport, boolean invitation) {
		super(nom, passport);
		this.invitation = invitation;
	}
	
	public boolean isInvitation() {
		return invitation;
	}

	public void setInvitation(boolean invitation) {
		this.invitation = invitation;
	}

	public PoliceControlResult verify(int date){
		if (super.verify(date).equals(PoliceControlResult.authorizedEntry)
				&& invitation)
			return PoliceControlResult.authorizedEntry;
		else return PoliceControlResult.noAdmission;
	}
}
