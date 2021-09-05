package carteMultisport;

public interface IActiviteSportive extends Comparable<IActiviteSportive>{
	String nom();
	double cotisation();
	String équipement();
	boolean disciplineOlympique();
	default int compareTo(IActiviteSportive autre){
		System.out.println("compare To");
		return this.nom().compareTo(autre.nom());
	}
}
