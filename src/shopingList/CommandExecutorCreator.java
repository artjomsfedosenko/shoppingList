package shopingList;

import shopingList.Cart;
import shopingList.CommandExecutor;
import shopingList.commands.*;

public class CommandExecutorCreator {

    public CommandExecutor create(Cart cart) {
        Command[] argsForExecutor = new Command[8];

        argsForExecutor[0] = new AddItem();
        argsForExecutor[1] = new ListItems();
        argsForExecutor[2] = new DeleteItem();
        argsForExecutor[3] = new SaveListToFile();
        argsForExecutor[4] = new LoadListFromFile();
        argsForExecutor[5] = new SearchForItemByName();
        argsForExecutor[6] = new SearchItemByPriceRange();
        argsForExecutor[7] = new Exit();

        CommandExecutor cmdExec = new CommandExecutor(cart, argsForExecutor);

        return cmdExec;
    }

}
