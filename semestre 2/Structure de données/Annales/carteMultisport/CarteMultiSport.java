package carteMultisport;

import java.util.TreeSet;

class MemeCarteException extends Exception{
	public MemeCarteException(){}
	public MemeCarteException(String message){super(message);}
}

public class CarteMultiSport<S extends IActiviteSportive> {
	private String nomPersonne="";
	private TreeSet<S> listeActivites = new TreeSet<>();

	public CarteMultiSport() {
	}
	
	public void ajoute(S activite){
		System.out.println("entree dans ajoute "+listeActivites.size());
		int nbAvant = listeActivites.size();
		boolean appartenait = listeActivites.contains(activite);
		System.out.println(listeActivites.add(activite));
		System.out.println("ajout "+listeActivites.size());
		// assertion activite est dans listeActivites
		assert(listeActivites.contains(activite));
		// si elle n'y était pas avant, la taille a augmenté de 1
		assert(appartenait ?  listeActivites.size()==nbAvant : listeActivites.size()==nbAvant+1);
	}
	
	public String toString(){
		return listeActivites.toString();
	}
	
	public void fusionneAvec(CarteMultiSport<S> cAutre){
		// doit être une carte de la même personne (sinon exception)
		listeActivites.addAll(cAutre.listeActivites);
	}
	
	// somme des cotisations
	
	public double cotisDisOlymp(){
		return listeActivites
			.stream()
			.filter(act -> act.disciplineOlympique())
			.mapToDouble(act -> act.cotisation())
			.sum();
	}
	
	public double cotisDisOlymp2(){
		double somme = 0;
		for (S s : this.listeActivites)
			if (s.disciplineOlympique())
				somme += s.cotisation();
		return somme;
	}
	
	public void impDisOlymp(){
		listeActivites
			.stream()
			//.filter(act -> act.disciplineOlympique())
			//.forEach(b -> System.out.println("dis olymp ? "+b));
			.forEach(act -> System.out.println("dis olymp ? "+act.disciplineOlympique()));
	}

	
	// extraire les disciplines olympiques
	
	// activités communes entre 2 cartes avec retainAll
	// avec une méthode statique
	
	// lire une expression avec une stream
	// activités de la carte qui sont des discipline olympiques
	// somme des cotisations des disciplines olympiques
	
	public static<T extends IActiviteSportive> 
			TreeSet<T>  activitesCommunes(CarteMultiSport<T> c1, CarteMultiSport<T> c2) throws MemeCarteException
	{
		if (c1.equals(c2)) throw new MemeCarteException();
		TreeSet<T> res= new TreeSet<T>();
		res.addAll(c1.listeActivites);
		res.retainAll(c2.listeActivites);
		return res;
	}
	
	public static void main(String[] arg){
		try{
		SportGlace patinage = new SportGlace("patinage",12.0,"patins",true);
		SportGlace bobsleigh = new SportGlace("bobsleigh",50.0,"luge bob",false);
		SportGlace curling = new SportGlace("curling",120.0,"patins palet club",true);
		System.out.println("égales "+patinage.equals(bobsleigh));
		SportCollectif hand = new SportCollectif();
		CarteMultiSport<SportGlace> cg = new CarteMultiSport<>();
		cg.ajoute(patinage); 
		cg.ajoute(bobsleigh); cg.ajoute(bobsleigh);
		CarteMultiSport<SportGlace> cg2 = new CarteMultiSport<>();
		cg2.ajoute(patinage); cg2.ajoute(curling); 
		System.out.println("communes "+activitesCommunes(cg,cg2));			

		// cg.ajoute(hand);
		System.out.println(cg);
		System.out.println(cg2);
		cg.fusionneAvec(cg2);
		System.out.println(cg);
		System.out.println(cg2);
		
		System.out.println(cg.cotisDisOlymp());	
		cg.impDisOlymp();
		
		System.out.println(activitesCommunes(cg,cg));	
		}
		catch(MemeCarteException e){System.out.println(e.getMessage());}
	}
}
