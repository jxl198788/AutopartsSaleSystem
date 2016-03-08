package com.fjsaas.web.exception;

/**
 * 系统基础异常
 * 
 * 
 */
public class WebAppException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public WebAppException() {
        super();
    }

    public WebAppException(String message) {
        super(message);
    }

    public WebAppException(Throwable cause) {
        super(cause);
    }

    public WebAppException(String message, Throwable cause) {
        super(message, cause);
    }
}
