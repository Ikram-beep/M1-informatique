package controle;

public interface I_Voyageur {
	String getNom();
	Passport getPassport();
	PoliceControlResult verify(int date);
}
