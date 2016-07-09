package cn.gaoyuexiang.exception;


public class StorageException extends DomainException {
	static final long serialVersionUID = -7034897190745761239L;

	public StorageException() {
		super();
	}


	public StorageException(String message) {
		super(message);
	}


	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}


	public StorageException(Throwable cause) {
		super(cause);
	}

	protected StorageException(String message, Throwable cause,
	                           boolean enableSuppression,
	                           boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
