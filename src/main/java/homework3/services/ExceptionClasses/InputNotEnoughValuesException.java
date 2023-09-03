package homework3.services.ExceptionClasses;

import java.io.IOException;

public class InputNotEnoughValuesException extends IOException {
    public InputNotEnoughValuesException(String message) {
        super(message);
    }
}
