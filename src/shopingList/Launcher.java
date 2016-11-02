package shopingList;

import shopingList.exceptions.ExceptionHandler;
import shopingList.ui.MainMenu;
import java.io.IOException;
import java.util.InputMismatchException;

public class Launcher {

    public static void main (String[] args) {
        Cart cart = new Cart();
        CommandExecutor commandExecutor = new CommandExecutorCreator().create(cart);
        MainMenu mainMenu = new UICreator().create(commandExecutor);
        ExceptionHandler exceptionHandler = new ExceptionHandler();

        while (true) {
            try {
                mainMenu.displayAvailableChoices();
                mainMenu.promptUserToMakeChoice();
            } catch (Exception ex) {
                exceptionHandler.handle(ex);
            }
        }

    }

}
