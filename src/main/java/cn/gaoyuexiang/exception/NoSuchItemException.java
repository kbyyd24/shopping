package cn.gaoyuexiang.exception;

/**
 * Created by melo on 16-7-9.
 */
public class NoSuchItemException extends DomainException {

	public NoSuchItemException() {
		super();
	}


	public NoSuchItemException(String message) {
		super(message);
	}


	public NoSuchItemException(String message, Throwable cause) {
		super(message, cause);
	}


	public NoSuchItemException(Throwable cause) {
		super(cause);
	}

	protected NoSuchItemException(String message, Throwable cause,
	                              boolean enableSuppression,
	                              boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
