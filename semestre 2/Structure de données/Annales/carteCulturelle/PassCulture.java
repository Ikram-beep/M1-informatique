package carteCulturelle;

import java.util.TreeSet;

class ContientDejaPassException extends Exception{
	public ContientDejaPassException(){}
	public ContientDejaPassException(String message){super(message);}
}

public class PassCulture<A extends IActiviteCulturelle> {

	private String personne;
	private TreeSet<A> listeActivites = new TreeSet<>();
	
	public PassCulture() {
	}
	
	public void ajoute (A a){
		// il n'y a pas de doublons dans un treeset
		listeActivites.add(a);
	}
	
	public boolean retire(A a){
		boolean appartenait = this.listeActivites.contains(a);
		int nbAvant=this.listeActivites.size();
		this.listeActivites.remove(a);
		assert(appartenait ?  listeActivites.size()==nbAvant-1 : listeActivites.size()==nbAvant);
		return appartenait;
	}

	public double quefaisje(){
		return listeActivites
				.stream()
				.filter(act -> act.getAbonnement()>10 && act.estSubventionnee())
				.mapToDouble(act -> act.getAbonnement())
				.average()
				.getAsDouble();
	}
	
	public double quefaisje2(){
		if (listeActivites.isEmpty())
			return 0;
		double somme = 0;
		for (A s : this.listeActivites)
			if (s.getAbonnement()>10 && s.estSubventionnee())
				somme += s.getAbonnement();
		return somme/listeActivites.size();

	}
	
	public static<T1 extends IActiviteCulturelle, T2 extends T1> 
		void absorbe(PassCulture<T1> pass1, PassCulture<T2> pass2)
		throws ContientDejaPassException
	{
		if (pass1.listeActivites.containsAll(pass2.listeActivites))
			throw new ContientDejaPassException("en absorbant");
		pass1.listeActivites.addAll(pass2.listeActivites);
	}
	
	public static void main(String[] args) {
		try{
		ActiviteTheatre a1 = new ActiviteTheatre("spectacle",360,true);
		ActiviteTheatre a2 = new ActiviteTheatre("atelier_impro",200,true);
		ActiviteTheatre a3 = new ActiviteTheatre("atelier_diction",5,true);
		PassCulture<ActiviteTheatre> pass1 = new PassCulture<>();
		PassCulture<ActiviteTheatre> pass2 = new PassCulture<>();	
		pass1.ajoute(a1);
		pass2.ajoute(a3);
		absorbe(pass1, pass2);
		pass1.ajoute(a1);
		pass1.ajoute(a2);
		pass1.ajoute(a3);
		absorbe(pass1, pass2);
		}
		catch(ContientDejaPassException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
