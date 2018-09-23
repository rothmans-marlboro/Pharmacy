package by.molochko.pharmacy.receiver;

public class ReceiverException extends Exception {

	private static final long serialVersionUID = 1L;

	public ReceiverException(String message) {
		super(message);
	}

	public ReceiverException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String toString() {
		return "ReceiverException{}" + this.getMessage();
	}
}
