package controle;

public class Passport {
	private String number="zzz";
	private int deliveryDate=0;
	private int expiryDate=0;

	public Passport() {}

	public Passport(String number, int deliveryDate, int expiryDate) {
		this.number = number;
		this.deliveryDate = deliveryDate;
		this.expiryDate = expiryDate;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(int deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(int expiryDate) {
		this.expiryDate = expiryDate;
	}
	
}
