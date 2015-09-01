package Models;

public class Payment {
	public PaymentType type;

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}
	
	public Boolean AuthorizePayment(){
		if(this.type == null)
			throw new Error("No Payment type set");
		Boolean isSuccess = false;
		isSuccess = true;
		System.out.println("Authorized Payment with return value of: " + isSuccess);
		return isSuccess;
	}
}
