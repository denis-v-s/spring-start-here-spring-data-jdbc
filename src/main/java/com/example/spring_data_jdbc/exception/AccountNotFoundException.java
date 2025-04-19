package com.example.spring_data_jdbc.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException() {
      super("Account not found");
    }

    public AccountNotFoundException(String message) {
      super(message);
    }

    public AccountNotFoundException(String message, Throwable cause) {
      super(message, cause);
    }

    public AccountNotFoundException(Throwable cause) {
      super(cause);
    }

}
