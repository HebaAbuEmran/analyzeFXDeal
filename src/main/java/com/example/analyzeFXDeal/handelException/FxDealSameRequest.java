package com.example.analyzeFXDeal.handelException;

public class FxDealSameRequest extends RuntimeException{
    public FxDealSameRequest(String message) {
        super(message);
    }

    public FxDealSameRequest(String message, Throwable cause) {
        super(message, cause);
    }
}
