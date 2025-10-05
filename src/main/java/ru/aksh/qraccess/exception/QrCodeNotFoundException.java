package ru.aksh.qraccess.exception;

public class QrCodeNotFoundException extends RuntimeException {
    public QrCodeNotFoundException(String message) {
        super(message);
    }
}
