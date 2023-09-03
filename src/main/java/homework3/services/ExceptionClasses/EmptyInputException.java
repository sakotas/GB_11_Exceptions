package homework3.services.ExceptionClasses;

import java.io.IOException;

public class EmptyInputException extends IOException {
    public EmptyInputException() {
        super("Ввод не может быть пустым.");
    }
}
