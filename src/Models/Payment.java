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
		Boolean isSuccess = false;
		if(this.type == null)
			throw new IllegalStateException("No Payment type set");
		isSuccess = true;
		//TODO: add real authorized payment logic here.
		System.out.println("Checking with bank to authorize payment");
		System.out.println("Authorized Payment with return value of: " + isSuccess);
		return isSuccess;
	}

	
}
