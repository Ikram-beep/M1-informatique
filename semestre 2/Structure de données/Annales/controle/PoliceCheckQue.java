package controle;

import java.util.ArrayDeque;

public class PoliceCheckQue {
	private ArrayDeque<I_Voyageur> line = new ArrayDeque<>();
	private int date;

	public PoliceCheckQue(int date) {this.date=date;}
	
	public boolean isEmpty(){return line.isEmpty();}
	
	public boolean contains(I_Voyageur v){
		return line.contains(v);
	}
	
	public void enter(I_Voyageur v){
		line.addLast(v);
		assert (line.contains(v));
	}

	public String control() throws EmptyCheckLineException{
		if (line.isEmpty())
			throw new EmptyCheckLineException("while controlling");
		I_Voyageur v = line.getFirst();
		line.removeFirst();
		return "voyageur "+v.getNom()+" "+v.verify(date);
	}
}
