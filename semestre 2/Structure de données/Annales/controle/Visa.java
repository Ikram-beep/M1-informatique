package controle;

public class Visa {
	private String visaNumber="zzz";
	private int entryDate=0;
	private int exitDate=0;
	private String country="zzz";
	
	public Visa() {}

	public Visa(String visaNumber, int entryDate, int exitDate, String country) {
		this.visaNumber = visaNumber;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.country = country;
	}

	public String getVisaNumber() {
		return visaNumber;
	}

	public void setVisaNumber(String visaNumber) {
		this.visaNumber = visaNumber;
	}

	public int getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(int entryDate) {
		this.entryDate = entryDate;
	}

	public int getExitDate() {
		return exitDate;
	}

	public void setExitDate(int exitDate) {
		this.exitDate = exitDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
