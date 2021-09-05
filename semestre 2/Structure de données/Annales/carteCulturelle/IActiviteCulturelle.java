package carteCulturelle;

public interface IActiviteCulturelle extends Comparable<IActiviteCulturelle>{
 String getIntitule();
 double getAbonnement();
 boolean estSubventionnee();
 default int compareTo(IActiviteCulturelle autre){
	 return this.getIntitule().compareTo(autre.getIntitule());
 }
}
