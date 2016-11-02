package shopingList.exceptions;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class ExceptionHandler {

    public void handle (Exception ex) {

        if (ex.getClass().equals(InputMismatchException.class)) {
            System.out.println("InputMismatchException: input is incorrect");
            System.out.println();
        } else if (ex.getClass().equals(FileNotFoundException.class)) {
            System.out.println("No such file. Specify another path.");
            System.out.println();
        } else if (ex.getClass().equals(InvalidProductParametersException.class)) {
            System.out.println("Specified parameters are not valid for creating a Product");
            System.out.println();
        } else if (ex.getClass().equals(NoSuchItemException.class)){
            System.out.println("There is no such item");
            System.out.println();
        } else {
            System.out.println("Unknown exeption");
            System.out.println();
        }

    }

}
