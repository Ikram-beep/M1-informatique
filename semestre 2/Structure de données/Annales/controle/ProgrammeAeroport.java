package controle;

public class ProgrammeAeroport {

	public static void main(String[] args) {
		Passport pGil = new Passport("33TH45",20100102,20200101);
		//Passport pGil = new Passport("33TH45",19990102,20090101);
		Passport pEld = new Passport("36GD48",20121002,20220901);
		Passport pTil = new Passport("89PO75",20141002,20240901);
		Passport pYul = new Passport("77II90",20141002,20240901);
		Visa vGil = new Visa("77",20140101,20180101,"Eldamar");
		//Visa vGil = new Visa("77",19990102,20090101,"Eldamar");
		Visa vEld = new Visa("88",20160101,20161231,"Himlad");
		Voyageur_Angmar gil = new Voyageur_Angmar("Gil",pGil,vGil);
		Voyageur_Angmar eld = new Voyageur_Angmar("Eld",pEld,vEld);		
		Voyageur_Brethil til = new Voyageur_Brethil("Til",pTil,true);	
		Voyageur_Brethil yul = new Voyageur_Brethil("Yul",pYul,false);
		
		PoliceCheckQue p1 = new PoliceCheckQue(20160506);
		p1.enter(gil); p1.enter(eld); p1.enter(til); p1.enter(yul);	
		
		try{
		System.out.println("controle p1");		
		while (!p1.isEmpty())
			System.out.println(p1.control());
		
		p1.control();
	
		PoliceCheckQueGen<Voyageur_Angmar> p2 = new PoliceCheckQueGen<>(20160506);
		p2.enter(gil); p2.enter(eld); 
		//p2.enter(til); p2.enter(yul);	
		
		System.out.println("controle p2");
		while (!p2.isEmpty())
			System.out.println(p2.control());
		
		}
		catch(EmptyCheckLineException e){System.out.println(e.getMessage());}
	}

}
