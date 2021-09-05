package carteMultisport;

public class SportGlace extends ActiviteSportive{
	private double surface;
	private String typeSurface;
	public SportGlace() {
	}
	public SportGlace(String nom) {
		super(nom);
	}
	public SportGlace(String nom, double cotisation, String equipement,
			boolean disciplineOlympique) {
		super(nom, cotisation, equipement, disciplineOlympique);
	}	
}
