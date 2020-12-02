package dev.ugwulo.firestorm_personal_fin_tracker.exceptions;

public class ZeroBalanceDifferenceException extends Exception {
    public ZeroBalanceDifferenceException(String text) {
        super(text);
    }
}
