package GeekBrains.Exception.Sem2.Zad4;

import java.io.IOException;

public class EmptyLineException extends IOException {

    public EmptyLineException() {
        super("Введена пустая строка!");
    }
}
