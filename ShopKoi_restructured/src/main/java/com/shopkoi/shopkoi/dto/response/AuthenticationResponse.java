package com.shopkoi.shopkoi.dto.response;

public class AuthenticationResponse {
    private String message;
    private boolean result;

    public AuthenticationResponse(String message, boolean result) {
        this.message = message;
        this.result = result;
    }

    // Getter và Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
