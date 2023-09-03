package homework3.services.ExceptionClasses;

import java.io.IOException;

public class InputTooManyValuesException extends IOException {
    public InputTooManyValuesException() {
        super("Введено слишком много значений.");
    }
}
