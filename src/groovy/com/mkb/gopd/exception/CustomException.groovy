package com.mkb.gopd.exception

class CustomException extends RuntimeException {
    private String errorMessage = null;

    public CustomException() {
        super();
    }

    public CustomException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public String toString() {
        return errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
