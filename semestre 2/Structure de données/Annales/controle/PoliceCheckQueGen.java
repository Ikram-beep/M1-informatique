package controle;

import java.util.ArrayDeque;

public class PoliceCheckQueGen<V  extends I_Voyageur> {
	private ArrayDeque<V> line = new ArrayDeque<>();
	private int date;

	public PoliceCheckQueGen(int date) {this.date=date;}
	
	public boolean isEmpty(){return line.isEmpty();}
	
	public boolean contains(V v){
		return line.contains(v);
	}
	
	public void enter(V v){
		line.addLast(v);
		assert (line.contains(v));
	}

	public String control(){
		V v = line.getFirst();
		line.removeFirst();
		return "voyageur "+v.getNom()+" "+v.verify(date);
	}
}
