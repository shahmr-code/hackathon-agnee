package com.db.hackathon.onlineBanking.exception;

public class DatastoreException extends RuntimeException {

	private static final long serialVersionUID = 1L;

    public DatastoreException(String message) {
        super(message);
    }

    public DatastoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
