package com.web.service.common;

public class WebException extends RuntimeException {
    public WebException(String msg)
    {
        super(msg);
    }

    public WebException(Throwable t) {
        super(t);
    }

    public WebException(String msg, Throwable t) {
        super(msg, t);
    }
}
